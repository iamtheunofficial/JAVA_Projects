package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtils;
import com.model.Employee;

public class Employeedaoimpli implements IEmployeeDao {

	@Override
	public String insert(Employee e) {
		String status = "failure";
		Session s = HibernateUtils.getSession();
		try {
			if (s != null) {
				Transaction t = s.beginTransaction();
				if (t != null) {
					s.save(e);
					t.commit();
					status = "success";
				}
			}
		} catch (HibernateException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			HibernateUtils.closeSession(s);
		}
		return status;
	}

	@Override
	public Employee select(Integer id) {
		Session s = null;
		Employee e = null;
		try {
			s = HibernateUtils.getSession();
			if (s != null) {
				e = s.get(Employee.class, id);
			}
		} catch (HibernateException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			HibernateUtils.closeSession(s);
		}
		return e;
	}

	@Override
	public String delete(Integer id) {

		String status = "failure";
		Transaction t = null;
		Session s = HibernateUtils.getSession();
		try {
			if (s != null) {
				t = s.beginTransaction();
				if (t != null) {
					Employee emp = s.get(Employee.class, id);
					if (emp != null) {

						s.delete(emp);
						t.commit();
						status = "success";
					}
				}
			}
		} catch (HibernateException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			HibernateUtils.closeSession(s);
		}
		return status;

	}

	@Override
	public String update(Employee e) {
		String status = "failure";
		Session s = HibernateUtils.getSession();

		try {
			if (s != null) {
				Transaction t = s.beginTransaction();
				if (t != null) {
					s.update(e);
					t.commit();
					status = "success";
				}
			}
		} catch (HibernateException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			HibernateUtils.closeSession(s);
		}
		return status;

	}

}
