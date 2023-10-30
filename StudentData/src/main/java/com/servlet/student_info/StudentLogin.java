package com.servlet.student_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class StudentLogin extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	String regNo=req.getParameter("regno");
	String dateOfbirth=req.getParameter("date");
	PrintWriter out=res.getWriter();
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String qry="select student_name, regno, dept, phno, email, dob from students_data where regno=? and dob=?";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
		ps=con.prepareStatement(qry);
		ps.setString(1, regNo);
		ps.setString(2, dateOfbirth);
		rs=ps.executeQuery();
		while(rs.next()) {
			String name=rs.getString("student_name");
			String regno=rs.getString("regno");
			String dept=rs.getString("dept");
			String phno=rs.getString("phno");
			String email=rs.getString("email");
			String date=rs.getString("dob");
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "    <title>Student Information</title>\r\n"
					+ "    <style>\r\n"
					+ "        body {\r\n"
					+ "            font-family: Arial, sans-serif;\r\n"
					+ "            background-color: #f5f5f5;\r\n"
					+ "            text-align: center;\r\n"
					+ "            display: flex;\r\n"
					+ "            align-items: center;\r\n"
					+ "            justify-content: center;\r\n"
					+ "            height: 100vh;\r\n"
					+ "            margin: 0;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .student-card {\r\n"
					+ "            background-color: #ffffff;\r\n"
					+ "            border: 1px solid #d1d1d1;\r\n"
					+ "            border-radius: 10px;\r\n"
					+ "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\r\n"
					+ "            width: 300px;\r\n"
					+ "            padding: 20px;\r\n"
					+ "            text-align: left;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .student-card h2 {\r\n"
					+ "            color: #333;\r\n"
					+ "            font-size: 1.5em;\r\n"
					+ "            margin: 0;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .student-card p {\r\n"
					+ "            margin: 10px 0;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <div class=\"student-card\">\r\n"
					+ "        <h2>Name:" + name +"</h2>\r\n"
					+ "        <p>Registration Number:" +regno+"</p>\r\n"
					+ "        <p>Department:"+dept+"</p>\r\n"
					+ "        <p>Phone Number: "+phno+"</p>\r\n"
					+ "        <p>Email: "+email+"</p>\r\n"
					+ "        <p>Date of Birth:"+date+"</p>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
		}
		out.flush();
		out.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
