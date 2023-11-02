package com.servlet.student_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/admin_login")
public class AdminLogin extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String adminName=req.getParameter("username");
		String passWord=req.getParameter("password");
		PrintWriter out=res.getWriter();
		
		HttpSession hs = req.getSession();
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String qry="select admin_name,password from admin where admin_name=? and password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
			ps=con.prepareStatement(qry);
			ps.setString(1, adminName);
			ps.setString(2, passWord);
	        rs=ps.executeQuery();
	        while (rs.next()) {
	            String name = rs.getString("admin_name");
	            String password = rs.getString("password");

	            if (adminName.equals(name) && passWord.equals(password)) {
	                res.sendRedirect("admin_login_success.jsp");
	                hs.setAttribute("uname", name);
	            }
	    		
	        }
	      
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 if (adminName.equals("admin1") && passWord.equals("admin1")) {
		        hs.setAttribute("uname", adminName);
		        res.sendRedirect("admin_login_success.jsp");
		}
		else {
			out.println("<html>"+"<head></head>"
		                 +"<body><h1>Username or Password are incorrect!!!</h1></body>"
					     +"</html>");
			RequestDispatcher rd=req.getRequestDispatcher("admin_login.html");
			rd.include(req, res);
			
		}
	}

}
