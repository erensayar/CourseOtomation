package com.erensayar.CourseOtomation.service;

import com.erensayar.CourseOtomation.model.dto.LessonDtoForStudent;
import com.erensayar.CourseOtomation.model.dto.StudentDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentDto studentDto);

    Student getStudentById(Long id);

    List<Student> getStudents();

    Student updateStudent(StudentDto studentDto);

    void deleteStudentById(Long id);

    List<LessonDtoForStudent> getLessonsOfStudent(Long studentNumber);

    // sadece idlerin oldugu bir liste ile objeleri cekebilmek icin
    List<Student> getStudentsByIdList(List<Long> studentIdList);
}
