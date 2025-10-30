package com.example.course.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.course.model.Course;
import com.example.course.model.MyList;

@Repository
public class CourseDaoImpl implements CourseDao{
    //依存性の注入
    private final JdbcTemplate jdbcTemplate;
    
    public CourseDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MyList> getmyList(String email){
        String sql = "SELECT aid, cid, dt, cst, cen, cname FROM coursetb c JOIN resetb r ON c.cid = r.cid WHERE email=?";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<MyList> list = new ArrayList<MyList>();
        for (Map<String, Object> result : resultList){
            MyList myList = new MyList();
            myList.setAid((int) result.get("aid"));
            myList.setCid((int) result.get("cid"));
            myList.setDt((Date) result.get("dt"));
            myList.setCst((Time) result.get("cst"));
            myList.setCen((Time) result.get("cen"));
            myList.setCname((String) result.get("cname"));
            list.add(myList);

        }
        return list;    
    }

    //全講座データの抽出
    @Override
    public List<Course> getCourseList(){
        String sql = "SELECT cid, dt, cst, cen, cname, price FROM coursetb";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Course> list = new ArrayList<Course>();
        for(Map<String, Object> result : resultList){
            Course course = new Course();
            course.setCid((int) result.get("cid"));
            course.setDt((Date) result.get("dt"));
            course.setCst((Time) result.get("cst"));
            course.setCen((Time) result.get("cen"));
            course.setCname((String) result.get("cname"));
            course.setPrice((int) result.get("price"));
            list.add(course);
        }
        return list;
    }
}
