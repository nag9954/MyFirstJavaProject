package com.example.course;

import java.util.List;

public interface ServiceImplementt {
    String upsert(CourseEntity course);

    CourseEntity getById(Integer cid);

    List<CourseEntity> getAllCourses();

    String deleteById(Integer cid);
}
