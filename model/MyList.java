package com.example.course.model;

import java.sql.Time;

import java.sql.Date;

import lombok.Data;

@Data
public class MyList {
    private int aid;
    private String sea;
    private int cid;
    private String httc;
    private String iorg;
    private int attendance;
    private Date dt;
    private Time cst;
    private Time cen;
    private String cname;
}
