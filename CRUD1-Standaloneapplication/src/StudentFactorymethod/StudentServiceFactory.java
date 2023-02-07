package StudentFactorymethod;


import com.student.service.IStudentService;
import com.student.service.Studentserviceimpli;

public class StudentServiceFactory {
private static IStudentService std=null;

private StudentServiceFactory() {

}
public static IStudentService getStudentService() {
	if(std==null) {
	std= new Studentserviceimpli();
	return std;
       }
	return std;
}
}
