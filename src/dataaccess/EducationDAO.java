/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import model.Course;
import model.Education;
import model.Student;

/**
 *
 * @author matti
 */
public interface EducationDAO {
    
    public Education addEducation(Education education);

    public Education deleteEducation(Education education);

    public Education updateEducation(Education education, String newName);
    
    public Course assignCourseToEducation(Education education, Course course);
    
    public Course removeCourseFromEducation(Education education, Course course);
    
    public Student assignStudentToEducation(Education education, Student student);
    
    public Student removeStudentFromEducation(Education education, Student student);

    public Education getEducation(int id);

    public List<Education> getAllEducations();
    
}
