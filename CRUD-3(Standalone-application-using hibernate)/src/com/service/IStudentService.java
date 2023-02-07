package com.service;

import com.dto.Student;

public interface IStudentService {
	public String add(Student std);
	public Student select(Integer id);
	public String delete(Integer id);
	public String update(Student std);
}
