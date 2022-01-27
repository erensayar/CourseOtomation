package com.erensayar.CourseOtomation.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// Bu Dto save ve update islemlerinde client'in direkt obje ekleme ve update islemi yapamamasi icin yazildi
// Bu sayede guvenlik zafiyetinin onune gecilmistir
@Getter
@Setter
@Builder
public class LessonDto {
    private Integer id;
    private String lessonName;
    private String classRoom;
    private LocalDateTime lessonStartTime;
    private Integer teacherId; // Just teacher id received not all teacher object
    private List<Long> studentIdList;// Just student id received not all student object
}
