<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
span
{
color:red;
}
</style>
<script src="Js/validation.js"></script>
<h1 style="color: red;text-align: center;">Employee Edit Form</h1>
<form:form modelAttribute="emp" onsubmit="return validate(this)">
<!--<center><form:errors path="*"/></center>-->
<table border="1" bgcolor="cyan" align="center">
<tr>
<td>Employee Id</td>
<td><form:input path="id" readonly="true"/> </td>
</tr>
<tr>
<td>Employee Name</td>
<td><form:input path="name"/><form:errors path="name"/><span id="nameerr"></span> </td>
</tr>
<tr>
<td>Employee Profile</td>
<td><form:input path="profile"/> <form:errors path="profile"/><span id="profileerr"></span></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="salary"/><form:errors path="salary"/><span id="salaryerr"></span></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Edit Employee"></td>
</tr>
</table>
<form:hidden path="vflag"/>
</form:form><br> 
<center><a href="./" ><img alt="" src="images/home1.png"height="50" width="50"></a></center>