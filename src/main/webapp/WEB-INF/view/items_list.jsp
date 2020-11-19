<%--
  Created by IntelliJ IDEA.
  User: Martin Zhekov
  Date: 11/17/2020
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.martinzhekov.util.MappingConstantContainer" %>
<html>
<head>
    <title>Todo Items</title>
</head>
<body>
<div align="center">
    <c:url var="addUrl" value="${MappingConstantContainer.ADD_ITEM}"/>
    <a href="${addUrl}">New Item</a>

    <table border="1" cellpadding="5">
        <caption><h2>Todo Items</h2></caption>
        <tr>
            <th>Title</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="item" items="${todoData.items}">
            <c:url var="editUrl" value="${MappingConstantContainer.ADD_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:url var="deleteUrl" value="${MappingConstantContainer.DELETE_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.deadline}"/></td>
                <td>
                    <a href="${editUrl}">Edit</a>
                </td>
                <td>
                    <a href="${deleteUrl}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
