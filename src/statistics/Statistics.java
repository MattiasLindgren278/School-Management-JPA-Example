package statistics;

import java.util.List;
import java.util.stream.Collectors;
import model.Student;
import model.Teacher;
import service.StudentServiceImpl;
import service.TeacherServiceImpl;

public class Statistics {

    
    StudentServiceImpl studentService = new StudentServiceImpl();
    TeacherServiceImpl teacherService = new TeacherServiceImpl();

    public double getAgeDistrubutionStudent20() {
        List<Student> allStudents = studentService.getAllStudents();

        List<Student> students20To25 = allStudents.stream()
                .filter(s -> (s.getAge() <= 25 && s.getAge() > 20))
                .collect(Collectors.toList());

        double percent = (double) students20To25.size() / (double) allStudents.size();
        return percent;

    }

    public double getAgeDistrubutionStudent25() {
        List<Student> allStudents = studentService.getAllStudents();

        List<Student> students25To30 = allStudents.stream()
                .filter(s -> (s.getAge() <= 30 && s.getAge() > 25))
                .collect(Collectors.toList());

        double percent = (double) students25To30.size() / (double) allStudents.size();
        return percent;

    }

    public double getAgeDistrubutionStudent30() {
        List<Student> allStudents = studentService.getAllStudents();

        List<Student> studentsOver30 = allStudents.stream()
                .filter(s -> s.getAge() > 30)
                .collect(Collectors.toList());

        double percent = (double) studentsOver30.size() / (double) allStudents.size();
        return percent;

    }

    public double getAgeDistrubutionTeacher20() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        List<Teacher> teachers20To25 = allTeachers.stream()
                .filter(s -> (s.getAge() < 25 && s.getAge() > 20))
                .collect(Collectors.toList());

        double percent = (double) teachers20To25.size() / (double) allTeachers.size();
        return percent;

    }
    public double getAgeDistrubutionTeacher25() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        List<Teacher> teachers25To30 = allTeachers.stream()
                .filter(s -> (s.getAge() < 30 && s.getAge() > 25))
                .collect(Collectors.toList());

        double percent = (double) teachers25To30.size() / (double) allTeachers.size();
        return percent;

    }
    public double getAgeDistrubutionTeacher30() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        List<Teacher> teachersOver30 = allTeachers.stream()
                .filter(s -> s.getAge() > 30)
                .collect(Collectors.toList());

        double percent = (double) teachersOver30.size() / (double) allTeachers.size();
        return percent;

    }
}
