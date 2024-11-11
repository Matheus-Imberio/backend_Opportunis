package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
