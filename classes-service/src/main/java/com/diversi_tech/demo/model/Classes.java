package com.diversi_tech.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;
    private int course_Id;
    private String class_name;
    private String description;
    private Date start_data;
    private Date end_data;

    public Classes() {
    }

    public Classes(int class_id, int course_Id, String class_name, String description, Date start_data, Date end_data) {
        this.class_id = class_id;
        this.course_Id = course_Id;
        this.class_name = class_name;
        this.description = description;
        this.start_data = start_data;
        this.end_data = end_data;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart_data() {
        return start_data;
    }

    public Date getEnd_data() {
        return end_data;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart_data(Date start_data) {
        this.start_data = start_data;
    }

    public void setEnd_data(Date end_data) {
        this.end_data = end_data;
    }
}
