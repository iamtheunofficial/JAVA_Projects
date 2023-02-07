package com.service;

import com.dao.IStudentDao;
import com.dto.Student;
import com.factory.StudentdaoFactory;

public class StudentServiceimpli implements IStudentService {
	IStudentDao  d=null;
	@Override
	public String add(Student std) {
		// TODO Auto-generated method stub
		d=StudentdaoFactory.getStudentdao();
		
		return d.add(std);
		
	}

	@Override
	public Student select(Integer id) {
IStudentDao d=StudentdaoFactory.getStudentdao();
		
		return d.select(id);
	}

	@Override
	public String delete(Integer id) {
		d=StudentdaoFactory.getStudentdao();
		return 	d.delete(id);
		
	}

	@Override
	public String update(Student std) {
		
		d=StudentdaoFactory.getStudentdao();
		return 	d.update(std);
		
	}

	

}
