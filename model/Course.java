package com.example.course.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class Course {
    private int cid;
    private String cname;
    private int price;
    private Date dt;
    private Time cst;
    private Time cen;
    private int capacity;
    private String cdetail;
    private int currnum;
}
