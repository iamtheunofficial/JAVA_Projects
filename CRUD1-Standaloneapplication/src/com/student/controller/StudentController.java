package com.student.controller;

import com.student.Dto.Student;

public interface StudentController {
 
	String save(Student std);
	Student get(Integer id);
	String update(Student std,Integer id);
	String delete(Integer id);
	
}
