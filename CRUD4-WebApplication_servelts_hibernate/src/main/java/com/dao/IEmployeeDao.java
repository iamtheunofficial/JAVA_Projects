package com.dao;

import com.model.Employee;

public interface IEmployeeDao {
	public String insert(Employee e);

	public Employee select(Integer id);

	public String delete(Integer id);

	public String update(Employee e);
}
