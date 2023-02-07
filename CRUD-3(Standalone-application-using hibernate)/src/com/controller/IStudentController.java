package com.controller;

import com.dto.Student;

public interface IStudentController {
 
	public String add(Student std);
	public Student select(Integer id);
	public String delete(Integer id);
	public String update(Student std);
	
}
