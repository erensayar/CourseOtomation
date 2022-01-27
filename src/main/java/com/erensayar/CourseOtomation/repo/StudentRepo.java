package com.erensayar.CourseOtomation.repo;

import com.erensayar.CourseOtomation.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
