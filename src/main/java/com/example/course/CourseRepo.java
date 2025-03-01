package com.example.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CourseRepo extends JpaRepository<CourseEntity, Serializable> {
}
