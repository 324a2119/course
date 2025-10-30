package com.example.course.repository;

import java.util.List;

import com.example.course.model.Course;
import com.example.course.model.MyList;

public interface CourseDao {
    //マイリストの抽出
    List<MyList> getmyList(String email);

    //全講座データの抽出
    List<Course> getCourseList();
}
