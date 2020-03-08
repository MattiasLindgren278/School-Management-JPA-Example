/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Student;
import utilities.InputAssistance;

/**
 *
 * @author matti
 */
public class StudentDAOImpl implements StudentDAO {
    
    InputAssistance ia = new InputAssistance();
    EntityManagerFactory emf = ia.getEmf();

    @Override
    public Student addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
        
        return student;
    }

    @Override
    public Student deleteStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(student));
        tx.commit();
        
        return student;
    }

    @Override
    public Student updateStudent(Student student, String firstName, String lastName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        em.merge(student);
        tx.commit();
        
        return student;
    }

    @Override
    public Student getStudent(int id) {
        EntityManager em = emf.createEntityManager();
        Student student;
        TypedQuery query = em.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class);
        query.setParameter("id", id);
        student = (Student) query.getSingleResult();

        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("SELECT s FROM Student s", Student.class);

        List<Student> students = query.getResultList();
        return students;
    }

}
