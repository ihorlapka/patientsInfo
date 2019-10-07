<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>New Patient Registration</h1>
    <form:form action="/register" method="post" modelAttribute="patient">
        <div>
            <form:input path="firstName" placeholder="First Name"/>
        </div>
        <div>
            <form:input path="lastName" placeholder="Last Name"/>
        </div>
        <div>
            <form:input path="age" placeholder="Age"/>
        </div>
        <div>
            <form:label path="dateOfBirth" placeholder="Date of Birth"/>
            <input type="date" name="dateOfBirth" value="${patient.dateOfBirth}">
        </div>
        <div>
            <form:label path="sex"/>
            <input type="radio" name="sex" value="${patient.sex = "MALE"}">Male
            <input type="radio" name="sex" value="${patient.sex = "FEMALE"}">Female
            <input type="radio" name="sex" value="${patient.sex = "OTHER"}">Other
        </div>
        <div>
            <form:input path="country" placeholder="Country"/>
        </div>
        <div>
            <form:input path="state" placeholder="State"/>
        </div>
        <div>
            <form:input path="address" placeholder="Address"/>
        </div>
        <div>
            <input type="submit" value="Register">
        </div>
        <div>
            <a href="/index">Back to home page</a>
        </div>
    </form:form>
</body>
</html>
