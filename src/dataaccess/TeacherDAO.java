/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import model.Course;
import model.Teacher;

/**
 *
 * @author matti
 */
public interface TeacherDAO {
    
    public Teacher addTeacher(Teacher teacher);

    public Teacher deleteTeacher(Teacher teacher);

    public Teacher updateTeacher(Teacher teacher, String firstName, String lastName);
    
    public Course assignCourseToTeacher(Teacher teacher, Course course);
    
    public Course removeCourseFromTeacher(Teacher teacher, Course course);

    public Teacher getTeacher(int id);

    public List<Teacher> getAllTeachers();
    
}
