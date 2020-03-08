/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Course;

/**
 *
 * @author matti
 */
public interface CourseService {

    public Course addCourse(Course course);

    public Course deleteCourse(Course course);

    public Course updateCourse(Course course, String newName);

    public Course getCourse(int id);

    public List<Course> getAllCourses();

}
