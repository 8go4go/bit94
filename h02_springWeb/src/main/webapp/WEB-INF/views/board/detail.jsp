<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/board.css" >
<title>Insert title here</title>
</head>
<body>

<table class="type07">
<tr>
	<th scope="cols"></th>
	<th scope="cols">내용</th>	
</tr>
<tr>
	<td scope="cols">글번호</td>
	<td scope="cols">${detail.no}</td>	
</tr>
<tr>
	<td scope="cols">글제목</td>
	<td scope="cols">${detail.title}</td>	
</tr>
<tr>
	<td scope="cols">글내용</td>
	<td scope="cols">${detail.content}</td>	
</tr>
<tr>
	<td scope="cols">글쓴이</td>
	<td scope="cols">${detail.writer}</td>	
</tr>
<tr>
	<td colspan="2"><a href="${contextPath}/board/">목록으로</a></td>
</tr>
</table>

</body>
</html>