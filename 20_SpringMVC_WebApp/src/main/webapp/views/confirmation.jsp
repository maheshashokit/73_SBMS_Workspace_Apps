<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>confirmation.jsp</title>
</head>
<body>
   <div style='text-align:center'>
   		<div>Student Name    : <span>${enquiryInfo.firstName}</span></div>
   		<div>Course Name     : <span>${enquiryInfo.courses}</span></div>
   		<div>Contact Number  : <span>${enquiryInfo.contactNo}</span></div>
   		<div>Your Enquiry is Received for above Details Admin Team will connect with you shortly.....</div>
   </div>
</body>
</html>