/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dataaccess.StudentDAOImpl;
import java.util.List;
import model.Student;

/**
 *
 * @author matti
 */
public class StudentServiceImpl implements StudentService{
    
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Override
    public Student addStudent(Student student) {
       return studentDAO.addStudent(student);
    }

    @Override
    public Student deleteStudent(Student student) {
        return studentDAO.deleteStudent(student);
    }

    @Override
    public Student updateStudent(Student student, String firstName, String lastName) {
        return studentDAO.updateStudent(student, firstName, lastName);
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
    
}
