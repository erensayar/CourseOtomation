package com.erensayar.CourseOtomation.service.implementation;

import com.erensayar.CourseOtomation.error.exception.BadRequestException;
import com.erensayar.CourseOtomation.error.exception.NoContentException;
import com.erensayar.CourseOtomation.model.dto.TeacherDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Teacher;
import com.erensayar.CourseOtomation.repo.TeacherRepo;
import com.erensayar.CourseOtomation.service.LessonService;
import com.erensayar.CourseOtomation.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public Teacher createTeacher(TeacherDto teacherDto) {
        teacherDto.setId(null);
        return teacherRepo.save(converterOfTeacher(teacherDto));
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepo.findById(id).orElseThrow(NoContentException::new);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher updateTeacher(TeacherDto teacherDto) {
        if (teacherDto.getId() == null) {
            throw new BadRequestException("Id giriniz");
        }
        this.getTeacherById(teacherDto.getId());  // db'de boyle bir kayit var mi kontrol edilir, yoksa hata firlatilir
        return teacherRepo.save(converterOfTeacher(teacherDto));
    }

    @Override
    public void deleteTeacherById(Integer id) {
        // First of all delete relations
        Lesson lesson = lessonService.getLessonByTeacher(this.getTeacherById(id));
        lesson.setTeacher(null);
        // Then we can delete
        teacherRepo.deleteById(id);
    }

    private Teacher converterOfTeacher(TeacherDto teacherDto) {
        return Teacher.builder()
                .id(teacherDto.getId())
                .name(teacherDto.getName())
                .surname(teacherDto.getSurname())
                .title(teacherDto.getTitle())
                .build();
    }
}
