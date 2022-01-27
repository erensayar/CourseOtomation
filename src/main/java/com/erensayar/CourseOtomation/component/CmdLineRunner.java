package com.erensayar.CourseOtomation.component;

import com.erensayar.CourseOtomation.model.dto.LessonDto;
import com.erensayar.CourseOtomation.model.dto.StudentDto;
import com.erensayar.CourseOtomation.model.dto.TeacherDto;
import com.erensayar.CourseOtomation.model.entity.Lesson;
import com.erensayar.CourseOtomation.model.entity.Student;
import com.erensayar.CourseOtomation.model.entity.Teacher;
import com.erensayar.CourseOtomation.repo.LessonRepo;
import com.erensayar.CourseOtomation.service.LessonService;
import com.erensayar.CourseOtomation.service.StudentService;
import com.erensayar.CourseOtomation.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Bu class test datasi olusturmak icin yazildi
 */
@RequiredArgsConstructor
@Component
public class CmdLineRunner implements CommandLineRunner {

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final LessonService lessonService;
    private final LessonRepo lessonRepo;


    @Override
    public void run(String... args) throws Exception {

        Student student1 = studentService.createStudent(
                StudentDto.builder()
                        .name("Eren")
                        .surname("Ali")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student2 = studentService.createStudent(
                StudentDto.builder()
                        .name("Merve")
                        .surname("Yılmaz")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student3 = studentService.createStudent(
                StudentDto.builder()
                        .name("Egor")
                        .surname("Mikhailovic")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student4 = studentService.createStudent(
                StudentDto.builder()
                        .name("Ebru")
                        .surname("Sayar")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student5 = studentService.createStudent(
                StudentDto.builder()
                        .name("Sıla")
                        .surname("Ali")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student6 = studentService.createStudent(
                StudentDto.builder()
                        .name("Mehmet")
                        .surname("Ali")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student7 = studentService.createStudent(
                StudentDto.builder()
                        .name("Johny")
                        .surname("Lesh")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student8 = studentService.createStudent(
                StudentDto.builder()
                        .name("Vladimir")
                        .surname("Fyodor")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student9 = studentService.createStudent(
                StudentDto.builder()
                        .name("Fyodor")
                        .surname("Mikhael")
                        .address("hedehödö sokak")
                        .build()

        );

        Student student10 = studentService.createStudent(
                StudentDto.builder()
                        .name("DENEME")
                        .surname("DENEME")
                        .address("DENEMEDENEMEDENEME")
                        .build()

        );

        //<===================================================>

        Teacher teacher1 = teacherService.createTeacher(
                TeacherDto.builder()
                        .name("Harold")
                        .surname("Smith")
                        .title("Matematik")
                        .build()
        );

        Teacher teacher2 = teacherService.createTeacher(
                TeacherDto.builder()
                        .name("Aragorn")
                        .surname("Elessar")
                        .title("Matematik")
                        .build()
        );

        Teacher teacher3 = teacherService.createTeacher(
                TeacherDto.builder()
                        .name("Harry")
                        .surname("Potter")
                        .title("Matematik")
                        .build()
        );

        Teacher teacher4 = teacherService.createTeacher(
                TeacherDto.builder()
                        .name("Feridun")
                        .surname("Yılmaz")
                        .title("Türkçe")
                        .build()
        );

        Teacher teacher5 = teacherService.createTeacher(
                TeacherDto.builder()
                        .name("Sinem")
                        .surname("Elmalı")
                        .title("Türkçe")
                        .build()
        );


        //<===================================================>
        List<Long> studentList1 = new ArrayList<>();
        studentList1.add(student1.getStudentNumber());
        studentList1.add(student2.getStudentNumber());
        studentList1.add(student3.getStudentNumber());
        studentList1.add(student4.getStudentNumber());

        List<Long> studentList2 = new ArrayList<>();
        studentList2.add(student5.getStudentNumber());
        studentList2.add(student6.getStudentNumber());
        studentList2.add(student7.getStudentNumber());

        List<Long> studentList3 = new ArrayList<>();
        studentList3.add(student8.getStudentNumber());
        studentList3.add(student9.getStudentNumber());

        Lesson lesson1 = lessonService.createLesson(
                LessonDto.builder()
                        .lessonName("Matematik")
                        .classRoom("A-3")
                        .lessonStartTime(LocalDateTime.of(2022, 1, 27, 8, 0))
                        .teacherId(teacher1.getId())
                        .studentIdList(studentList1)
                        .build()
        );


        Lesson lesson2 = lessonService.createLesson(
                LessonDto.builder()
                        .lessonName("Matematik")
                        .classRoom("A-4")
                        .lessonStartTime(LocalDateTime.of(2022, 1, 27, 8, 0))
                        .teacherId(teacher2.getId())
                        .studentIdList(studentList1)
                        .build()
        );

        Lesson lesson3 = lessonService.createLesson(
                LessonDto.builder()
                        .lessonName("Matematik")
                        .classRoom("A-5")
                        .lessonStartTime(LocalDateTime.of(2022, 1, 27, 8, 0))
                        .teacherId(teacher3.getId())
                        .studentIdList(studentList1)
                        .build()
        );

        Lesson lesson4 = lessonService.createLesson(
                LessonDto.builder()
                        .lessonName("Türkçe")
                        .classRoom("A-3")
                        .lessonStartTime(LocalDateTime.of(2022, 1, 27, 13, 0))
                        .teacherId(teacher4.getId())
                        .studentIdList(studentList1)
                        .build()
        );


        Lesson lesson5 = lessonService.createLesson(
                LessonDto.builder()
                        .lessonName("Türkçe")
                        .classRoom("A-4")
                        .lessonStartTime(LocalDateTime.of(2022, 1, 27, 13, 0))
                        .teacherId(teacher5.getId())
                        .studentIdList(studentList1)
                        .build()
        );

        // hibernate methods test
        // System.out.println("###################################");
        // for (Lesson l : lessonRepo.findLessonsByStudent(student1)) {
        //     System.out.println(l.getId() + l.getLessonName());
        // }
        // System.out.println("###################################");
        // System.out.println(lessonRepo.findLessonByTeacher(teacher1).getTeacher().getName());
        // System.out.println(lessonRepo.findLessonByTeacher(teacher2).getTeacher().getName());
        // System.out.println(lessonRepo.findLessonByTeacher(teacher3).getTeacher().getName());
        // System.out.println(lessonRepo.findLessonByTeacher(teacher4).getTeacher().getName());
        // System.out.println(lessonRepo.findLessonByTeacher(teacher5).getTeacher().getName());

    }
}
