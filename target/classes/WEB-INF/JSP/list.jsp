
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function deleteRecord(userid){
    var doIt=confirm('Do you want to delete the record?');
  if(doIt){
   var f=document.getElementById("UList");
    f.method="post";
    f.action="UserController?action=delete&userId="+userid;
    f.submit();
    }
  else{
alert("Not Deleted");
    }
}
</script>
</head>
<body align="center">
<table border="2" align="center" width="70%" cellpadding="2">
	<h1>List of users</h1></table>
	<table border="2" align="center" width="70%" cellpadding="2"></table>
	
       <table align="center"  class="table table-bordered" style="width: 300px">
         <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Last Name</th>
           <th>email</th>
           <th>Edit/Delete</th>
         </tr>
         
         <c:forEach items="${userList}" var="user">
         <tr>
           <td align="center">${user.userid}</td>
           <td align="center">${user.firstName}</td>
           <td  align="center">${user.lastName}</td>
           <td align="center">${user.email}</td>
           <td  align="center"><a href="edit/${user.userid}">Edit</a>/
           <a href="/SpringJpa/delete/${user.userid}" onclick="deleteRecord(${user.userid});">Delete
           </a></td>
         </tr>
      </c:forEach>	<table border="2" align="center" width="70%" cellpadding="2"></table>
      
</table>
<br />
<a href="new">Add New User</a></body>
</html>
