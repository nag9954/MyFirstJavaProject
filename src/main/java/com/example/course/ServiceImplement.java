package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplement implements CourseServiceInterface {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String upsert(CourseEntity course) {
        courseRepo.save(course);
        return "Save method execute";
    }


    @Override
    public CourseEntity getById(Integer cid) {
        Optional<CourseEntity> findById = courseRepo.findById(cid);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void deleteById(Integer cid) {
        if (courseRepo.existsById(cid)){
            courseRepo.deleteById(cid);
        }

    }
}
