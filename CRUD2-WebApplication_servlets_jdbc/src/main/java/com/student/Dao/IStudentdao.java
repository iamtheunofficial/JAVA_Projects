package com.student.Dao;

import com.student.Dto.Student;

public interface IStudentdao {
	String save(Student std);
	Student get(Integer id);
	String update(Student std,Integer id);
	String delete(Integer id);
	
}
