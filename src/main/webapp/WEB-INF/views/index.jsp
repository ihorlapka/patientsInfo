<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients Info</title>
    <link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="1" width="100%" cellpadding="2">
    <tr width="28%">
        <td width="28%">
            <a href="/registration" class="btn-newPatient">
                <button>New Patient</button>
            </a>
            <form:form action="/" method="post" modelAttribute="searchedPatient">
                <input type="search" name="search" placeholder="Search Patient">
                <button type="submit" value="Search">Search</button>
            </form:form>
        </td>
        <th>
           <div>
               <div class="clicked">

               </div>
           </div>
        </th>
    </tr>
        <c:forEach items="${searchedPatient}" var="s">
            <tr class="current-patient" width="28%">
                <td>${s.firstName}  ${s.lastName}<br>${s.dateOfBirth}
                    <img src="${s.icon}" alt="icon" width="20" height="35" class="icon">
                    <a href="/changes/${s.id}">
                        <button>edit</button>
                    </a>
                    <form action="/deletePatient/${s.id}" method="post">
                        <button type="submit">delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="javaScript/indexFunctions.js"></script>
</body>
</html>
