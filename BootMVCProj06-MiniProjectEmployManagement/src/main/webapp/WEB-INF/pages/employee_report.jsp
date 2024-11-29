<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<b><h1 style="color: blue; text-align: center;">Employee
		Detalis</h1></b>
<c:choose>
	<c:when test="${!empty employeeList.getContent()}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<td>Employee Id</td>
				<td>Employee Name</td>
				<td>Employee Profile</td>
				<td>Employee Salary</td>
				<td>Employee Country</td>
				<td>Employee State</td>
				<td>Operations</td>
			</tr>
			<c:forEach var="emp" items="${employeeList.getContent()}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.profile}</td>
					<td>${emp.salary}</td>
					<td>${emp.country}</td>
					<td>${emp.state}</td>
					<td><a href="edit?no=${emp.id}"><img alt="no"
							src="images/edit.png" height="50" width="50"></a>&nbsp&nbsp<a
						onclick="return confirm('Do You Want to Delete')"
						href="delete?no=${emp.id}"><img alt="no"
							src="images/delete.png" height="50" width="50"></a></td>
				</tr>
			</c:forEach>

		</table>
		<center>
			<a href="show_report?page=0">first</a>&nbsp&nbsp

			<c:if test="${!employeeList.isFirst() }">
				<a href="show_report?page=${employeeList.getNumber()-1}">previous</a>
			</c:if>
			&nbsp&nbsp
			<c:forEach var="i" begin="1" end="${employeeList.getTotalPages()}"
				step="1">
[<a href="show_report?page=${i-1}">${i}</a>]&nbsp&nbsp
</c:forEach>
			<c:if test="${!employeeList.isLast() }">
				<a href="show_report?page=${employeeList.getNumber()+1}">next</a>
			</c:if>
			&nbsp&nbsp <a
				href="show_report?page=${employeeList.getTotalPages()-1}">last</a>
		</center>

	</c:when>
	<c:otherwise>
		<b><h1 style="color: red; text-align: center;">No RecordFound</h1></b>
	</c:otherwise>
</c:choose>
<c:if test="${!empty resultMsg}">
	<h3 style="color: green; text-align: center;">${resultMsg}</h3>
</c:if>
<br>

<br>
<center>
	<a href="add"><img alt="no" src="images/add.png" height="50"
		width="50"><b>Add Employee</b></a><br> <br> <a href="./"><img
		alt="" src="images/home1.png" height="50" width="50"></a>
</center>










