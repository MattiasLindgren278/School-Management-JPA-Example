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
import model.Teacher;
import utilities.InputAssistance;

/**
 *
 * @author matti
 */
public class TeacherDAOImpl implements TeacherDAO {

    InputAssistance ia = new InputAssistance();
    EntityManagerFactory emf = ia.getEmf();

    @Override
    public Teacher addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teacher);
        tx.commit();

        return teacher;
    }

    @Override
    public Teacher deleteTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(teacher));
        tx.commit();

        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, String firstName, String lastName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        em.merge(teacher);
        tx.commit();

        return teacher;
    }

    @Override
    public Course assignCourseToTeacher(Teacher teacher, Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        teacher.addCourse(course);
        em.merge(teacher);
        tx.commit();
        
        return course;
    }
    
    @Override
    public Course removeCourseFromTeacher(Teacher teacher, Course course){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        teacher.removeCourse(course);
        em.merge(teacher);
        tx.commit();
        
        return course;
    }

    @Override
    public Teacher getTeacher(int id) {
        EntityManager em = emf.createEntityManager();
        Teacher teacher;
        TypedQuery query = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class);
        query.setParameter("id", id);
        teacher = (Teacher) query.getSingleResult();

        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = query.getResultList();

        return teachers;
    }

}
