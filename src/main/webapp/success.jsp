
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/3
  Time: 上午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>部门</th>
        <th>职位</th>
    </tr>
    <c:forEach items="${staffs}" var="staffs">
    <tr>
        <th>${staffs.id}</th>
        <th>${staffs.name}</th>
        <th>${staffs.gender}</th>
        <th>${staffs.age}</th>
        <th>${staffs.department.name}</th>
        <th>${staffs.post.name}</th>
    </tr>
    </c:forEach>
</table>
</body>
</html>
