<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
span {
	color:red;
}
h1{
color: red;
text-align: center;
}
</style>
<script src="Js/validation.js"></script>


<b><h1>Employee Register Form </h1></b>
<form:form modelAttribute="emp" action="add" onsubmit="return validate(this)" name="frm">
<!--  <center><form:errors path="*"/></center>-->
<table border="1" bgcolor="cyan" align="center">
<tr>
<td>Employee Name</td>
<td><form:input path="name"/><form:errors path="name"/><span id="nameerr"></span></td>
</tr>
<tr>
<td>Employee Profile</td>
<td><form:input path="profile"/><form:errors path="profile"/><span id="profileerr"></span></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="salary"/><form:errors path="salary"/><span id="salaryerr"></span></td>
</tr>
<script type="text/javascript">
function getState(){
alert(1);
frm.action="stateuri";
frm.submit();
}
</script>
<tr>
<td>Select Country</td>
<td><form:select path="country" onchange="getState()">
<form:options items="${countriesInfo}"/>
</form:select></td>
</tr>
<tr>
<td>Select State</td>
<td><form:select path="state">
<form:options items="${stateInfo}"/>
</form:select></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register Employee"/>
</td>
</tr>
</table>
<form:hidden path="vflag"/>
</form:form>
<br><br>
<center><a href="./" ><img alt="" src="images/home1.png"height="50" width="50"></a></center>
