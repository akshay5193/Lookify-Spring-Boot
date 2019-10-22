<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<h1>Lookify Dashboard</h1>
		
		<a href="/songs/new">Add New</a> 
		<span>  |   </span>
		<a href="/topTen">Top Songs</a>
	
<!-- SEARCH block -->

		<form:form action="/search" modelAttribut="song" method="get">
		        <input type="text" name="artist"/>
		    <input type="submit" value="Search Artist Songs"/>
		</form:form>
		    
<!-- End SEARCH block -->
		
		<h3>All Songs</h3>
		
		<table>
			
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
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