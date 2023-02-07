package com.factory;

import com.dao.IStudentDao;
import com.dao.Studentdaoimpli;

public class StudentdaoFactory {

	private  static IStudentDao stdDao=null;

	private StudentdaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static IStudentDao getStudentdao() {
		if(stdDao==null) {
			stdDao=new Studentdaoimpli();
		}return stdDao;
	}
}
