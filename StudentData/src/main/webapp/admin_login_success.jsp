<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="login">
	<script src="js/JavaScript.js"></script>
    <header>
        <h1>Welcome to <%=session.getAttribute("uname")%></h1>
        <button class="login-button" id="student-add" onclick="location.href='add_admin.html'">Add admin</button>
    </header>
 
    <div class="login-container">
        <h2>Select Your Operation</h2>
        <div class="login-options">
            <button class="login-button" id="student-add" onclick="location.href='student_add.html'">Add Data</button>
            <button class="login-button" id="student-update" onclick="location.href='student_update.html'">Update Data</button>
            <button class="login-button" id="student-view" onclick="location.href='student_view.html'">View Data</button>
            <button class="login-button" id="student-remove" onclick="location.href='student_remove.html'">Delete Data</button>
        </div>
    </div>

    <footer>
        <p>&copy; 2023 Your Website Name</p>
    </footer>
</body>
</html>

