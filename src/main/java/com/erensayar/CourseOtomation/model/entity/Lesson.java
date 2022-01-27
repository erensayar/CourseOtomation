package com.erensayar.CourseOtomation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Lesson class'i tekil bir derstir(50 dklik). Ogrenciler lesson classini list olarak tutacaktir.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lessonName; // Matematik

    private String classRoom;

    private LocalDateTime lessonStartTime;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private List<Student> student;

}
