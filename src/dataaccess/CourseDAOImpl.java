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
import utilities.InputAssistance;

/**
 *
 * @author matti
 */
public class CourseDAOImpl implements CourseDAO {
    
    InputAssistance ia = new InputAssistance();
    EntityManagerFactory emf = ia.getEmf();

    @Override
    public Course addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(course);
        tx.commit();

        return course;
    }

    @Override
    public Course deleteCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(course));
        tx.commit();

        return course;
    }

    @Override
    public Course updateCourse(Course course, String newName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        course.setName(newName);
        em.merge(course);
        tx.commit();

        return course;
    }

    @Override
    public Course getCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course;
        TypedQuery query = em.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class);
        query.setParameter("id", id);
        course = (Course) query.getSingleResult();

        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();
        
        return courses;
    }

}
