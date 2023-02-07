package com.controller;

import com.dto.Student;
import com.factory.StudentServiceFactory;
import com.service.IStudentService;

public class StudentControllerimpli implements IStudentController {
	IStudentService st=null;
	@Override
	public String add(Student std) {
		 st=StudentServiceFactory.getStudentService();
	return	st.add(std);
	}

	@Override
	public Student select(Integer id) {
		 st=StudentServiceFactory.getStudentService();
		return	st.select(id);	
	
	}

	@Override
	public String delete(Integer id) {
		 st=StudentServiceFactory.getStudentService();
			return	st.delete(id);
	}

	@Override
	public String update(Student std) {
		st=StudentServiceFactory.getStudentService();
		return	st.update(std);
	}

	
}
