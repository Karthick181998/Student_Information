package com.servlet.student_info;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/sd")
public class StudentData extends HttpServlet {
	
	LocalDateTime dateTime=LocalDateTime.now();
	DateTimeFormatter formate=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formateDatetime=dateTime.format(formate);
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
	String name=req.getParameter("name");
	String regNo=req.getParameter("regno");
	String dept=req.getParameter("dept");
	String phNo=req.getParameter("phno");
	String email=req.getParameter("email");
	String dob=req.getParameter("date");
    String datetime=formateDatetime;
	PrintWriter out=res.getWriter();

	
	out.println("Data added has been successfully");
	System.out.println(name + regNo + dept + phNo + email + dob);
	out.flush();
	out.close();
	Connection con=null;
	PreparedStatement ps=null;
	 String sql = "INSERT INTO students_data (student_name, regno, dept, phno, email, dob, date_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
		ps=con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, regNo);
        ps.setString(3, dept);
        ps.setString(4, phNo);
        ps.setString(5, email);
        ps.setString(6, dob);
        ps.setString(7, datetime);
       
        ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}	
}
