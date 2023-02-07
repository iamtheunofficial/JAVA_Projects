package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.controller.IStudentController;
import com.dto.Student;
import com.factory.StudentControllerfactory;



public class Test {

	public static void main(String[] args) throws IOException {
		
		while (true) {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome to Student dashboard");
			System.out.println("please chosse the below options");
			System.out.println("1-INSERT 2-Selection 3-Updation 4-Deletion 5-exit");
			String option = read.readLine();
			switch (option) {
			case "1":
				System.out.println("please fill the below details");
				System.out.println("Enter name");
				String name = read.readLine();
				
				System.out.println("Enter address");
				String address = read.readLine();
				Student s1=new Student();
				s1.setStd_Name(name);
				s1.setStd_Address(address);
				IStudentController std=StudentControllerfactory.getStudentController();
				String status=std.add(s1);
				if(status.equalsIgnoreCase("success")) {
					System.out.println("Added Succesfully");
				}
				else if(status.equalsIgnoreCase("failure")) {
					System.out.println("insertion fails");
				}else {
					System.out.println("something went wrong please try again ");
				}
				break;
			case "2":
				
				System.out.println("Enter name");
				Integer idno = Integer.valueOf(read.readLine());
				IStudentController std1=StudentControllerfactory.getStudentController();
				Student s=std1.select(idno);
				if(s!=null) {
					System.out.println(s);
				}else {
					System.out.println("user not found");
				}
				
				break;
			case "3":
				System.out.println("Enter id");
				Integer iddel= Integer.valueOf(read.readLine());
				IStudentController c1=StudentControllerfactory.getStudentController();
				Student s2=c1.select(iddel);
				if(s2!=null) {
				String status1=c1.delete(s2.getStd_Id());
				if(status1.equalsIgnoreCase("sucess")) {
					System.out.println("deleted succesfully");
				}else if(status1.equalsIgnoreCase("failure")) {
					System.out.println(" deletion fails ,user not found");
				}
				else {
					System.out.println("something went wrong please try again");}
				}else {
					System.out.println("user not found");
				}
				
				

				break;
			case "4":
				System.out.println("Enter id");

				int id3 = Integer.parseInt(read.readLine());

				IStudentController std3 = StudentControllerfactory.getStudentController();
				Student std4 = std3.select(id3);
				if (std4 != null) {
					Student updatedStudent = new Student();
					System.out.println("Enter name: [old-name]:" + std4.getStd_Name());
					String name1 = read.readLine();
					if (name1 == null || name1.equals("")) {
						updatedStudent.setStd_Name(std4.getStd_Name());
					} else {
						updatedStudent.setStd_Name(name1);
					}
				
					System.out.println("Enter address: [old-address]:" + std4.getStd_Address());
					String address1 = read.readLine();
					if (address1 == null || address1.equals("")) {
						updatedStudent.setStd_Address(std4.getStd_Address());
					} else {
						updatedStudent.setStd_Address(address1);
					}
					updatedStudent.setStd_Id(id3);
					String status3 = std3.update(updatedStudent);
					if (status3.equalsIgnoreCase("success")) {
						System.out.println("updated succesfully");
					} else if (status3.equalsIgnoreCase("failure")) {
						System.out.println("updation failed try again");
					} else {
						System.out.println("something went wrong ");
					}
				} else {
					System.out.println("usernot not found");
				}



				break;
			case "5":
				System.out.println("Thank you for using the application");
				System.exit(0);
				break;

			default:
				System.out.println("please enter the correct value");
				break;
			}
		}

		
		
		
		
		

	}

}
