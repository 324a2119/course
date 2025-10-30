package com.example.course.service;

import java.util.List;

import com.example.course.model.Course;
import com.example.course.model.MyList;

public interface CourseService {
    //マイリストの抽出
    List<MyList> getmyList(String email);

    //全講座データの抽出
    List<Course> getCourseList();
}
