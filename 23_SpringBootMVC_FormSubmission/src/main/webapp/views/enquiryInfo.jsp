<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"/>

</head>
<body>
 
   <div class="text-danger text-center">
      ${pageTitle} <br/>
      ${enquiryStatus}
   </div>
   <div class="container">
	   <a href="${pageContext.request.contextPath}/enquiry/export-to-pdf" title="Export To Pdf"><i class='bi bi-file-pdf link-danger' style="font-size:2rem;color:red;float:right"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
	   <a href="#" title="Export To Excel"><i class='bi bi-file-excel link-danger' style="font-size:2rem;color:red;float:right"></i></a>
  </div>
   <table class="table table-striped table-responsive-md container mt-5" style="width:60%">   
      <thead>
         <tr>
            <th><a href="${pageContext.request.contextPath}/enquiry/page/${currentPage}?sortField=name&sortDir=${reverseSortDir}">Name</a></th>
            <th><a href="${pageContext.request.contextPath}/enquiry/page/${currentPage}?sortField=emailId&sortDir=${reverseSortDir}">EmailId</a></th>
            <th><a href="${pageContext.request.contextPath}/enquiry/page/${currentPage}?sortField=contactNo&sortDir=${reverseSortDir}">ContactNo</a></th>
            <th><a href="${pageContext.request.contextPath}/enquiry/page/${currentPage}?sortField=courseName&sortDir=${reverseSortDir}">Course</a></th>
            <th>Operations</th>
         </tr>
      </thead>
      
      <tbody>
         <c:forEach var="enquiry" items="${enquires}">
            <tr>
               <td>${enquiry.name}</td>
               <td>${enquiry.emailId}</td>
               <td>${enquiry.contactNo}</td>
               <td>${enquiry.courseName}</td>
               <td>
                  <a href="${pageContext.request.contextPath}/enquiry/editEnquiry/${enquiry.enquiryId}">|Edit|</a> 
                  <a href="${pageContext.request.contextPath}/enquiry/deleteEnquiry/${enquiry.enquiryId}" onclick="return confirm('Do you want To Delete Enquiry Information?')">|Delete|</a>
   			  </td>
            </tr>         
         </c:forEach>      
      </tbody>  
   </table>
   
   <!-- Adding the Pagination Bar -->
   <c:if test="${totalPages > 1}">		
		<div style="margin-left:235px;" class="container">	
			<nav aria-label="Page navigation example">
				<ul class="pagination">
				  <c:forEach var="pageNoCount" begin="1" end="${totalPages}" step="1">
			   		  <li class="page-item">
			   		      <a class="page-link text-danger fw-bolder"
			   		          href="${pageContext.request.contextPath}/enquiry/page/${pageNoCount}?sortField=${sortField}&sortDir=${sortDir}">${pageNoCount}</a>
			   		  </li>
				  </c:forEach>
				 </ul>
		    </nav>		   
		</div>
	</c:if>
	
</body>
</html>
