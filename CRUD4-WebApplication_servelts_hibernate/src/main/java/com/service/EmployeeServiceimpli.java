package com.service;

import com.dao.IEmployeeDao;
import com.factory.Employeedaoactory;
import com.model.Employee;

public class EmployeeServiceimpli implements IEmplyeeservice {

	@Override
	public String insert(Employee e) {
		IEmployeeDao doa=Employeedaoactory.getDao();
		
		return doa.insert(e);

	
	}

	@Override
	public Employee select(Integer id) {
		IEmployeeDao doa=Employeedaoactory.getDao();
		return doa.select(id);
		 
	}

	@Override
	public String delete(Integer id) {
		IEmployeeDao doa=Employeedaoactory.getDao();
		return doa.delete(id);
	}

	@Override
	public String update(Employee e) {
		IEmployeeDao doa=Employeedaoactory.getDao();
		return doa.update(e);
	}

}
