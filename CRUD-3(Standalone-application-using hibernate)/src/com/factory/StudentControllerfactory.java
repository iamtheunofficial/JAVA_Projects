package com.factory;

import com.controller.IStudentController;
import com.controller.StudentControllerimpli;

public class StudentControllerfactory {
private  static IStudentController stdController=null;

private StudentControllerfactory() {
	
}

public static IStudentController getStudentController() {
	if(stdController==null) {
		stdController=new StudentControllerimpli();
	}return stdController;
}
	
}
