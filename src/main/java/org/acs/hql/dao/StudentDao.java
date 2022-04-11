package org.acs.hql.dao;

import org.acs.hql.model.Student;
import org.acs.hql.utility.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
	
	//save student

	public void saveStudent(Student student) {
		Transaction tx = null;
		try(Session session = HibernateUtill.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			
		}
	}
	
	// update 
	public void updateStudent(Student student) {
		Transaction tx = null;
		try(Session session = HibernateUtill.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.saveOrUpdate(student);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			
		}
	}
	
	//getStudent by id
	
	public Student getStudentById(int id) {
		Transaction tx = null;
		Student student = null;
		try(Session session = HibernateUtill.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			student= session.get(Student.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			
		}
		return student;
	}
}
