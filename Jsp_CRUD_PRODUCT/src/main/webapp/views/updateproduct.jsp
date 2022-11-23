<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/12/2022
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<div class="mot">
<form action="<%=request.getContextPath()%>/ProducServelet" method="post">
    <table>
        <tr>
            <td> Product Id</td>
            <td><input type="number" name="productId" value="${productupdate.productId}" readonly></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName" value="${productupdate.productName}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price" value="${productupdate.price}"></td>
        </tr>
        <tr>
            <td>Date Created</td>
            <td><input type="date" name="dateCreated" value="${productupdate.dateCreated}"></td>
        </tr>
        <tr>
            <td>Descriptions</td>
            <td><input type="text" name="descriptions" value="${productupdate.descriptions}"></td>
        </tr>
        <tr>
            <td>Product Status</td>
            <td>
            <c:choose>
                <c:when test="${productupdate.productStatus}">
                    <input type="radio" name="status" id="active" value="true" checked/><lable for="active">Còn Hàng</lable>
                    <input type="radio" name="status" id="inactive" value="false"/><labale for="inactive">Hết Hàng</labale>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="status" id="active" value="true"/><lable for="active">Còn Hàng</lable>
                    <input type="radio" name="status" id="inactive" value="false" checked/><lable for="inactive">Hết Hàng</lable>
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="update" name="action">
            </td>
        </tr>
    </table>
</form>
</div>
<style>
    .mot{
        border: 2px solid black;
        padding: 10px;
    position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    td{
        padding: 2px;
    }
    input{
        padding: 5px;
    }
</style>
</body>
</html>
