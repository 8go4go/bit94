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
	<th scope="cols">글번호</th>
	<th scope="cols">글제목</th>
	<th scope="cols">글쓴이</th>
	<th scope="cols">등록일</th>
</tr>
<c:forEach var="board" items="${boardList}">
 <tr>
 <td scope="row">${board.no}</td>
 <td><a href="${contextPath}/board/detail?no=${board.no}">${board.title}</a></td> 
 <td>${board.writer}</td>
 <td>${board.reg_date}</td>
 </tr>
</c:forEach>
</table>
<form action="${contextPath}/board/write">
<input type="submit" value="글쓰기" />
</form>
</body>
</html>