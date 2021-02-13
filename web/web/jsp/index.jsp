<%--
  Created by IntelliJ IDEA.
  User: andrii
  Date: 2/13/2021
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Home</title>
</head>
<body>
    <h2>JSP Home</h2>
    <div>
        ${scheme} <br>
        ${serverName} <br>
        ${portNumber} <br>
        ${contextPath} <br>
        ${servletPath} <br>
        ${pathInfo} <br>
        ${remoteHost} <br>
        ${URI} <br>
        ${URL} <br>
    </div>
    <br>
    <div id="add"></div>
</body>
<script>
    let add = document.querySelector('#add');
    add.textContent = 'Added with JavaScript!'
</script>
</html>
