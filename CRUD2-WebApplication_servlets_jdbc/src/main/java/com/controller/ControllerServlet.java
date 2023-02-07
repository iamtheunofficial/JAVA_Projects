package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dto.Student;
import com.student.service.IStudentService;

import StudentFactorymethod.StudentServiceFactory;

@WebServlet("/test/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doget(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doget(request, response);

	}

	private void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println(path);
		RequestDispatcher dispath = null;

		IStudentService std;
		if (path.equalsIgnoreCase("/layout")) {
			dispath = request.getRequestDispatcher("../layout.html");
			dispath.forward(request, response);
		}
//		if(path.equalsIgnoreCase("/addform")) {
//			dispath=request.getRequestDispatcher("../addform.html");
//			dispath.forward(request, response);
//		}
//		if(path.equalsIgnoreCase("/select")) {
//			dispath=request.getRequestDispatcher("../select.html");
//			dispath.forward(request, response);
//		}if(path.equalsIgnoreCase("/delete")) {
//			dispath=request.getRequestDispatcher("../delete.html");
//			dispath.forward(request, response);
//		}if(path.equalsIgnoreCase("/update")) {
//			dispath=request.getRequestDispatcher("../update.html");
//			dispath.forward(request, response);
//		}
		if (path.equalsIgnoreCase("/a")) {
			std = StudentServiceFactory.getStudentService();
			Student s = new Student();
			s.setName(request.getParameter("uname"));
			s.setAge(request.getParameter("uage"));
			s.setAddress(request.getParameter("uaddress"));
			s.setGender(request.getParameter("ugender"));
			String status = std.save(s);
			if (status.equalsIgnoreCase("success")) {
				RequestDispatcher ds = request.getRequestDispatcher("../succes.html");
				ds.forward(request, response);
			} else {
				RequestDispatcher ds = request.getRequestDispatcher("../failure.html");
				ds.include(request, response);
			}
		}

		if (path.equalsIgnoreCase("/b")) {
			std = StudentServiceFactory.getStudentService();
			Student std1 = std.get(Integer.parseInt(request.getParameter("uid")));

			if (std1 != null) {
				new Student();
				request.setAttribute("std1", std1);
				RequestDispatcher ds = request.getRequestDispatcher("../display.jsp");
				ds.forward(request, response);
			}

			else {
				RequestDispatcher ds = request.getRequestDispatcher("../notfound.html");
				ds.forward(request, response);
			}
		}

		if (path.equalsIgnoreCase("/c")) {
			std = StudentServiceFactory.getStudentService();
			Student std1 = std.get(Integer.parseInt(request.getParameter("uid")));
			System.out.println();
			if (std1 != null) {
				String status = std.delete(std1.getId());
				if (status.equalsIgnoreCase("success")) {

					RequestDispatcher ds = request.getRequestDispatcher("../deletesuccess.html");
					ds.forward(request, response);
				} else {

					RequestDispatcher ds = request.getRequestDispatcher("../deletefail.html");
					ds.forward(request, response);
				}
			}

			else {
				RequestDispatcher ds = request.getRequestDispatcher("../notfound.html");
				ds.forward(request, response);
			}
		}

		if (path.equalsIgnoreCase("/d")) {
			std = StudentServiceFactory.getStudentService();
			Student std1 = std.get(Integer.parseInt(request.getParameter("uid")));
			System.out.println();
			if (std1 != null) {
				request.setAttribute("std1", std1);

				RequestDispatcher ds = request.getRequestDispatcher("../updateform.jsp");
				ds.include(request, response);

			} else {
				RequestDispatcher ds = request.getRequestDispatcher("../notfound.html");
				ds.forward(request, response);
			}
		}

		if (path.equalsIgnoreCase("/e")) {
			std = StudentServiceFactory.getStudentService();
			Student s = new Student();
			s.setId(Integer.parseInt(request.getParameter("uid")));
			s.setName(request.getParameter("uname"));
			s.setAge(request.getParameter("uage"));
			s.setAddress(request.getParameter("uaddress"));
			s.setGender(request.getParameter("ugender"));
			String status = std.update(s, s.getId());

			if (status.equalsIgnoreCase("success")) {

				RequestDispatcher ds = request.getRequestDispatcher("../updatesucces.html");
				ds.forward(request, response);
			} else {

				RequestDispatcher ds = request.getRequestDispatcher("../updatefailure.html");
				ds.include(request, response);
			}

		}

//			System.out.println(request.getParameter("uname"));
//			System.out.println(request.getParameter("uage"));
//			System.out.println(request.getParameter("uaddress"));
//			System.out.println(request.getParameter("ugender"));

	}

}
