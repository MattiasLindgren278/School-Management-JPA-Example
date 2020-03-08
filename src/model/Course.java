package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import utilities.StringFormatter;

@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Teacher> teacherList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Education> educationList = new ArrayList<>();

    @Transient
    StringFormatter st = new StringFormatter();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return st.fixLengthString(String.valueOf(id), 4) + st.fixLengthString(name, 15);
    }

}
