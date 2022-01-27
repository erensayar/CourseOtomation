package com.erensayar.CourseOtomation.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    @TableGenerator(name = "Student_Gen", pkColumnName = "STUDENT_ID", valueColumnName = "studentNumber",
            pkColumnValue = "Student_Gen", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Student_Gen")
    @Id
    private Long studentNumber;

    private String name;

    private String surname;

    private String address;
}