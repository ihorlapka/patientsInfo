<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update patient</title>
    <link rel="stylesheet" href="css/indexStyle.css" type="text/css">
</head>
<body>
<form:form action="/updatePatient" method="post" modelAttribute="patient">
    <h2>${patient.firstName}</h2>
    <h2>${patient.lastName}</h2>
    <h2>${patient.age}</h2>
    <div>
        <form:label path="dateOfBirth"><pre>Date of Birth: </pre></form:label>
        <input type="date" name="dateOfBirth" value="${patient.dateOfBirth}">
    </div>
    <div>
        <form:label path="sex">
            <pre>Sex: </pre>
        </form:label>
        <form:radiobutton path="sex" value="MALE"/>Male
        <form:radiobutton path="sex" value="FEMALE"/>Female
        <form:radiobutton path="sex" value="OTHERS"/>Other
    </div>
    <div>
        <form:label path="country">
            <pre>Country: </pre>
        </form:label>
        <form:input path="country" placeholder="${patient.country}"/>
    </div>
    <div>
        <form:label path="state">
            <pre>State: </pre>
        </form:label>
        <form:input path="state" placeholder="${patient.state}"/>
    </div>
    <div>
        <form:label path="address">
            <pre>Address: </pre>
        </form:label>
        <form:input path="address" placeholder="${patient.address}"/>
    </div>
    <div>
        <form:input path="id" value="${patient.id}" type="hidden"/>
        <form:input path="firstName" value="${patient.firstName}" type="hidden"/>
        <form:input path="lastName" value="${patient.lastName}" type="hidden"/>
        <form:input path="icon" value="${patient.icon}" type="hidden"/>
    </div>
    <br>
    <div>
        <input type="submit" value="Update">
    </div>
</form:form>
    <div>
        <a href="/">
            <button><-Back to index</button>
        </a>
    </div>
    <br>
    <br>
    <br>
    <div>
        <table border="1" width="50%" cellpadding="2" class="comments">
            <tr>
                <td><h2>Comments:</h2></td>
            </tr>
            <c:forEach items="${patient.comments}" var="pc">
                <tr>
                    <td>
                        <div>${pc.postedDate}</div>
                        <div>${pc.context}</div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    <form method="post" action="/addComment/${patient.id}">
                        <input type="text" name="comment">
                        <button type="submit">+</button>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
