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
@WebServlet("/admin_login")
public class AdminLogin extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String adminName=req.getParameter("username");
		String passWord=req.getParameter("password");
		PrintWriter out=res.getWriter();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String qry="select * from admin where admin_name=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
			ps=con.prepareStatement(qry);
			ps.setString(1, adminName);
			ps.setString(2, passWord);
	        rs=ps.executeQuery();
	        while(rs.next()) {
	        	String name=rs.getString("admin_name");
	        	String password=rs.getString("password");
	        	if(adminName.equals(name) && password.equals(password)) {
	        		out.print("\r\n"
	    	        		+ "<!DOCTYPE html>\r\n"
	    	        		+ "<html>\r\n"
	    	        		+ "<head>\r\n"
	    	        		+ "    <title>Admin Page</title>\r\n"
	    	        		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n"
	    	        		+ "</head>\r\n"
	    	        		+ "<body class=\"login\">\r\n"
	    	        		+ "	<script src=\"js/JavaScript.js\"></script>\r\n"
	    	        		+ "    <header>\r\n"
	    	        		+ "        <h1>Welcome Admin</h1>\r\n"
	    	        		+ "    </header>\r\n"
	    	        		+ "\r\n"
	    	        		+ "    <div class=\"login-container\">\r\n"
	    	        		+ "        <h2>Select Your Operation</h2>\r\n"
	    	        		+ "        <div class=\"login-options\">\r\n"
	    	        		+ "            <button class=\"login-button\" id=\"student-login\" onclick=\"location.href='index.html'\">Add Student</button>\r\n"
	    	        		+ "            <button class=\"login-button\" id=\"admin-login\" onclick=\"location.href='student_login.html'\">View Student</button>\r\n"
	    	        		+ "            <button class=\"login-button\" id=\"update-student\" onclick=\"location.href='student_update.html'\">Update Student</button>\r\n"    	   		
	    	        		+ "        </div>\r\n"
	    	        		+ "    </div>\r\n"
	    	        		+ "\r\n"
	    	        		+ "    <footer>\r\n"
	    	        		+ "        <p>&copy; 2023 Your Website Name</p>\r\n"
	    	        		+ "    </footer>\r\n"
	    	        		+ "</body>\r\n"
	    	        		+ "</html>\r\n"
	    	        		);
	        	}
	        	else {
	        		out.println("<html>"
	        	+"<body>"+
	        	"<h4>User name or Password are invalid!!</h4>"
	        	+"</body>"
	        	+ "</html>");
	        	}
	        }
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
