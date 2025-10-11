<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registrationForm.jsp</title>
</head>
<body bgcolor="#3cb371">
   <h4 style="text-align:center;color:yellow;">Welcome To AshokIT Spring Boot MVC File Uploading & Downloading Application!!!!</h4>
   <c:if test="${uploadStatus ne '' || uploadStatus ne null}">
     <div>${uploadStatus}</div>
   </c:if>
   <spring:form action="saveProfile" method="post" enctype="multipart/form-data" modelAttribute="user">
   <table align="center">
       <tr>
          <td>FirstName</td>
          <td><spring:input id="firstName" path="firstName"/></td>
       </tr>
       <tr>
          <td>LastName</td>
           <td><spring:input id="lastName" path="lastName"/> </td>
       </tr>
       <tr>
          <td>Qualification</td>
          <td>
             <spring:select path="qualification">
                 <spring:option value="">Select</spring:option>
		             <c:forEach var="temp" items="${qualificationsList}">
		           		<spring:option value="${temp}">${temp}</spring:option>	            
		             </c:forEach>
	         </spring:select>
	      </td>
       </tr>
       <tr>
         <td>Profile Pic</td>
         <td>
            <input type="file" name="profilePic"/>
         </td>
       </tr>
       <tr>
         <td>&nbsp;</td>
         <td><spring:button>InsertRecord</spring:button></td>         
       </tr>       
   </table>
   </spring:form>
</body>
</html>