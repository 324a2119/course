package com.example.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.model.Course;
import com.example.course.model.MyList;
import com.example.course.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseDao courseDao;
    public CourseServiceImpl(CourseDao courseDao){
        this.courseDao = courseDao;
    }

    //マイリスト表示
    @Override
    public List<MyList> getmyList(String email){
        List<MyList> list = courseDao.getmyList(email);
        return list;
    }

    @Override
    public List<Course> getCourseList(){
        List<Course> list = courseDao.getCourseList();
        return list;
    }
}