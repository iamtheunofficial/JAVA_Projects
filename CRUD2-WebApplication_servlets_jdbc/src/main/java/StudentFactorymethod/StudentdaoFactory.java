package StudentFactorymethod;

import com.student.Dao.IStudentdao;
import com.student.Dao.Studentdaoimpli;


public class StudentdaoFactory {
private static IStudentdao std=null;

private StudentdaoFactory() {

}
public static IStudentdao getStudentDao() {
	if(std==null) {
	std= new Studentdaoimpli();
	return std;
       }
	return std;
}
}
