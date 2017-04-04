<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 04/04/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
 <b>all Workers</b>
 <br/>
  <c:forEach var="worker" items="${workers}">
      ${worker.id} ${worker.name} ${worker.age} ${worker.wage}
      <br/>
  </c:forEach>
</body>
</html>
