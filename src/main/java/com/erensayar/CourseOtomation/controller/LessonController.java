package com.erensayar.CourseOtomation.controller;

import com.erensayar.CourseOtomation.model.dto.LessonDto;
import com.erensayar.CourseOtomation.service.LessonService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Lesson Rest API Documentation")
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
@RestController
public class LessonController {

    private final LessonService lessonService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLessonById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(lessonService.getLessonById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLessons() {
        return new ResponseEntity<>(lessonService.getLessons(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createLesson(@RequestBody LessonDto lessonDto) {
        return new ResponseEntity<>(lessonService.createLesson(lessonDto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateLesson(@RequestBody LessonDto updatedLesson) {
        return new ResponseEntity<>(lessonService.updateLesson(updatedLesson), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteLessonById(@PathVariable("id") Integer id) {
        lessonService.deleteLessonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
