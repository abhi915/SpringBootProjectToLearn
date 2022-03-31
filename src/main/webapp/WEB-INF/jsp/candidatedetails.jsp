<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.main
{
width:700px;
margin-left :250px;
padding : 10px;
border:5px solid grey;
}

table
{

	font-family: arial,sans-serif;
	border-collapse: collapse;
	width:600px;
}

td
{
	border: 5px solid silver;
	text-align:left;
	padding:8px
}


</style>

</head>





<body>
 <% String path = request.getContextPath(); %>
  <div class = "main">
<center>
  <h1><a href = "<%=request.getContextPath()%>/addPage"> Add condidate record</a> </h1>
</center>
  
  
  <table>
  <tr>
  <th> ID</th>
  <th>Name </th>
  <th>Skills</th>
  <th>Update</th>
  <th>Delete</th>
  </tr>
  
  <c:forEach var="candidate" items="${candidatelist}">
                  <tr>
                      <td><c:out value="${candidate.id}" /></td>
                      <td><c:out value="${candidate.name}" /></td>
                      <td><c:out value="${candidate.skills}" /></td>
                      <td><a href="<%=request.getContextPath()%>/updatePage?id=${candidate.id}&name=${candidate.name}&skills=${candidate.skills}">Update</a></td>
                       <td><a href="<%=request.getContextPath()%>/delete?id=${candidate.id}">Delete</a></td>
                  </tr>
  </c:forEach>
  
  </table>
  </div>
  </body>
  </html>