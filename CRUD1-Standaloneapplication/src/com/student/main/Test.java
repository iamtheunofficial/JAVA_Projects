package com.student.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.student.Dto.Student;
import com.student.controller.StudentController;

import StudentFactorymethod.StudentControllerFactory;

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
				System.out.println("Enter age");
				String age = read.readLine();
				System.out.println("Enter address");
				String address = read.readLine();
				System.out.println("Enter gender");
				String gender = read.readLine();
				Student s = new Student();
				s.setName(name);
				s.setAge(age);
				s.setAddress(address);
				s.setGender(gender);
				StudentController std = StudentControllerFactory.getStudentController();
				System.out.println(std.getClass().getName());
				String response = std.save(s);
				if (response.equalsIgnoreCase("success")) {
					System.out.println("inserted succesfully");
				} else if (response.equalsIgnoreCase("failure")) {
					System.out.println("insertion falied try again");
				} else {
					System.out.println("something went wrong ");
				}
				break;
			case "2":

				System.out.println("Enter id");

				int id = Integer.parseInt(read.readLine());

				StudentController std1 = StudentControllerFactory.getStudentController();

				Student response1 = std1.get(id);
				if (response1 != null) {
					System.out.println(response1);

				} else {
					System.out.println("Student id is not found");
				}
				break;
			case "3":
				System.out.println("Enter id");

				int id3 = Integer.parseInt(read.readLine());

				StudentController std3 = StudentControllerFactory.getStudentController();
				Student std4 = std3.get(id3);
				if (std4 != null) {
					Student updatedStudent = new Student();
					System.out.println("Enter name: [old-name]:" + std4.getName());
					String name1 = read.readLine();
					if (name1 == null || name1.equals("")) {
						updatedStudent.setName(std4.getName());
					} else {
						updatedStudent.setName(name1);
					}
					System.out.println("Enter Age: [old-age]:" + std4.getAge());
					String age1 = read.readLine();
					if (age1 == null || age1.equals("")) {
						updatedStudent.setAge(std4.getName());
					} else {
						updatedStudent.setAge(age1);
					}
					System.out.println("Enter address: [old-address]:" + std4.getAddress());
					String address1 = read.readLine();
					if (address1 == null || address1.equals("")) {
						updatedStudent.setAddress(std4.getAddress());
					} else {
						updatedStudent.setAddress(address1);
					}
					System.out.println("Enter gender: [old-gender]:" + std4.getGender());
					String gender1 = read.readLine();
					if (gender1 == null || gender1.equals("")) {
						updatedStudent.setGender(std4.getGender());
					} else {
						updatedStudent.setGender(gender1);
					}
					String status = std3.update(updatedStudent, std4.getId());
					if (status.equalsIgnoreCase("success")) {
						System.out.println("updated succesfully");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("updation failed try again");
					} else {
						System.out.println("something went wrong ");
					}
				} else {
					System.out.println("record not found");
				}

				break;
			case "4":
				System.out.println("Enter id");

				int id2 = Integer.parseInt(read.readLine());

				StudentController std2 = StudentControllerFactory.getStudentController();
				String status = std2.delete(id2);
				if (status.equalsIgnoreCase("success")) {
					System.out.println("deleted succesfully");
				} else if (status.equalsIgnoreCase("failure")) {
					System.out.println("Id not found");
				} else {
					System.out.println("something went wrong ");
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
