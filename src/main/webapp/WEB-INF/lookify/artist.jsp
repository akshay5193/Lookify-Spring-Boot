<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>Artist Details coming soon...</h1>
		
		<table>
			
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artistSongs}" var="artistSong">
				<tr>
					<td> <a href="/songs/${artistSong.id }"><c:out value="${artistSong.title }"/></a> </td>
					<td><c:out value="${artistSong.rating }"/></td>
					<td>
						<form action="/songs/${artistSong.id}" method="post">
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