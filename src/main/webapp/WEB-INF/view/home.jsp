<%--
  Created by IntelliJ IDEA.
  User: Martin Zhekov
  Date: 18.11.2020 г.
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.martinzhekov.util.MappingConstantContainer" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLink" value="${MappingConstantContainer.ITEMS}"/>
    <h2>
        <a href="${itemsLink}">Show Todo Items</a>
    </h2>
</div>
</body>
</html>
