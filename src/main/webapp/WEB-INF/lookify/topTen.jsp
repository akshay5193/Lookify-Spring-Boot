<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<table>
			
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${topTenSongs}" var="song">
				<tr>
					<td> <a href="/songs/${song.id }"><c:out value="${song.title }"/></a> </td>
					<td><c:out value="${song.rating }"/></td>
					<td>
						<form action="/songs/${song.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
	</body>
</html>