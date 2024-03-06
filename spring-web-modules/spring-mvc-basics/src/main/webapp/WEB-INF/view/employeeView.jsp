<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Submitted Employee Information</h2>
	<h3>${msg}</h3>
	<table>
		<tr>
			<td>concept :</td>
			<td>${concept}</td>
		</tr>
		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Contact Number :</td>
			<td>${amount}</td>
		</tr>
		<tr>
            <td>retentionPercentage :</td>
            <td>${retentionPercentage}</td>
        </tr>
	</table>
</body>
</html>