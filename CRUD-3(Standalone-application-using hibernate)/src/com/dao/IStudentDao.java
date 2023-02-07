package com.dao;

import com.dto.Student;

public interface IStudentDao {
	public String add(Student std);
	public Student select(Integer id);
	public String delete(Integer id);
	public String update(Student std);
}
