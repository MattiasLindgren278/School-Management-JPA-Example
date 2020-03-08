package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import listeners.AgeCalculationTeacher;
import utilities.Gender;
import utilities.StringFormatter;

@Entity
@EntityListeners(AgeCalculationTeacher.class)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateofBirth;

    @ManyToMany(mappedBy = "teacherList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courseList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Transient
    private int age;
    @Transient
    StringFormatter st = new StringFormatter();

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, LocalDate dateofBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addCourse(Course course) {
        courseList.add(course);
        course.getTeacherList().add(this);
    }

    public void removeCourse(Course course) {
        courseList.remove(course);
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
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return st.fixLengthString(String.valueOf(id), 4) + st.fixLengthString(firstName, 15) + st.fixLengthString(lastName, 15) + st.fixLengthString(String.valueOf(dateofBirth), 12) + st.fixLengthString(String.valueOf(gender), 8) + st.fixLengthString(String.valueOf(age), 5);
    }

}
