<%--
  Created by IntelliJ IDEA.
  User: MR. NEN
  Date: 11/15/2022
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProducServelet" method="get">
  <input type="text" name="productsearch">
  <input type="submit" value="search" name="action">
</form>
<table border="1">
  <thead>
  <tr>
    <th>ProductId</th>
    <th>ProductName</th>
    <th>Price</th>
    <th>Date Created</th>
    <th>Descriptions</th>
    <th>Product Status</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listproduct}" var="pro">

    <tr>
      <td>${pro.productId}</td>
      <td>${pro.productName}</td>
      <td>${pro.price}</td>
      <td><fmt:formatDate value="${pro.dateCreated}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
      <td>${pro.descriptions}</td>
      <td>${pro.productStatus?"Còn hàng":"Hết hàng"}</td>
      <td>
        <a href="<%=request.getContextPath()%>/ProducServelet?productId=${pro.productId}&&action=update">Update</a>
        <a href="<%=request.getContextPath()%>/ProducServelet?productId=${pro.productId}&&action=delete">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="views/newproduct.jsp">Create New Product</a>
</body>
</html>
