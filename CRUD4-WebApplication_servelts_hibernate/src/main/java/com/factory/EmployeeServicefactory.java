package com.factory;

import com.service.EmployeeServiceimpli;
import com.service.IEmplyeeservice;

public class EmployeeServicefactory {
	static IEmplyeeservice emplyeeservice = null;

	private EmployeeServicefactory() {
		// TODO Auto-generated constructor stub
	}

	public static IEmplyeeservice getService() {
		if (emplyeeservice == null) {
			emplyeeservice = new EmployeeServiceimpli();
		}
		return emplyeeservice;
	}
}
