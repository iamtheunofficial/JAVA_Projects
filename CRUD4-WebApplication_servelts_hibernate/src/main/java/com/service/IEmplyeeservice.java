package com.service;

import com.model.Employee;

public interface IEmplyeeservice {

	public String insert(Employee e);
	
	public Employee select(Integer id);
	
	public String delete(Integer id);
	
	public String update(Employee e);
}
