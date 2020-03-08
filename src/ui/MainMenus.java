package ui;

import java.util.List;
import javax.persistence.NoResultException;
import model.Course;
import model.Education;
import model.Student;
import model.Teacher;
import service.CourseServiceImpl;
import service.EducationServiceImpl;
import service.StudentServiceImpl;
import service.TeacherServiceImpl;
import statistics.Statistics;
import utilities.InputAssistance;
import utilities.StringFormatter;

public class MainMenus {

    InputAssistance ia = new InputAssistance();
    SecondaryMenus sm = new SecondaryMenus();
    StringFormatter st = new StringFormatter();

    public void mainMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Main menu");
            System.out.println("1. Manage entites");
            System.out.println("2. Retrieve entites");
            System.out.println("3. Statistics menu");
            System.out.println("0. Exit");
            int choice = ia.intMenuInput(0, 3, ia.intMenuInput());
            switch (choice) {
                case 1:
                    entityManagmentMenu();
                    break;
                case 2:
                    entityRetrievalMenu();
                    break;
                case 3:
                    statisticsMenu();
                    break;
                case 0:
                    loop = false;
                    break;
            }
        }

    }

    public void entityManagmentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Entity managment menu");
            System.out.println("1. Education managment");
            System.out.println("2. Course managment");
            System.out.println("3. Teacher managment");
            System.out.println("4. Student managment");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 4, ia.intMenuInput());
            switch (choice) {
                case 1:
                    sm.educationManagmentMenu();
                    break;
                case 2:
                    sm.courseManagmentMenu();
                    break;
                case 3:
                    sm.teacherManagmentMenu();
                    break;
                case 4:
                    sm.studentManagmentMenu();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }

    public void entityRetrievalMenu() {
        boolean loop = true;
        EducationServiceImpl educationService = new EducationServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();

        while (loop) {
            System.out.println("");
            System.out.println("Entity retrieval menu");
            System.out.println("1. Retrieve single education ");
            System.out.println("2. Retrieve all educations");
            System.out.println("3. Retrieve single course");
            System.out.println("4. Retrieve all courses");
            System.out.println("5. Retrieve a teacher");
            System.out.println("6. Retrieve all teachers");
            System.out.println("7. Retrieve a student");
            System.out.println("8. Retrieve all students");
            System.out.println("9. List all courses in an education");
            System.out.println("10.List all students in an education");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 10, ia.intMenuInput());
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter education id: ");
                        Education education = educationService.getEducation(ia.intMenuInput());
                        System.out.println(st.educationHeader());
                        System.out.println(education);
                    } catch (NoResultException e) {
                        System.out.println("No education found, try again.");
                    }

                    break;
                case 2:
                    List<Education> educations = educationService.getAllEducations();
                    if (!educations.isEmpty()) {
                        System.out.println(st.educationHeader());
                        for (Education education : educations) {
                            System.out.println(education);
                        }
                    } else {
                        System.out.println("No educations present.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter course id: ");
                        Course course = courseService.getCourse(ia.intInput());
                        System.out.println(st.courseHeader());
                        System.out.println(course);
                    } catch (NoResultException e) {
                        System.out.println("No course found, try again");
                    }

                    break;
                case 4:
                    List<Course> courses = courseService.getAllCourses();
                    if (!courses.isEmpty()) {
                        System.out.println(st.courseHeader());
                        for (Course course1 : courses) {
                            System.out.println(course1);
                        }
                    } else {
                        System.out.println("No courses present.");
                    }

                    break;
                case 5:
                    try {
                        System.out.print("Enter teacher id: ");
                        Teacher teacher = teacherService.getTeacher(ia.intInput());
                        System.out.println(st.teacherHeader());
                        System.out.println(teacher);
                    } catch (NoResultException e) {
                        System.out.println("No teacher found, try again");
                    }
                    break;
                case 6:
                    List<Teacher> teachers = teacherService.getAllTeachers();
                    if (!teachers.isEmpty()) {
                        System.out.println(st.teacherHeader());
                        for (Teacher teacher1 : teachers) {
                            System.out.println(teacher1);
                        }
                    } else {
                        System.out.println("No teachers present.");
                    }

                    break;
                case 7:
                    try {
                        System.out.print("Enter student id: ");
                        Student student = studentService.getStudent(ia.intInput());
                        System.out.println(st.studentHeader());
                        System.out.println(student);
                    } catch (NoResultException e) {
                        System.out.println("No student found, try again");
                    }

                    break;
                case 8:
                    List<Student> students = studentService.getAllStudents();
                    if (!students.isEmpty()) {
                        System.out.println(st.studentHeader());
                        for (Student student1 : students) {
                            System.out.println(student1);
                        }
                    } else {
                        System.out.println("No students present.");
                    }

                    break;
                case 9:
                    try {
                        System.out.print("Enter education id: ");
                        Education education = educationService.getEducation(ia.intInput());
                        List<Course> courses2 = education.getCourseList();

                        System.out.println(st.educationHeader());
                        System.out.println(education);

                        System.out.println("");
                        if (!courses2.isEmpty()) {
                            System.out.println(st.courseHeader());
                            for (Course course1 : courses2) {
                                System.out.println(course1);
                            }
                        } else {
                            System.out.println("No courses attached to education");
                        }

                    } catch (NoResultException e) {
                        System.out.println("No education present, try again.");
                    }
                    break;
                case 10:
                    try {
                        System.out.print("Enter education id: ");
                        Education education2 = educationService.getEducation(ia.intInput());
                        List<Student> students2 = education2.getStudentList();

                        System.out.println(st.educationHeader());
                        System.out.println(education2);

                        System.out.println("");
                        if (!students2.isEmpty()) {
                            System.out.println(st.studentHeader());
                            for (Student student1 : students2) {
                                System.out.println(student1);
                            }
                        } else {
                            System.out.println("No students attached to education.");
                        }

                    } catch (NoResultException e) {
                        System.out.println("No education present, try again.");
                    }
                case 0:
                    loop = false;
                    break;
                default:
                    break;
            }

        }
    }

    public void statisticsMenu() {
        Statistics s = new Statistics();
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Statistics menu");
            System.out.println("1. Students between 20 and 25.");
            System.out.println("2. Students between 25 and 30.");
            System.out.println("3. Students over 30.");
            System.out.println("4. Teachers between 20 and 25.");
            System.out.println("5. Teachers between 25 and 30.");
            System.out.println("6. Teachers over 30");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 6, ia.intMenuInput());
            switch (choice) {
                case 1:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionStudent20());
                        System.out.println("Students between 20 and 25 years is " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No students present in database.");
                    }
                    break;
                case 2:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionStudent25());
                        System.out.println("Students between 25 and 30 years is " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No students present in database.");
                    }
                    break;
                case 3:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionStudent30());
                        System.out.println("Students over 30 years " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No students present in database.");
                    }
                    break;
                case 4:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionTeacher20());
                        System.out.println("Teachers between 20 and 25 years " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No teachers present in database.");
                    }
                    break;
                case 5:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionTeacher25());
                        System.out.println("Teachers between 25 and 30 years " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No teachers present in database.");
                    }
                    break;
                case 6:
                    try {
                        String result = ia.percantageConverter(s.getAgeDistrubutionTeacher30());
                        System.out.println("Teachers over 30 years " + result + ".");
                    } catch (ArithmeticException e) {
                        System.out.println("No teachers present in database.");
                    }
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}
