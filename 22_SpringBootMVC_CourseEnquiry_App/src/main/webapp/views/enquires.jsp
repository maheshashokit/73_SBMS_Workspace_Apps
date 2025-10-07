<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>enquires.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" 
    href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"/>
</head>
<body>
	<h4 class="text-center bold bg-danger text-white p-3">${title}</h4>
	<br />
	<div class="container">
		<div>
		   <a href="${pageContext.request.contextPath}/export-to-pdf" title="Export To Pdf"><i class='bi bi-file-pdf link-danger' style="font-size:2rem;color:red;float:right"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
		   <a href="#" title="Export To Excel"><i class='bi bi-file-excel link-danger' style="font-size:2rem;color:red;float:right"></i></a>
		</div>
		<table class="table table-striped table-responsive-md">
			<thead class="table-danger">
				<tr>
					<th>S.No</th>
					<th><a href="${pageContext.request.contextPath}/page/${currentPage}?sortField=enquiryName&sortDir=${reverseSortDir}">Enquiry Name</a></th>
					<th><a href="${pageContext.request.contextPath}/page/${currentPage}?sortField=emailId&sortDir=${reverseSortDir}">EmailId</a></th>
					<th><a href="${pageContext.request.contextPath}/page/${currentPage}?sortField=contactNo&sortDir=${reverseSortDir}">ContactNo</a></th>
					<th><a href="${pageContext.request.contextPath}/page/${currentPage}?sortField=course&sortDir=${reverseSortDir}">Course</a></th>
					<th>Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="enquiry" items="${enquires}" varStatus="count">
					<tr>
						<td>${count.index + 1}</td>
						<td>${enquiry.enquiryName}</td>
						<td>${enquiry.emailId}</td>
						<td>${enquiry.contactNo}</td>
						<td>${enquiry.course}</td>
						<td><a href="editEnquiry/${enquiry.enquiryId}">|Edit|</a> <a
							  href="deleteEnquiry/${enquiry.enquiryId}"
							onclick="return confirm('Do you want To Delete Enquiry Information?')">|Delete|</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- Adding the Pagination Bar -->
	<c:set var="activeFlag" value= ""/>
	<c:if test="${totalPages > 1}">		
		<div style="margin-left:211px;">	
			<nav aria-label="Page navigation example">
				<ul class="pagination">
				  <li class="page-item"><a class="page-link text-danger fw-bolder" href="${pageContext.request.contextPath}/page/${currentPage - 1}?sortField=${sortField}&sortDir=${sortDir}">Previous</a></li>
				  <c:forEach var="pageNoCount" begin="1" end="${totalPages}" step="1">
			   		  <li class="page-item">
			   		      <a class="page-link text-danger fw-bolder"
			   		          href="${pageContext.request.contextPath}/page/${pageNoCount}?sortField=${sortField}&sortDir=${sortDir}">${pageNoCount}</a>
			   		  </li>
				  </c:forEach>
				  <li class="page-item"><a class="page-link text-danger fw-bolder" href="${pageContext.request.contextPath}/page/${currentPage + 1}?sortField=${sortField}&sortDir=${sortDir}">Next</a></li>
				</ul>
		    </nav>		   
		</div>
	</c:if>
	
	<div style='text-align: center;'>
		<a href="${pageContext.request.contextPath}/"> |Home Page|</a>
	</div>
</body>
</html>