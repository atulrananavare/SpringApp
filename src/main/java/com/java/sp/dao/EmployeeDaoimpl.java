package com.java.sp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.sp.entitites.EmployeeEn;

@Repository
public class EmployeeDaoimpl implements EmployeeDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public String insertEmployeeRecord(EmployeeEn emp) {
		Session session  = null;
		Transaction tr = null;
		try {
			session  = sessionFactory.openSession();
			tr = session.beginTransaction();
			session.save(emp);
			return "Employee Successfully Added";
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in save");
			return "Problem in save";
		}finally {
			session.flush();
			tr.commit();
			session.close();
		}
	}


	@Override
	public List<EmployeeEn> fetchListOfEmps() {
		Session session  = null;
		//Transaction tr = null;
		try {
			session  = sessionFactory.openSession();
			//tr = session.beginTransaction();
			return session.createCriteria(EmployeeEn.class).list();
			//return "Employee Successfully Added";
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in fetchListOfEmps");
			//return "Problem in save";
		}finally {
			//session.flush();
			//tr.commit();
			session.close();
		}
		return null;
	}
	
}
