package com.student.service;

import com.student.Dto.Student;

public interface IStudentService {
	String save(Student std);
	Student get(Integer id);
	String update(Student std,Integer id);
	String delete(Integer id);
}
