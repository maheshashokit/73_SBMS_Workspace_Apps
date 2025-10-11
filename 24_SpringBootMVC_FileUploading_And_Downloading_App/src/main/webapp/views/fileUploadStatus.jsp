<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fileUploadStatus.jsp</title>
</head>
<style type="text/css">
  table tr:first-child {
	 font-weight:bold;
	 text-align:center;
	 color:red;
  }
</style>
<body bgcolor="#3cb371">  
   <h4 style="text-align:center;color:Yellow;">Welcome To Ashok IT For Spring Boot MVC File Downloading Application!!!!!</h4>
   <div style='text-align:center;color:white;'>${uploadStatus}</div>
   <table align="center" border="2" cellpadding="4">
      <tr style="color:white">
          <td>S.No</td>
          <td>File Name</td>
          <td>File Location</td>
          <td>Download</td>
      </tr>
       <c:forEach var="file" items="${totalFilesList}" varStatus="loopCounter">
            <tr>
	             <td>${loopCounter.count}</td>
	          	 <td>${file.getName()}</td>
	          	 <td>${file.getAbsolutePath()}</td>
	          	 <td><a href="downloadFile?filename=${file.getName()}" style="color:yellow">Download File</a></td>
          	</tr>
       </c:forEach>   
    </table>
    <div style="text-align:center;">
        <a href="/">|Home Page|</a>
    </div>
</body>
</html>