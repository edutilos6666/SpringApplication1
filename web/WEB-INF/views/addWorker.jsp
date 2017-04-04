<%--
  Created by IntelliJ IDEA.
  User: edutilos
  Date: 05/04/2017
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>addWorker</title>
</head>
<body>
   <form:form method="POST" action="/addWorkerPost">
    <form:label path="id">Id: </form:label>
       <form:input path="id"/>
       <br/>

       <form:label path="name">Name: </form:label>
       <form:input path="name"/>
       <br/>


       <form:label path="age">Age: </form:label>
       <form:input path="age"/>
       <br/>


       <form:label path="wage">Wage: </form:label>
       <form:input path="wage"/>
       <br/>


       <input type="submit" value="Submit" />
       <br/>
   </form:form>
</body>
</html>
