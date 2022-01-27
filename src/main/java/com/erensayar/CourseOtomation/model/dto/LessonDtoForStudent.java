package com.erensayar.CourseOtomation.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LessonDtoForStudent {
    private String lessonName;
    private String classRoom;
    private LocalDateTime lessonStartTime;
    private String teacherName;
}
