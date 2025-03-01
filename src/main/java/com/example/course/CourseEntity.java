package com.example.course;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="COURSE_DTLS")
public class CourseEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String name;
    private double price;

}
