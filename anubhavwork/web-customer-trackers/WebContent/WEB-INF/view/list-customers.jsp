<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

<title>Customer</title>


</head>
<body>
<h1>Customer Relationship Management</h1>

<input type="button" value="Add Customer" onclick="window.location.href='addCustomer'; return false;" >
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
            <th>Action</th>
		</tr>
		<c:forEach var="tempDemo" items="${customers}">
		<!-- Construct a update link with id -->
		<c:url var="updateLink" value="/customer/showFormUpdate">
		<c:param name="customerId"  value="${tempDemo.id}"></c:param>
		</c:url>
	<!-- construct a delete link with id -->
	
	<c:url var="deleteLink"  value="/customer/processDelete">
	<c:param name="customerId" value="${tempDemo.id}"></c:param>
	</c:url>
		
		  

			<tr>
				<td>${tempDemo.firstName}</td>
				<td>${tempDemo.lastName}</td>
				<td>${tempDemo.email}</td>
				<td><a href="${updateLink}">Update</a> | <a href ="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
			</tr>


		</c:forEach>
	</table>





</body>



</html>
