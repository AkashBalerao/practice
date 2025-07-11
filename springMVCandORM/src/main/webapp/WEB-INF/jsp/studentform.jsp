<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="regstudent" modelAttribute="student">

<form:input path="name"/><form:errors path="name" cssClass="error"/><br/>

<form:input path="email"/><form:errors path="email" cssClass="error"/><br/>

<form:input path="age"/> <form:errors path="age" cssClass="error"/><br/>


<input type="submit" value="register student"/>
</form:form>