package ui;

import managentitiesDB.EntityCreation;
import model.Course;
import model.Education;
import model.Student;
import model.Teacher;
import service.CourseServiceImpl;
import service.EducationServiceImpl;
import service.StudentServiceImpl;
import service.TeacherServiceImpl;
import utilities.InputAssistance;

public class SecondaryMenus {

    InputAssistance ia = new InputAssistance();
    EntityCreation ec = new EntityCreation();
    EducationServiceImpl educationService = new EducationServiceImpl();
    StudentServiceImpl studentService = new StudentServiceImpl();
    CourseServiceImpl courseService = new CourseServiceImpl();
    TeacherServiceImpl teacherService = new TeacherServiceImpl();

    public void educationManagmentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Education Managment Menu");
            System.out.println("1. Add new Education");
            System.out.println("2. Add student to existing education");
            System.out.println("3. Add course to existing education");
            System.out.println("4. Remove student from existing education");
            System.out.println("5. Remove course from existing education");
            System.out.println("6. Update education name");
            System.out.println("7. Remove education");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 7, ia.intMenuInput());
            switch (choice) {
                case 1:
                    educationService.addEducation(ec.createEducation());
                    break;
                case 2:
                    System.out.print("Enter education id: ");
                    Education education = educationService.getEducation(ia.intInput());
                    System.out.print("Enter student id: ");
                    Student student = studentService.getStudent(ia.intInput());
                    educationService.assignStudentToEducation(education, student);
                    break;
                case 3:
                    System.out.print("Enter education id: ");
                    Education educationOne = educationService.getEducation(ia.intInput());
                    System.out.print("Enter course id: ");
                    Course courseOne = courseService.getCourse(ia.intInput());
                    educationService.assignCourseToEducation(educationOne, courseOne);
                    break;
                case 4:
                    Education educationTwo = educationService.getEducation(ia.intInput());
                    Student studentTwo = studentService.getStudent(ia.intInput());
                    educationService.removeStudentFromEducation(educationTwo, studentTwo);
                    break;
                case 5:
                    Education educationThree = educationService.getEducation(ia.intInput());
                    Course courseThree = courseService.getCourse(ia.intInput());
                    educationService.removeCourseFromEducation(educationThree, courseThree);
                    break;
                case 6:
                    educationService.updateEducation(educationService.getEducation(ia.intMenuInput()), ia.stringInput());
                    break;
                case 7:
                    educationService.deleteEducation(educationService.getEducation(ia.intMenuInput()));
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    break;

            }

        }
    }

    public void courseManagmentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Course Managment Menu");
            System.out.println("1. Add new course");
            System.out.println("2. Update course name");
            System.out.println("3. Remove course");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 3, ia.intMenuInput());
            switch (choice) {
                case 1:
                    courseService.addCourse(ec.createCourse());
                    break;
                case 2:
                    courseService.updateCourse(courseService.getCourse(ia.intMenuInput()), ia.stringInput());
                    break;
                case 3:
                    courseService.deleteCourse(courseService.getCourse(ia.intMenuInput()));
                case 0:
                    loop = false;
                    break;
                default:
                    loop = false;
                    break;

            }

        }
    }

    public void studentManagmentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Course Managment Menu");
            System.out.println("1. Add new student");
            System.out.println("2. Update student name");
            System.out.println("3. Remove student");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 3, ia.intMenuInput());
            switch (choice) {
                case 1:
                    studentService.addStudent(ec.createStudent());
                    break;
                case 2:
                    studentService.updateStudent(studentService.getStudent(ia.intMenuInput()), ia.stringInputConsole(), ia.stringInputConsole());
                    break;
                case 3:
                    studentService.deleteStudent(studentService.getStudent(ia.intMenuInput()));
                case 0:
                    loop = false;
                    break;
                default:
                    loop = false;
                    break;

            }

        }
    }

    public void teacherManagmentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Course Managment Menu");
            System.out.println("1. Add new teacher");
            System.out.println("2. Update teacher name");
            System.out.println("3. Remove teacher");
            System.out.println("4. Assign course to teacher");
            System.out.println("5. Remove course from teacher");
            System.out.println("0. Back");
            int choice = ia.intMenuInput(0, 4, ia.intMenuInput());
            switch (choice) {
                case 1:
                    teacherService.addTeacher(ec.createTeacher());
                    break;
                case 2:
                    teacherService.updateTeacher(teacherService.getTeacher(ia.intMenuInput()), ia.stringInputConsole(), ia.stringInputConsole());
                    break;
                case 3:
                    teacherService.deleteTeacher(teacherService.getTeacher(ia.intMenuInput()));
                    break;
                case 4:
                    System.out.print("Enter teacher id: ");
                    Teacher teacher = teacherService.getTeacher(ia.intInput());
                    System.out.print("Enter course id: ");
                    Course course = courseService.getCourse(ia.intInput());
                    teacherService.assignCourseToTeacher(teacher, course);
                case 5:
                    System.out.print("Enter teacher id: ");
                    Teacher teacherOne = teacherService.getTeacher(ia.intInput());
                    System.out.print("Enter course id: ");
                    Course courseOne = courseService.getCourse(ia.intInput());
                    teacherService.removeCourseFromTeacher(teacherOne, courseOne);
                case 0:
                    loop = false;
                    break;
                default:
                    break;

            }

        }
    }
}
