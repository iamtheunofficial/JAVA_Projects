package com.factory;

import com.dao.Employeedaoimpli;
import com.dao.IEmployeeDao;

public class Employeedaoactory {
	static IEmployeeDao emplyDao = null;

	private Employeedaoactory() {
		// TODO Auto-generated constructor stub
	}

	public static IEmployeeDao getDao() {
		if (emplyDao == null) {
			emplyDao = new Employeedaoimpli();
		}
		return emplyDao;
	}
}
