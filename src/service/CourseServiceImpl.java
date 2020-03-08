/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dataaccess.CourseDAOImpl;
import java.util.List;
import model.Course;

/**
 *
 * @author matti
 */
public class CourseServiceImpl implements CourseService{
    
    CourseDAOImpl courseDAO = new CourseDAOImpl();

    @Override
    public Course addCourse(Course course) {
       return courseDAO.addCourse(course);
    }

    @Override
    public Course deleteCourse(Course course) {
        return courseDAO.deleteCourse(course);
    }

    @Override
    public Course updateCourse(Course course, String newName) {
        return courseDAO.updateCourse(course, newName);
    }

    @Override
    public Course getCourse(int id) {
        return courseDAO.getCourse(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
    
}
