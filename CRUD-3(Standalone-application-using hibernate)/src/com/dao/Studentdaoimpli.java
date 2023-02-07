package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dto.Student;

import com.hibernateutils.HibernateUtils;

public class Studentdaoimpli  implements IStudentDao{


	@Override
	public String add(Student std) {
		Session s=null;
		Transaction t=null;
		String status=null;
		try {
			s=HibernateUtils.getSession();
			if(s!=null) {
				t=s.beginTransaction();
				if(t!=null) {
					s.save(std);
					t.commit();
					status="success";
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			status="failure";
		}catch (Exception e) {
			status="failure";
			e.printStackTrace();
			
		}finally {
			HibernateUtils.closeSession(s);
		}
		return status;
		
	}

	@Override
	public Student select(Integer id) {
		Session s=null;
		
		Student stds=null;
		try {
			s=HibernateUtils.getSession();
			System.out.println(s);
			if(s!=null) {
			stds=s.get(Student.class, id);
			if(stds!=null) {
			return stds;	
			}
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			HibernateUtils.closeSession(s);
			System.out.println(s);
		}
		return stds;
		
	}

	@Override
	public String delete(Integer id) {
Session s=null;
		Transaction t=null;
		String status =null;
		try {
			s=HibernateUtils.getSession();
			
			if(s!=null) {
			t=s.beginTransaction();
			if(t!=null) {
				Student s3=new Student();
				s3.setStd_Id(id);
			s.delete(s3);	
			t.commit();
			status="sucess";
			}
			}
			
			
		} catch (HibernateException e) {
			status="failure";
			e.printStackTrace();
			
		}catch (Exception e) {
			status="failure";
			e.printStackTrace();
			
		}finally {
			HibernateUtils.closeSession(s);
		
		}
		return status;
		
	}

	@Override
	public String update(Student std) {
		Session s=null;
		Transaction t=null;
		String status=null;
		try {
			s=HibernateUtils.getSession();
			if(s!=null) {
				t=s.beginTransaction();
				if(t!=null) {
					s.update(std);
					t.commit();
					status="success";
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			status="failure";
		}catch (Exception e) {
			status="failure";
			e.printStackTrace();
			
		}finally {
			HibernateUtils.closeSession(s);
		}
		return status;
		
	}

	
}
