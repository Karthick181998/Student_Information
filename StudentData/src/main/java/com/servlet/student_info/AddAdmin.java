package com.servlet.student_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/adminLogin")
public class AddAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	String adminName=req.getParameter("aname");
	String adminDept=req.getParameter("adept");
	String adminId=req.getParameter("aid");
	String userName=req.getParameter("uname");
	String passWord=req.getParameter("pass");
	String msg="added";
	String backHtml="add_admin.html";
	PrintWriter out=res.getWriter();
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String qry="insert into admin (faculty_name,dept,identy_no,admin_name,password) values (?,?,?,?,?)";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
		ps=con.prepareStatement(qry);
		ps.setString(1,adminName);
		ps.setString(2,adminDept);
		ps.setString(3,adminId);
		ps.setString(4,userName);
		ps.setString(5,passWord);
		ps.executeUpdate();
		res.sendRedirect("success_msg.jsp");
		HttpSession hs=req.getSession();
		hs.setAttribute("uname", adminName);
		hs.setAttribute("msg", msg);
		hs.setAttribute("backHtml", backHtml);
	}
	catch(ClassNotFoundException | SQLException e) {
		
	}
	
	}
}
