/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dataaccess.EducationDAOImpl;
import java.util.List;
import model.Course;
import model.Education;
import model.Student;

/**
 *
 * @author matti
 */
public class EducationServiceImpl implements EducationService {

    EducationDAOImpl educationDAO = new EducationDAOImpl();

    @Override
    public Education addEducation(Education education) {
        return educationDAO.addEducation(education);
    }

    @Override
    public Education deleteEducation(Education education) {
        return educationDAO.deleteEducation(education);
    }

    @Override
    public Education updateEducation(Education education, String newName) {
        return educationDAO.updateEducation(education, newName);
    }

    @Override
    public Course assignCourseToEducation(Education education, Course course) {
        return educationDAO.assignCourseToEducation(education, course);
    }

    @Override
    public Course removeCourseFromEducation(Education education, Course course) {
        return educationDAO.removeCourseFromEducation(education, course);
    }

    @Override
    public Student assignStudentToEducation(Education education, Student student) {
        return educationDAO.assignStudentToEducation(education, student);
    }

    @Override
    public Student removeStudentFromEducation(Education education, Student student) {
       return educationDAO.removeStudentFromEducation(education, student);
    }

    @Override
    public Education getEducation(int id) {
        return educationDAO.getEducation(id);
    }

    @Override
    public List<Education> getAllEducations() {
        return educationDAO.getAllEducations();
    }

}
