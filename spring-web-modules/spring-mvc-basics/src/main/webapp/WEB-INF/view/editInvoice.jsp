<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Invoice</title>
</head>
<body>

<h2>Editar Factura 2</h2>



<form:form method="POST" action="/spring-mvc-basics/invoice/update" modelAttribute="invoice">
		<table>
            <form:hidden path="id"/>
			<tr>
				<td><form:label path="concept">Concepto</form:label></td>
				<td><form:input path="concept" /></td>
				<td><form:errors path="concept" cssClass="error"/></td>
			</tr>

			<tr>
				<td><form:label path="amount">Cantidad</form:label></td>
				<td><form:input path="amount" /></td>
				<td><form:errors path="amount" cssClass="error"/></td>
			</tr>

            <tr>
                <td><form:label path="retentionPercentage">Porcentaje de retencion(%)</form:label></td>
                <td><form:input path="retentionPercentage" /></td>
                <td><form:errors path="retentionPercentage" cssClass="error"/></td>
            </tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
