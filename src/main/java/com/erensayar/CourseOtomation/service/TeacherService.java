package com.erensayar.CourseOtomation.service;

import com.erensayar.CourseOtomation.model.dto.TeacherDto;
import com.erensayar.CourseOtomation.model.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(TeacherDto teacherDto);

    Teacher getTeacherById(Integer id);

    List<Teacher> getTeachers();

    Teacher updateTeacher(TeacherDto teacherDto);

    void deleteTeacherById(Integer id);

}
