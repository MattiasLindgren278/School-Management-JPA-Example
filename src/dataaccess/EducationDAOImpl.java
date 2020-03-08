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
import model.Course;
import model.Education;
import model.Student;
import utilities.InputAssistance;

/**
 *
 * @author matti
 */
public class EducationDAOImpl implements EducationDAO {

    InputAssistance ia = new InputAssistance();
    EntityManagerFactory emf = ia.getEmf();

    @Override
    public Education addEducation(Education education) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(education);
        tx.commit();
        
        return education;
    }

    @Override
    public Education deleteEducation(Education education) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(education));
        tx.commit();
        
        return education;
    }

    @Override
    public Education updateEducation(Education education, String newName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        education.setName(newName);
        em.merge(education);
        tx.commit();
        
        return education;
    }

    @Override
    public Course assignCourseToEducation(Education education, Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        education.addCourse(course);
        em.merge(education);
        tx.commit();
        
        return course;
    }

    @Override
    public Course removeCourseFromEducation(Education education, Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        education.removeCourse(course);
        em.merge(education);
        tx.commit();
        
        return course;
    }

    @Override
    public Student assignStudentToEducation(Education education, Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        education.addStudent(student);
        em.merge(education);
        tx.commit();
        
        return student;
    }

    @Override
    public Student removeStudentFromEducation(Education education, Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        education.removeStudent(student);
        em.merge(education);
        tx.commit();
        
        return student;
    }
    
    @Override
    public Education getEducation(int id) {
        EntityManager em = emf.createEntityManager();
        Education education;
        TypedQuery query = em.createQuery("SELECT e FROM Education e WHERE e.id = :id", Education.class);
        query.setParameter("id", id);
        education = (Education) query.getSingleResult();

        return education;
    }

    @Override
    public List<Education> getAllEducations() {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> educations = query.getResultList();

        return educations;
    }

    

}
