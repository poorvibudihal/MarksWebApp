<%@ page import="java.util.*, com.model.StudentMark" %>

<h2>Student Marks</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Subject</th><th>Marks</th><th>Date</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>)request.getAttribute("data");

for(StudentMark s : list){
%>
<tr>
<td><%= s.getStudentID() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getSubject() %></td>
<td><%= s.getMarks() %></td>
<td><%= s.getExamDate() %></td>
</tr>
<%
}
%>

</table>