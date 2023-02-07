package com.student.service;

import com.student.Dao.IStudentdao;
import com.student.Dto.Student;

import StudentFactorymethod.StudentdaoFactory;

public class Studentserviceimpli implements IStudentService {
	IStudentdao stddao;

	@Override
	public String save(Student std) {
		System.out.println("service called");
		stddao = StudentdaoFactory.getStudentDao();
		System.out.println("dao object created" + stddao.getClass().getName());
		String m = stddao.save(std);
		return m;
	}

	@Override
	public Student get(Integer id) {
		stddao = StudentdaoFactory.getStudentDao();
		return stddao.get(id);

	}

	@Override
	public String update(Student std, Integer id) {
		System.out.println("service called");
		stddao = StudentdaoFactory.getStudentDao();
		System.out.println("dao object created" + stddao.getClass().getName());
		String m = stddao.update(std, id);
		return m;
	}

	@Override
	public String delete(Integer id) {
		System.out.println("service called");
		stddao = StudentdaoFactory.getStudentDao();
		System.out.println("dao object created" + stddao.getClass().getName());
		String m = stddao.delete(id);
		return m;
	}

}
