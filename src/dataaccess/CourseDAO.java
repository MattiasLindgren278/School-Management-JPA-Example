package dataaccess;

import java.util.List;
import model.Course;

/**
 *
 * @author matti
 */
public interface CourseDAO {

    public Course addCourse(Course course);

    public Course deleteCourse(Course course);

    public Course updateCourse(Course course, String newName);

    public Course getCourse(int id);

    public List<Course> getAllCourses();
}
