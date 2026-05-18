<%@page import="model.MajorBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <p><%=request.getAttribute("message")
%>
</p>


<h3>Major Information</h3>
<%
List<MajorBean> lists= (List<MajorBean>) request.getAttribute("list");
for(MajorBean major :lists){
	out.println(major.getMajor_name()+", "+major.getMarks()+", " + "<a href='major-update?id=" +major.getId()+ "'>edit</a>"+"," + "<a href='major-delete?id=" +major.getId()+ "'>remove</a>"+"<br>");
}
%> 

<table>
<tr>
<th>Name</th>
<th>Marks</th>
<th>Action</th>

</tr>
<c:forEach items="${lists }" var="obj">
<tr>
<td>${obj.major_name }</td>
<td>${obj.marks }</td>
<td> 
<a href="major-update?id=${obj.id }">edit</a>
 <a href="major-delete?id=${obj.id }">remove</a>"
</td>

</tr>
</c:forEach>



</table>

</body>
</html>