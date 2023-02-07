package com.factory;

import com.service.IStudentService;
import com.service.StudentServiceimpli;

public class StudentServiceFactory {

	private  static IStudentService stdsService=null;

	private StudentServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static IStudentService getStudentService() {
		if(stdsService==null) {
			stdsService=new StudentServiceimpli();
		}return stdsService;
	}
}
