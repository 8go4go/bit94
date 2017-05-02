<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/board.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function movePage(code) {
		if(code == 1)
			$("#target").attr({action:'${contextPath}/board/modify'}).submit();
		else {
			var result = confirm('삭제하시겠습니까?');
			if(result == true)
				$("#target").attr({action:'${contextPath}/board/deleteOk'}).submit();
		}
			
	}
</script>
</head>
<body>

<form id="target">
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
	<td colspan="2">
	<input type="hidden" id="no" name="no" value="${detail.no}" />
	<input type="hidden" id="title" name="title" value="${detail.title }" />
	<input type="hidden" id="content" name="content" value="${detail.content }" />
	<input type="hidden" id="writer" name="writer" value="${detail.writer }" />
	
	<input type="submit" id="modify" value="수정" onclick="movePage(1);" />
	<input type="submit" id="delete" value="삭제" onclick="movePage(2);" />
	<input type="button" value="취소" />
	<a href="${contextPath}/board/">목록으로</a>
	</td>
</tr>
</table>
</form>
</body>
</html>