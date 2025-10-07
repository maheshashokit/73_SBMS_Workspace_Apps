<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration.jsp</title>
</head>
<body>
	<div style='text-align: center; color: red;margin-bottom:8px;'>Welcome To AshokIT
		For Spring MVC Application Development...</div>
	<form action="processEnquiry" method="post">
		<table align="center">
			<tr>
				<td>Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>EmailID</td>
				<td><input type="text" name="emailId" /></td>
			</tr>
			<tr>
				<td>ContactNo</td>
				<td><input type="text" name="contactNo" /></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><select name="courses">
						<option value=""></option>
						<option value="Angular">AngularJS</option>
						<option value="React">ReactJS</option>
						<option value="SpringBoot">Spring Boot Framework</option>
						<option value="Microservices">Microservices</option>
						<option value="Aws">AWS</option>
						<option value="Devops">Devops</option>
				</select></td>
			</tr>
		</table>
		<div style="text-align: center;margin-top:8px;">
			<input type="submit" value="Send Enquiry" />
		</div>
	</form>
</body>
</html>