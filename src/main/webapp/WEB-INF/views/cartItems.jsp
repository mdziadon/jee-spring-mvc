<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Product name</th>
            <th>Product price</th>
            <th>Quantity</th>
            <th>Summary price</th>
        </tr>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
            </tr>
        </c:forEach>
    </table>

    <div>W koszyku jest ${size} pozycji</div>
    <div>Wartość koszyka to ${summary}</div>
</body>
</html>
