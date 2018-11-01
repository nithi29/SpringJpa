<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add /Edit User</title>
<script>
function editRecord(userid){
   
  if(doIt){
	  alert("form edit");

   var f=document.getElementById("list");
    f.method="post";
    f.action="/SpringJpa/form"+userid;
    f.submit();
    }
  else{
alert("NOT edited");
    }
}
</script>
</head>

<body align="center" bgcolor="beige">
	<br>
	<br>
	<%-- <c:if test="${isEdit==true }"> </c:if>
	
    <c:out value="${param.enter}" /> --%>
	<c:choose>
		<c:when test="${isEdit==true}">
			<h2 style="color: blue">EDIT USER</h2>

		</c:when>
		<c:otherwise>
			<h2 style="color: blue">ADD NEW USER</h2>

		</c:otherwise>
	</c:choose>
	

	<br>
	<p style="color: red">${error}</p>
	
	<c:choose>
		<c:when test="${isEdit==true}">
			<form name="editform" action="/SpringJpa/update/" method="post">
		</c:when>
		<c:otherwise>
			<form name="addform" action="/SpringJpa/" method="post">
		</c:otherwise>
	</c:choose>
	
	
		<input type="hidden" value="insert" />
		<table align="center">
			<tr>
				<td><input type="hidden" name="userid" value="${user.userid }" /></td>
			</tr>
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstName" value="${user.firstName}" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><input type="text" name="lastName" value="${user.lastName}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>
			<br>
			<br>
			<tr>
				<td colspan="1"><br> <c:choose>
						<c:when test="${isEdit==true}">
							<td><input type="submit" value="Update"> </input>
						</c:when>
						<c:otherwise>
							<td><input type="submit" value="Add" onclick="/SpringJpa/" method="post">
								</input>
						</c:otherwise>
					</c:choose> <input type="reset" value="Cancel"> </input></td>
			</tr>
		</table>
	<a href="/SpringJpa">List all Users</a>
	<br />

</body>
</html>
