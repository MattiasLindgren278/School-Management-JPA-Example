package service;

import dataaccess.TeacherDAOImpl;
import java.util.List;
import model.Course;
import model.Teacher;

/**
 *
 * @author matti
 */
public class TeacherServiceImpl implements TeacherService {

    TeacherDAOImpl teacherDAO = new TeacherDAOImpl();

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherDAO.addTeacher(teacher);
    }

    @Override
    public Teacher deleteTeacher(Teacher teacher) {
        return teacherDAO.deleteTeacher(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, String firstName, String lastName) {
        return teacherDAO.updateTeacher(teacher, firstName, lastName);
    }

    @Override
    public Course assignCourseToTeacher(Teacher teacher, Course course) {
        return teacherDAO.assignCourseToTeacher(teacher, course);
    }
    
    @Override
    public Course removeCourseFromTeacher(Teacher teacher, Course course){
        return teacherDAO.removeCourseFromTeacher(teacher, course);
    }

    @Override
    public Teacher getTeacher(int id) {
        return teacherDAO.getTeacher(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

}
