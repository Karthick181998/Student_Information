package com.servlet.student_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class StudentUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String regNo=req.getParameter("regno");
		ServletContext context= getServletContext();
		context.setAttribute("data", regNo);
		PrintWriter out=res.getWriter();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String qry="select student_name, regno, dept, phno, email, dob from students_data where regno=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?"+"user=root&password=kutty");
			ps=con.prepareStatement(qry);
			ps.setString(1, regNo);
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
						+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "	<script src=\"js/JavaScript.js\"></script>\r\n"
						+ "    <div class=\"container\">\r\n"
						+ "        <h1>Student Data</h1>\r\n"
						+ "        <form method=\"post\" action=\"du\" onsubmit=\"return validatePhoneNumber()\">\r\n"
						+ "            <label for=\"name\">Name:</label>\r\n"
						+ "            <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Enter your name\" required value="+ name +">\r\n"
						+ "            \r\n"
						+ "             <label for=\"\">Register Number:</label>\r\n"
						+ "            <input type=\"text\" id=\"regno\" name=\"regno\" placeholder=\"Enter your register number\" required value="+ regno +">\r\n"
						+ "            \r\n"
						+ "             <label for=\"\">Department:</label>\r\n"
						+ "            <input type=\"text\" id=\"dept\" name=\"dept\" placeholder=\"Enter your department\" required value="+ dept +">\r\n"
						+ "            \r\n"
						+ "             <label for=\"\">Phone Number: <span id=\"message\" style=\"color: red\";></span></label>  \r\n"
						+ "            <input type=\"number\" id=\"phno\" name=\"phno\" placeholder=\"Enter your phone number\" required value="+ phno +">\r\n"
						+ "            \r\n"
						+ "            <label for=\"email\">Email:</label>\r\n"
						+ "            <input type=\"text\" id=\"email\" name=\"email\" placeholder=\"Enter your email\" required value="+ email +">\r\n"
						+ "            \r\n"
						+ "             <label for=\"date\">Date of Birth:</label>\r\n"
						+ "            <input type=\"date\" id=\"date\" name=\"date\" placeholder=\"Enter your date of birth\" required value="+date+">\r\n"
						+ "\r\n"
						+ "            <input type=\"submit\" value=\"Update\"> \r\n"
						+ "        </form>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
