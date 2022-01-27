package com.erensayar.CourseOtomation.service.implementation;

import com.erensayar.CourseOtomation.error.exception.BadRequestException;
import com.erensayar.CourseOtomation.error.exception.NoContentException;
import com.erensayar.CourseOtomation.model.dto.LessonDtoForStudent;
import com.erensayar.CourseOtomation.model.dto.StudentDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;
import com.erensayar.CourseOtomation.repo.StudentRepo;
import com.erensayar.CourseOtomation.service.LessonService;
import com.erensayar.CourseOtomation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public Student createStudent(StudentDto studentDto) {
        studentDto.setStudentNumber(null);
        return studentRepo.save(converterOfStudent(studentDto));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(NoContentException::new);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(StudentDto studentDto) {
        if (studentDto.getStudentNumber() == null) {
            throw new BadRequestException("Id giriniz");
        }
        this.getStudentById(studentDto.getStudentNumber());  // db'de boyle bir kayit var mi kontrol edilir, yoksa hata firlatilir
        Student updatedStudent = converterOfStudent(studentDto);
        return studentRepo.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        // First of all delete relations
        Set<Lesson> lessons = lessonService.getLessonsByStudent(this.getStudentById(id));
        if (lessons != null) {
            for (Lesson lessonInDb : lessons) {
                lessonInDb.getStudent().removeIf(s -> s.getStudentNumber().equals(id));
            }
        }
        // Then we can delete
        studentRepo.deleteById(id);
    }

    @Override
    public List<LessonDtoForStudent> getLessonsOfStudent(Long studentNumber) {
        Student student = this.getStudentById(studentNumber);
        Set<Lesson> lessons = lessonService.getLessonsByStudent(student);
        if (lessons != null) {
            List<LessonDtoForStudent> lessonDtoList = new ArrayList<>();
            for (Lesson l : lessons) {
                lessonDtoList.add(
                        LessonDtoForStudent.builder()
                                .lessonName(l.getLessonName())
                                .classRoom(l.getClassRoom())
                                .lessonStartTime(l.getLessonStartTime())
                                .teacherName(l.getTeacher().getName() + " " + l.getTeacher().getSurname())
                                .build()
                );
            }
            return lessonDtoList;
        }
        throw new NoContentException();
    }

    public List<Student> getStudentsByIdList(List<Long> idList) {
        List<Student> studentList = new ArrayList<>();
        for (Long studentInDb : idList) {
            studentList.add(this.getStudentById(studentInDb));
        }
        return studentList;
    }

    private Student converterOfStudent(StudentDto studentDto) {
        return Student.builder()
                .studentNumber(studentDto.getStudentNumber())
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .address(studentDto.getAddress())
                .build();
    }
}
