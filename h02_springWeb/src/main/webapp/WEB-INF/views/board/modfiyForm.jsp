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
<form action="${contextPath}/board/modifyOk">
<table class="type07">
<tr>
	<th scope="cols"></th>
	<th scope="cols">내용</th>	
</tr>
<tr>
	<td scope="cols">글제목</td>
	<td scope="cols"><input type="text" name="title" value="${modify.title}"></input> </td>	
</tr>
<tr>
	<td scope="cols">글내용</td>
	<td scope="cols"><textarea name="content">${modify.content }</textarea></td>	
</tr>
<tr>
	<td scope="cols">글쓴이</td>
	<td scope="cols"><input type="text" name="writer" value="${modify.writer }"></input></td>	
</tr>
<tr>
	<td colspan="2"><a href="${contextPath}/board/">목록으로</a>
	<input type="hidden" name="no" value="${modify.no }">
	<input type="submit" value="완료" />
	<input type="button" value="취소" />
	</td>
</tr>
</table>
</form>
</body>
</html>