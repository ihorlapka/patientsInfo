<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Patient Registration</h1>
    <form:form action="/register" method="post" modelAttribute="patient">
        <div>
            <form:input path="firstName" placeholder="First Name"/>
        </div><br>
        <div>
            <form:input path="lastName" placeholder="Last Name"/>
        </div><br>
        <div>
            <form:input path="age" placeholder="Age"/>
        </div><br>
        <div>
            <form:label path="dateOfBirth" placeholder="Date of Birth"/>
            <input type="date" name="dateOfBirth" value="${patient.dateOfBirth}">
        </div><br>
        <div>
            <form:label path="sex"/>
            <form:radiobutton path="sex" value="MALE"/>Male
            <form:radiobutton path="sex" value="FEMALE"/>Female
            <form:radiobutton path="sex" value="OTHERS"/>Other
        </div><br>
        <div>
            <form:input path="country" placeholder="Country"/>
        </div><br>
        <div>
            <form:input path="state" placeholder="State"/>
        </div><br>
        <div>
            <form:input path="address" placeholder="Address"/>
        </div><br>
        <div>
            <input type="submit" value="Register">
        </div><br>
        <div>
            <a href="/index">Back to home page</a>
        </div>
    </form:form>
</body>
</html>
