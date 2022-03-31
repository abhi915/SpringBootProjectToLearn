<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<! -- javascript coded for form validation-->

<script>




function validate()
{
	
	var name = document.myform.txt_name;
	var skills = document.myform.txt_skills;
	
	if (name.value == "") {
		window.alert("please enter name ?");
		name.focus();
		return false;
	}
	
	if (skills.value == "") {
		window.alert("Please enter skils ?");
		skills.focus();
		return false;
	}
	
	}


</script>







</head>
<body>
 <div class="main">
 <form method = "post" action="<%=request.getContextPath()%>/addCandidateDetails" name = "myform" onsubmit="return validate();">
 
 <center>
 	<h1> Insert Record</h1>	 
 </center>
 
 <table>
   <tr>
   <td> Name </td>
   <td> <input type = "text" name="txt_name"></td>
   </tr>
   
   <tr>
   <td> Skills </td>
   <td> <input type = "text" name="txt_skills"></td>
   </tr>
   
    <tr>
   <td> <input type="submit" name="btn_add" Value="Insert">${message}</td>
   </tr>
   
   <center>
   	<h1> <a href = "<%=request.getContextPath()%>/home"> Back </a></h1>
   </center>
 
 
 
 </table>
 
 
 </div>

</body>
</html>