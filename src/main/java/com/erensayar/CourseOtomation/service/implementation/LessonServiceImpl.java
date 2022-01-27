package com.erensayar.CourseOtomation.service.implementation;

import com.erensayar.CourseOtomation.error.exception.BadRequestException;
import com.erensayar.CourseOtomation.error.exception.NoContentException;
import com.erensayar.CourseOtomation.model.dto.LessonDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;
import com.erensayar.CourseOtomation.model.entity.Teacher;
import com.erensayar.CourseOtomation.repo.LessonRepo;
import com.erensayar.CourseOtomation.service.LessonService;
import com.erensayar.CourseOtomation.service.StudentService;
import com.erensayar.CourseOtomation.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;

    private TeacherService teacherService;
    private StudentService studentService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Lesson createLesson(LessonDto lessonDto) {
        // Controls
        lessonDto.setId(null);
        conflictControlForClasses(lessonDto);
        checkLessonTime(lessonDto.getLessonStartTime());

        return lessonRepo.save(converterOfLesson(lessonDto));
    }

    @Override
    public Lesson getLessonById(Integer id) {
        return lessonRepo.findById(id).orElseThrow(NoContentException::new);
    }

    @Override
    public List<Lesson> getLessons() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson updateLesson(LessonDto lessonDto) {
        // Controls
        if (lessonDto.getId() == null) {
            throw new BadRequestException("Ders Id'si boş bırakılamaz."); //Daha generic olmasi icin error tablosu olusturup mesajlar ve error code'lar oradan alinmali
        }
        checkLessonTime(lessonDto.getLessonStartTime());
        this.getLessonById(lessonDto.getId()); // db'de boyle bir kayit var mi kontrol edilir, yoksa hata firlatilir

        return lessonRepo.save(converterOfLesson(lessonDto));
    }

    @Override
    public void deleteLessonById(Integer id) {
        lessonRepo.deleteById(id);
    }

    @Override
    public Set<Lesson> getLessonsByStudent(Student student) {
        List<Lesson> lessonsAsList = lessonRepo.findLessonsByStudent(student);
        if (lessonsAsList != null && lessonsAsList.size() > 0) {
            return new HashSet<>(lessonsAsList);
        }
        return null;
    }

    @Override
    public Lesson getLessonByTeacher(Teacher teacher) {
        return lessonRepo.findLessonByTeacher(teacher);
    }


    private Lesson converterOfLesson(LessonDto lessonDto) {
        return Lesson.builder()
                .id(lessonDto.getId())
                .lessonName(lessonDto.getLessonName())
                .classRoom(lessonDto.getClassRoom())
                .lessonStartTime(lessonDto.getLessonStartTime())
                .teacher(teacherService.getTeacherById(lessonDto.getTeacherId()))
                .student(studentService.getStudentsByIdList(lessonDto.getStudentIdList()))
                .build();
    }

    private void conflictControlForClasses(LessonDto lessonDto) {
        for (Lesson lessonInDb : this.getLessons()) {
            if (lessonInDb.getClassRoom().equals(lessonDto.getClassRoom())
                    && lessonInDb.getLessonStartTime().isEqual(lessonDto.getLessonStartTime())) {
                throw new BadRequestException("Sınıfta bu saatte farklı bir ders işleniyor!");
            }
        }
    }

    private void checkLessonTime(LocalDateTime lessonStartTime) {
        // 12 ve 16 saatleri paydos saatleri ders konulamaz
        if (lessonStartTime.getHour() == 12 || lessonStartTime.getHour() == 16) {
            throw new BadRequestException("Bu saate ders ayarlanamaz!"); //Daha generic olmasi icin error tablosu olusturup mesajlar ve error code'lar oradan alinmali
        }
    }

}
