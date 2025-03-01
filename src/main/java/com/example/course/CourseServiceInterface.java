package com.example.course;

import java.util.List;

public interface CourseServiceInterface {

    public abstract String upsert(CourseEntity course);
    public CourseEntity getById(Integer cid);
    public List<CourseEntity> getAllCourses();
    public void deleteById(Integer cid);
}
