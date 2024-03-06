<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Invoices List</title>
</head>
<body>
<h2>Lista de facturas </h2>
<p>Solo se puede eliminar o editar los registros del 4 en adelante, ya que los anteriores, estan guardados en fisico en el Mapa</p>
<table>
    <tr>
        <th>ID</th>
        <th>Concept</th>
        <th>Amount</th>
        <th>Retention Percentage</th>
        <th>Final Amount</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="invoice" items="${invoices}">
        <tr>
            <td>${invoice.id}</td>
            <td>${invoice.concept}</td>
            <td>${invoice.amount}</td>
            <td>${invoice.retentionPercentage}</td>
            <td>${finalAmounts[invoice.id]}</td>
            <td>
                <form action="/spring-mvc-basics/invoice/edit/${invoice.id}" method="get"><input type="submit" value="Edita"/></form>
            </td>

            <td><form action="/spring-mvc-basics/invoice/delete/${invoice.id}" method="post"> <input type="submit" value="Elimina"/>
            </form></td>


        </tr>
    </c:forEach>
</table>
<a href="/spring-mvc-basics/invoice">Crea una factura nueva</a>
</body>
</html>
