package com.example.course;

import java.util.List;

public interface CourseServiceInterface {

    public String upsert(CourseEntity course);
    public CourseEntity getById(Integer cid);
    public List<CourseEntity> getAllCourses();
    public String deleteById(Integer cid);
}
