<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myPath" value="${pageContext.request.contextPath}" />
<c:set var="boardList" value="${requestScope.list}" />

<c:out value="${request.contentType}" />

<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 0px;
}

#center {
	width: 696px;
}

#right {
	width: 0px;
}

td {
	font-size: 12px;
	padding: 5px;
	margin:5px 5px;	
} 

tr:NTH-CHILD(odd) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #1c64d1;
	border-right: 10px solid #5ba3e0;
/* 	background-color: #2586d7; */
} 

tr:NTH-CHILD(even) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #ffffff;
	border-right: 10px solid #ffffff;
/* 	background-color: #2586d7; */
} 

</style>
<script type="text/javascript">
	
</script>

<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>

		<div id="center" class="over_container">
			<h1 style="font-size: 16px; text-align: center;">Q.N.A</h1>
			<hr>
			<table id="table_board" class="list">
				<colgroup>
					<!-- 번호 , 사진, 제목, 작성자, 조회수, 작성일 -->
					<col width="30px">
					<col width="52px">
					<col width="462px">
					<col width="55px">
					<col width="55px">
					<col width="60px">
				</colgroup>
				<thead><tr>
					<th>NO</th>
					<th>사진</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr></thead>
				<tbody>
					<c:choose>
					<c:when test="${not empty boardList}" >
					<c:forEach var="board" items="${boardList}" >
						<tr>
							<td><c:out value="${board.BOARD_NO}"/></td>
							<td><c:out value="${board.FILE_NM}"/></td>
							<td><c:out value="${board.TITLE}"/></td>
							<td><c:out value="${board.USERID}"/></td>
							<td><c:out value="${board.REVIEW_CNT}"/></td>
							<td><c:out value="${board.REG_DATE}"/></td>
						</tr>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6" align="center">작성된 글목록이 없습니다.</td>
						</tr>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />