<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<body bgcolor="cyan">

	<div style='text-align: center; color: red;'>Welcome To AshokIT For Course Enquiry.......</div>
	<br />
	<div>
		<spring:form action="processEnquiry" method="post" modelAttribute="enquiryForm">
			<table align="center">
				<tr>
					<td>Name</td>
					<td><spring:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><spring:input path="emailId" /></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><spring:input path="contactNo" /></td>
				</tr>
				<tr>
					<td>Course</td>
					<td>
					   <spring:select path="courses" cssStyle="width:80%">
				           <spring:option value="">Select</spring:option>
					       <spring:option value="JavaFullStack">Java Full Stack</spring:option>
					       <spring:option value="PythonFullStack">Python Full Stack</spring:option>
					       <spring:option value="SpringBootWithMS">Spring Boot And Microservices</spring:option>
					       <spring:option value="Devops">Devops</spring:option>
					       <spring:option value="AWS">AWS</spring:option>
					    </spring:select>
                   </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><spring:button>Submit</spring:button></td>
					<td><spring:button>Cancel</spring:button></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>