
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<body>
	<h1>Add Customer</h1>

	<form:form method="post" action="saveCustomer"
		modelAttribute="customer">
		
		<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
		<table>

			<tr>
				<td><label> FirstName:</label></td>
				<td><form:input path="firstName" /></td>
</tr>
	<tr>			<td><label>LastName</label></td>
				<td><form:input path="lastName" /></td>

</tr><tr>
				<td><label>Email</label></td>
				<td><form:input path="email" /></td>
				</tr>
				<tr><td><label></label></td>
				<td><input type="submit" value="Save" /></td>
</tr>
			



		</table>
	</form:form>

</body>


</html>
