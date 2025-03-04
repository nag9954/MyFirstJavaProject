package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getCourse/{cid}")
    public CourseResponse getCourse(@PathVariable Integer cid){
        CourseResponse courseResponse = new CourseResponse();
        CourseEntity courseEntity = serviceImplement.getById(cid);
        if(courseEntity!=null){
            courseResponse.setCourseEntity(courseEntity);
        }else {
            courseResponse.setResponse("No Record Found");
        }

        return courseResponse;
    }



    @PutMapping("/updateCourse")
    public String updateCourse(@RequestBody CourseEntity courseEntity){
        String st = serviceImplement.upsert(courseEntity);
        return "String record Updated";
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteById(@PathVariable Integer cid){
//        String courseEntity = serviceImplement.deleteById(cid);
//        return new ResponseEntity<>(courseEntity,HttpStatus.OK);
//    }
//    @DeleteMapping("/deletemap/{cid}")
//    public String deleteById(@PathVariable Integer cid ){
//        String status = serviceImplement.deleteById(cid);
//        return "Deleted";
//    }

    @DeleteMapping("/Delete/{cid}")
    public String deleteById(@PathVariable Integer cid){
           serviceImplement.deleteById(cid);
            return "Deleted the course id "+cid;
    }

    @GetMapping("/getAllData")
    public List<CourseEntity> getAll(){
        List<CourseEntity> all = serviceImplement.getAllCourses();
        return all;
    }


}

