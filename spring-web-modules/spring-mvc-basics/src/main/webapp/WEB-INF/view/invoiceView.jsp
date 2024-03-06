<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Factura enviada</h2>
	<table>

		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Concepto :</td>
			<td>${concept}</td>
		</tr>

        <tr>
            <td>Importe Bruto :</td>
            <td>${amount}</td>
        </tr>
        <tr>
            <td>Porcentaje de Retencion (%)	 :</td>
            <td>${retentionPercentage}</td>
        </tr>

        <tr>
            <td>Importe Neto :</td>
            <td>${finalAmount}</td>
        </tr>
        <tr>

        <td><a href="/spring-mvc-basics/invoice">Crea una factura nueva</a></td>
         <td><a href="/spring-mvc-basics/showInvoices">Mostrar todas las facturas</a></td>
        </tr>

	</table>
</body>
</html>