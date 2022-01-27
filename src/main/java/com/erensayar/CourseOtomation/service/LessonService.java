package com.erensayar.CourseOtomation.service;

import com.erensayar.CourseOtomation.model.dto.LessonDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;
import com.erensayar.CourseOtomation.model.entity.Teacher;

import java.util.List;
import java.util.Set;

public interface LessonService {

    Lesson createLesson(LessonDto lessonDto);

    Lesson getLessonById(Integer id);

    List<Lesson> getLessons();

    Lesson updateLesson(LessonDto lessonDto);

    void deleteLessonById(Integer id);

    Set<Lesson> getLessonsByStudent(Student student);

    Lesson getLessonByTeacher(Teacher teacher);

}
