package com.controller.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.EmployeeServicefactory;
import com.model.Employee;
import com.service.IEmplyeeservice;

@WebServlet("/Test/*")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doo(request, response);
	}

	public void doo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println(request.getPathInfo());

		if (path.equalsIgnoreCase("/start")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../One.jsp");
			dispatcher.forward(request, response);
		}

		if (path.equalsIgnoreCase("/insert")) {
			Employee e = new Employee();
			e.setName(request.getParameter("uname"));
			e.setAge(Integer.valueOf(request.getParameter("uage")));
			e.setAddress(request.getParameter("uaddress"));
			String dob = request.getParameter("dob");
			LocalDate date = LocalDate.parse(dob);
			e.setDob(date);

			IEmplyeeservice service = EmployeeServicefactory.getService();
			String status = service.insert(e);
			if (status.equalsIgnoreCase("success")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../insertsuccess.html");
				dispatcher.forward(request, response);
			} else if (status.equalsIgnoreCase("failure")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../insertfailure.html");
				dispatcher.forward(request, response);
			} else {
				response.sendError(505, "something went wrong please try again later");
			}
		}

		if (path.equalsIgnoreCase("/select")) {

			IEmplyeeservice service = EmployeeServicefactory.getService();
			Employee emp = service.select(Integer.valueOf(request.getParameter("uid")));
			if (emp != null) {
				request.setAttribute("emp", emp);
				RequestDispatcher dispatcher = request.getRequestDispatcher("../display.jsp");
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../notfound.html");
				dispatcher.forward(request, response);
			}
		}

		if (path.equalsIgnoreCase("/delete")) {

			IEmplyeeservice service = EmployeeServicefactory.getService();

			String status = service.delete(Integer.valueOf(request.getParameter("uid")));

			if (status.equalsIgnoreCase("success")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../deletetsuccess.html");
				dispatcher.forward(request, response);
			} else if (status.equalsIgnoreCase("failure")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../deletetfailure.html");
				dispatcher.forward(request, response);
			} else {
				response.sendError(505, "something went wrong please try again later");
			}

		}

		if (path.equalsIgnoreCase("/update")) {
			IEmplyeeservice service = EmployeeServicefactory.getService();
			Employee e = service.select(Integer.valueOf(request.getParameter("uid")));
			if (e != null) {
				request.setAttribute("emp", e);
				RequestDispatcher dispatcher = request.getRequestDispatcher("../updateform.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../notfound.html");
				dispatcher.forward(request, response);
			}
		}
		if (path.equalsIgnoreCase("/updateform")) {
			IEmplyeeservice service = EmployeeServicefactory.getService();
			Employee e = new Employee();
			e.setId(Integer.valueOf(request.getParameter("uid")));
			e.setName(request.getParameter("uname"));
			e.setAge(Integer.valueOf(request.getParameter("uage")));
			e.setAddress(request.getParameter("uaddress"));
			String dob = request.getParameter("dob");
			LocalDate date = LocalDate.parse(dob);
			e.setDob(date);
			String status = service.update(e);
			if (status.equalsIgnoreCase("success")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../updatesuccess.html");
				dispatcher.forward(request, response);
			} else if (status.equalsIgnoreCase("failure")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../updatefailure.html");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../notfound.html");
				dispatcher.forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doo(request, response);
	}

}
