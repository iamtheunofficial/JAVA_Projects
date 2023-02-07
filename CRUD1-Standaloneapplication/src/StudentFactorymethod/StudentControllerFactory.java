package StudentFactorymethod;

import com.student.controller.StudentController;
import com.student.controller.StudentControllerimpl;

public class StudentControllerFactory {
private static StudentController std=null;

private StudentControllerFactory() {

}
public static StudentController getStudentController() {
	if(std==null) {
	std= new StudentControllerimpl();
	return std;
       }
	return std;
}
}
