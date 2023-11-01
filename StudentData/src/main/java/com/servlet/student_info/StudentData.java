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
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
	String name=req.getParameter("name");
	String regNo=req.getParameter("regno");
	String dept=req.getParameter("dept");
	String phNo=req.getParameter("phno");
	String email=req.getParameter("email");
	String dob=req.getParameter("date");
    String datetime=formateDatetime;
	PrintWriter out=res.getWriter();

	
	out.println("<html>"+"<head></head>"
	        + "<style>"+
			"  body {\r\n"
			+ "            font-family: Arial, sans-serif;\r\n"
			+ "            background-color: #f4f4f4;\r\n"
			+ "            margin: 0;\r\n"
			+ "            padding: 0;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        .container {\r\n"
			+ "            max-width: 600px;\r\n"
			+ "            margin: 0 auto;\r\n"
			+ "            background: rgb(192, 192, 192);\r\n"
			+ "            padding: 20px;\r\n"
			+ "            border-radius: 5px;\r\n"
			+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        h1 {\r\n"
			+ "            text-align: center;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        label {\r\n"
			+ "            display: block;\r\n"
			+ "            margin-top: 10px;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        input[type=\"text\"] {\r\n"
			+ "            width: 550px;\r\n"
			+ "            padding: 10px;\r\n"
			+ "            margin: 5px 0;\r\n"
			+ "            border: 1px solid #ccc;\r\n"
			+ "            border-radius: 3px;\r\n"
			+ "        }\r\n"
			+ "         input[type=\"number\"] {\r\n"
			+ "            width: 550px;\r\n"
			+ "            padding: 10px;\r\n"
			+ "            margin: 5px 0;\r\n"
			+ "            border: 1px solid #ccc;\r\n"
			+ "            border-radius: 3px;\r\n"
			+ "        }\r\n"
			+ " input[type=\"date\"] {\r\n"
			+ "            width: 550px;\r\n"
			+ "            padding: 10px;\r\n"
			+ "            margin: 5px 0;\r\n"
			+ "            border: 1px solid #ccc;\r\n"
			+ "            border-radius: 3px;\r\n"
			+ "        }\r\n"
			+ "        input[type=\"submit\"] {\r\n"
			+ "            background: #333;\r\n"
			+ "            color: #fff;\r\n"
			+ "            border: 0;\r\n"
			+ "            border-radius: 5px;\r\n"
			+ "            padding: 10px;\r\n"
			+ "            cursor: pointer;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        input[type=\"submit\"]:hover {\r\n"
			+ "            background: #555;\r\n"
			+ "        }\r\n"
			+ "        \r\n"
			+ "  #card {\r\n"
			+ "  position: relative;\r\n"
			+ "  top: 20px;\r\n"
			+ "  width: 320px;\r\n"
			+ "  display: block;\r\n"
			+ "  margin: auto;\r\n"
			+ "  text-align: center;\r\n"
			+ "  font-family: 'Source Sans Pro', sans-serif;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#upper-side {\r\n"
			+ "  padding: 2em;\r\n"
			+ "  background-color: #8BC34A;\r\n"
			+ "  display: block;\r\n"
			+ "  color: #fff;\r\n"
			+ "  border-top-right-radius: 8px;\r\n"
			+ "  border-top-left-radius: 8px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#checkmark {\r\n"
			+ "  font-weight: lighter;\r\n"
			+ "  fill: #fff;\r\n"
			+ "  margin: -3.5em auto auto 20px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#status {\r\n"
			+ "  font-weight: lighter;\r\n"
			+ "  text-transform: uppercase;\r\n"
			+ "  letter-spacing: 2px;\r\n"
			+ "  font-size: 1em;\r\n"
			+ "  margin-top: -.2em;\r\n"
			+ "  margin-bottom: 0;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#lower-side {\r\n"
			+ "  padding: 2em 2em 5em 2em;\r\n"
			+ "  background: #fff;\r\n"
			+ "  display: block;\r\n"
			+ "  border-bottom-right-radius: 8px;\r\n"
			+ "  border-bottom-left-radius: 8px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#message {\r\n"
			+ "  margin-top: -.5em;\r\n"
			+ "  color: #757575;\r\n"
			+ "  letter-spacing: 1px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#contBtn {\r\n"
			+ "  position: relative;\r\n"
			+ "  top: 1.5em;\r\n"
			+ "  text-decoration: none;\r\n"
			+ "  background: #8bc34a;\r\n"
			+ "  color: #fff;\r\n"
			+ "  margin: auto;\r\n"
			+ "  padding: .8em 3em;\r\n"
			+ "  -webkit-box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.21);\r\n"
			+ "  -moz-box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.21);\r\n"
			+ "  box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.21);\r\n"
			+ "  border-radius: 25px;\r\n"
			+ "  -webkit-transition: all .4s ease;\r\n"
			+ "		-moz-transition: all .4s ease;\r\n"
			+ "		-o-transition: all .4s ease;\r\n"
			+ "		transition: all .4s ease;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "#contBtn:hover {\r\n"
			+ "  -webkit-box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.41);\r\n"
			+ "  -moz-box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.41);\r\n"
			+ "  box-shadow: 0px 15px 30px rgba(50, 50, 50, 0.41);\r\n"
			+ "  -webkit-transition: all .4s ease;\r\n"
			+ "		-moz-transition: all .4s ease;\r\n"
			+ "		-o-transition: all .4s ease;\r\n"
			+ "		transition: all .4s ease;\r\n"
			+ "}"
			+ "</style>"
	        + "<body>"
			+ "<div id='card' class=\"animated fadeIn\">\r\n"
			+ "  <div id='upper-side'>\r\n"
			+ "    <?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "      <!-- Generator: Adobe Illustrator 17.1.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->\r\n"
			+ "      <!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\r\n"
			+ "      <svg version=\"1.1\" id=\"checkmark\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" xml:space=\"preserve\">\r\n"
			+ "        <path d=\"M131.583,92.152l-0.026-0.041c-0.713-1.118-2.197-1.447-3.316-0.734l-31.782,20.257l-4.74-12.65\r\n"
			+ "	c-0.483-1.29-1.882-1.958-3.124-1.493l-0.045,0.017c-1.242,0.465-1.857,1.888-1.374,3.178l5.763,15.382\r\n"
			+ "	c0.131,0.351,0.334,0.65,0.579,0.898c0.028,0.029,0.06,0.052,0.089,0.08c0.08,0.073,0.159,0.147,0.246,0.209\r\n"
			+ "	c0.071,0.051,0.147,0.091,0.222,0.133c0.058,0.033,0.115,0.069,0.175,0.097c0.081,0.037,0.165,0.063,0.249,0.091\r\n"
			+ "	c0.065,0.022,0.128,0.047,0.195,0.063c0.079,0.019,0.159,0.026,0.239,0.037c0.074,0.01,0.147,0.024,0.221,0.027\r\n"
			+ "	c0.097,0.004,0.194-0.006,0.292-0.014c0.055-0.005,0.109-0.003,0.163-0.012c0.323-0.048,0.641-0.16,0.933-0.346l34.305-21.865\r\n"
			+ "	C131.967,94.755,132.296,93.271,131.583,92.152z\" />\r\n"
			+ "        <circle fill=\"none\" stroke=\"#ffffff\" stroke-width=\"5\" stroke-miterlimit=\"10\" cx=\"109.486\" cy=\"104.353\" r=\"32.53\" />\r\n"
			+ "      </svg>\r\n"
			+ "      <h3 id='status'>\r\n"
			+ "      Success\r\n"
			+ "    </h3>\r\n"
			+ "  </div>\r\n"
			+ "  <div id='lower-side'>\r\n"
			+ "    <p id='message'>\r\n"
			+ "      Congratulations, student data has been successfully added...\r\n"
			+ "    </p>\r\n"
			+ "    <a href=index.html id=contBtn>Continue</a>"
			+ "  </div>\r\n"
			+ "</div>"
			+ "</body>"
			+ "</html>");
	
	
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
