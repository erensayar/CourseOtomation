package com.erensayar.CourseOtomation.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// Bu Dto save ve update islemlerinde client'in direkt obje ekleme ve update islemi yapamamasi icin yazildi
// Bu sayede guvenlik zafiyetinin onune gecilmistir
@Getter
@Setter
@Builder
public class StudentDto {
    private Long studentNumber;
    private String name;
    private String surname;
    private String address;
}
