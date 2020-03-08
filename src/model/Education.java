package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import utilities.StringFormatter;

@Entity
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany(mappedBy = "educationList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courseList = new ArrayList<>();

    @OneToMany(mappedBy = "education", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Student> studentList = new ArrayList<>();

    @Transient
    StringFormatter st = new StringFormatter();

    public Education() {
    }

    public Education(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
        course.getEducationList().add(this);
    }

    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.setEducation(this);
    }

    public void removeStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return st.fixLengthString(String.valueOf(id), 4) + st.fixLengthString(name, 15) + st.fixLengthString(String.valueOf(startDate), 12) + st.fixLengthString(String.valueOf(endDate), 12);
    }

}
