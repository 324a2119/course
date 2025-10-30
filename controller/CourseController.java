package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.course.model.Course;
import com.example.course.model.MyList;
import com.example.course.service.CourseService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @Autowired
    HttpSession session;

    //マイリスト表示
    @GetMapping("/mylist")
    public String mylistDisp(String email, Model model){
        List<MyList> list = courseService.getmyList(email);
        model.addAttribute("rList", list);
        return "mylist";
    }

    //全講座データの抽出
    @GetMapping("/all")
    public String listDisp(Model model){
        List<Course> list = courseService.getCourseList();
        model.addAttribute("cList", list);
        return "courseList";
    }
    
    
}
