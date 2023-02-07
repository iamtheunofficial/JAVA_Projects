package com.student.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.JdbcConnection;
import com.student.Dto.Student;

public class Studentdaoimpli implements IStudentdao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet r = null;
	String inserquesry = "insert into Student(name,age,address,gender) values(?,?,?,?)";
	String selectquesry = "select * from student where id=?";
	String deletequery = "delete from student where id=?";
	String updateQuery = "update student set name=?,age=?,address=?,gender=? where id=?";

	@Override
	public String save(Student std) {
		System.out.println("save called");
		String status = null;
		try {
//			conn = JdbcConnection.getConnection();
			conn = JdbcConnection.getconnectionpool();
			if (conn != null) {
				p = conn.prepareStatement(inserquesry);
				if (p != null) {
					p.setString(1, std.getName());
					p.setString(2, std.getAge());
					p.setString(3, std.getAddress());
					p.setString(4, std.getGender());
					int rows = p.executeUpdate();
					if (rows == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
			status = "failure";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;

	}

	@Override
	public Student get(Integer id) {
		System.out.println("get called");
		Student std = null;
		try {
			System.out.println("k");
//			conn = JdbcConnection.getConnection();
			conn = JdbcConnection.getconnectionpool();
			
			if (conn != null) {
				
				p = conn.prepareStatement(selectquesry);
				if (p != null) {
					p.setInt(1, id);

					r = p.executeQuery();
					if (r.next()) {
						int ids = r.getInt(1);
						String name = r.getString(2);
						String age = r.getString(3);
						String address = r.getString(4);
						String gender = r.getString(5);
						std = new Student();
						std.setId(id);
						std.setName(name);
						std.setAge(age);
						std.setAddress(address);
						std.setGender(gender);

					}
				}
			}
		} catch (Exception e) {
			e.getMessage();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return std;

	}

	@Override
	public String update(Student std, Integer id) {

		System.out.println("update called");
		String status = null;
		try {
//			conn = JdbcConnection.getConnection();
			conn = JdbcConnection.getconnectionpool();
			if (conn != null) {
				p = conn.prepareStatement(updateQuery);
				if (p != null) {
					p.setString(1, std.getName());
					p.setString(2, std.getAge());
					p.setString(3, std.getAddress());
					p.setString(4, std.getGender());
					p.setInt(5, id);
					int rows = p.executeUpdate();

					if (rows == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
			status = "failure";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return status;

	}

	@Override
	public String delete(Integer id) {
		System.out.println("delete called");
		String status = null;
		Student s = get(id);
		if (s != null) {
			try {
//				conn = JdbcConnection.getConnection();
				conn = JdbcConnection.getconnectionpool();
				if (conn != null) {
					p = conn.prepareStatement(deletequery);
					if (p != null) {
						p.setInt(1, id);

						int rows = p.executeUpdate();
						if (rows == 1) {
							status = "success";
						} else {
							status = "failure";
						}
					}
				}
			} catch (Exception e) {
				e.getMessage();
				status = "failure";
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			status = "FAILURE";
		}
		return status;

	}

}
