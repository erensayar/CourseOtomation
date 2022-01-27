package com.erensayar.CourseOtomation.repo;

import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;
import com.erensayar.CourseOtomation.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Integer> {

    List<Lesson> findLessonsByStudent(Student student);

    Lesson findLessonByTeacher(Teacher teacher);

}
