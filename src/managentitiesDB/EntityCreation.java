package managentitiesDB;

import java.time.LocalDate;
import model.Course;
import model.Education;
import model.Student;
import model.Teacher;
import utilities.Gender;
import utilities.InputAssistance;

public class EntityCreation {

    InputAssistance ia = new InputAssistance();

    public Education createEducation() {
        System.out.print("Enter name of education: ");
        String name = ia.stringInput();
        System.out.print("Enter education start date 'yyyy-mm-dd': ");
        LocalDate startDate = ia.localDateInput(ia.stringInput());
        System.out.print("Enter education end date 'yyyy-mm-dd': ");
        LocalDate endDate = ia.localDateInput(ia.stringInput());

        Education education = new Education(name, startDate, endDate);
        studentCourseAdder(education);

        return education;

    }

    public void studentCourseAdder(Education education) {
        boolean loop = true;
        while (loop) {
            System.out.println("1. Add course");
            System.out.println("2. Add Student");
            System.out.println("0 Exit");
            int choice = ia.intMenuInput(0, 2, ia.intMenuInput());
            switch (choice) {
                case 1:
                    education.addCourse(createCourse());
                    break;
                case 2:
                    education.addStudent(createStudent());
                    break;
                case 0:
                    loop = false;
                    break;
                default:
            }
        }
    }

    public Teacher createTeacher() {
        System.out.print("Enter teachers firstname: ");
        String firstName = ia.stringInput();
        System.out.print("Enter teachers lastname: ");
        String lastName = ia.stringInput();
        System.out.print("Enter teachers birthdate 'yyyy-mm-dd': ");
        LocalDate dateofBirth = ia.localDateInput(ia.stringInput());
        Gender gender = genderChooser();
        
        Teacher teacher = new Teacher(firstName, lastName, dateofBirth, gender);
        courseAdder(teacher);
        
        return teacher;
    }

    public void courseAdder(Teacher teacher) {
        boolean loop = true;
        while (loop) {
            System.out.println("1. Assign Course to teacher");
            System.out.println("0 Exit");
            int choice = ia.intMenuInput();
            switch (choice) {
                case 1:
                    teacher.addCourse(createCourse());
                    break;
                case 0:
                    loop = false;
                    break;
                default:
            }
        }
    }

    public Course createCourse() {
        System.out.print("Enter course name: ");
        String name = ia.stringInput();
        Course course = new Course(name);
        return course;
    }

    public Student createStudent() {
        System.out.print("Enter students firstname: ");
        String firstName = ia.stringInput();
        System.out.print("Enter students lastname: ");
        String lastName = ia.stringInput();
        System.out.print("Enter student birthdate 'yyyy-mm-dd': ");
        LocalDate dateofBirth = ia.localDateInput(ia.stringInput());
        Gender gender = genderChooser();
        
        Student student = new Student(firstName, lastName, dateofBirth, gender);
        return student;
    }

    public Gender genderChooser() {
        boolean loop = true;
        Gender gender = Gender.OTHER;
        while (loop) {
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            int choice = ia.intMenuInput(1, 3, ia.intMenuInput());
            switch (choice) {
                case 1:
                    gender = Gender.MALE;
                    loop = false;
                    break;
                case 2:
                    gender = Gender.FEMALE;
                    loop = false;
                    break;
                case 3:
                    gender = Gender.OTHER;
                    loop = false;
                    break;
                default:
            }
        }
        return gender;
    }
}
