package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ServiceImplement serviceImplement;

    @GetMapping("/test")
    public String test(){
        return "Hi";
    }

    /*@PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody CourseEntity courseEntity){
       String st = serviceImplement.upsert(courseEntity);
       return new ResponseEntity<>(st, HttpStatus.CREATED);
    }*/

    @PostMapping("/createCourse")
    public String createCourse(@RequestBody CourseEntity courseEntity){
        String st = serviceImplement.upsert(courseEntity);
        return "post method";
    }

    @GetMapping("/get/{cid}")
    public ResponseEntity getCourse(@PathVariable Integer cid){
        CourseEntity courseEntity = serviceImplement.getById(cid);
        return new ResponseEntity<>(courseEntity,HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CourseEntity>> getAll(){
        List<CourseEntity> allCourses = serviceImplement.getAllCourses();
        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<String> updateCourse(@RequestBody CourseEntity courseEntity){
        String st = serviceImplement.upsert(courseEntity);
        return new ResponseEntity<>(st,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteById(@PathVariable Integer cid){
        String courseEntity = serviceImplement.deleteById(cid);
        return new ResponseEntity<>(courseEntity,HttpStatus.OK);
    }
}
