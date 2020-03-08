package service;

import java.util.List;
import model.Course;
import model.Teacher;

public interface TeacherService {

    public Teacher addTeacher(Teacher teacher);

    public Teacher deleteTeacher(Teacher teacher);

    public Teacher updateTeacher(Teacher teacher, String firstName, String lastName);

    public Course assignCourseToTeacher(Teacher teacher, Course course);
    
    public Course removeCourseFromTeacher(Teacher teacher, Course course);

    public Teacher getTeacher(int id);

    public List<Teacher> getAllTeachers();
}
