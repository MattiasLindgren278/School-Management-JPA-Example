package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import listeners.AgeCalculationStudent;
import utilities.Gender;
import utilities.StringFormatter;

@Entity
@EntityListeners(AgeCalculationStudent.class)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateofBirth;

    @ManyToOne
    private Education education;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Transient
    private int age;
    @Transient
    StringFormatter st = new StringFormatter();

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateofBirth, Gender gender) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setEducation(Education education) {
        this.education = education;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
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
