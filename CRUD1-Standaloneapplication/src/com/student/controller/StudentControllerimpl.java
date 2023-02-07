package com.student.controller;

import com.student.Dto.Student;
import com.student.service.IStudentService;

import StudentFactorymethod.StudentServiceFactory;

public class StudentControllerimpl implements StudentController {
	IStudentService stdservice;

	@Override
	public String save(Student std) {
		System.out.println("controller called");
		stdservice = StudentServiceFactory.getStudentService();
		System.out.println("service object created" + stdservice.getClass().getName());
		String r = stdservice.save(std);

		return r;
	}

	@Override
	public Student get(Integer id) {
		stdservice = StudentServiceFactory.getStudentService();
		return stdservice.get(id);

	}

	@Override
	public String update(Student std, Integer id) {
		stdservice = StudentServiceFactory.getStudentService();
		return stdservice.update(std, id);
	}

	@Override
	public String delete(Integer id) {
		stdservice = StudentServiceFactory.getStudentService();
		return stdservice.delete(id);
	}

}
