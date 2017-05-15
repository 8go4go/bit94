<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myPath" value="${pageContext.request.contextPath}" />



<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<script type="text/javascript">
	function view(index) {
		var tr = document.getElementById('replay' + index);
		tr.style = "display:block";
	}
</script>

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 132px;
}

#center {
	width: 432px;
}

#right {
	width: 132px;
}

table {
	width: 400px
}

td {
	font: bold;
	text-align: center;
	margin: 10px;
	padding: 10px;
	text-shadow: 1px 1px 0px #BEE2F9;
}

th:FIRST-CHILD, td:FIRST-CHILD {
	width: 35%;
	font: bold;
	text-align: center;
	margin: 10px;
	padding: 10px;
	text-shadow: 1px 1px 0px #BEE2F9;
}

#ZIPNO1, #ZIPNO2 {
	text-align: center;
}

</style>
<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>
		<div id="center" class="over_container">
			<h1 style="font-size: 16px; text-align: center;">F.A.Q</h1>
			<hr>
			<table>
				<tr>
					<td>글번호</td>
					<td>제목</td>
				</tr>
				<tr onmouseover="view(1);" >
					<td>1</td>
					<td>입찰 (Last Update : 2015-03-23)</td>
				</tr>
				<tr id="replay1" style="display:none;" >
					<td colspan="2">
					   입찰은 뷰티넷 마일리지 단위인 BM을 이용합니다. 
					   본인의 등급에 맞는 경매에만 입찰이 허용됩니다. (회원 등급제 안내 참고)
					   입찰 취소는 원칙적으로 불가능 합니다.
					   입찰이 되지 않는 경우에는 마감시간 / 참여등급 / 입찰BM수 / 옵션 등을 확인하시기 바랍니다.
					   마감연장이란? 종료시간 5분이내에 입찰이 있는 경우 자동으로 종료시간이 1회 5분 연장되는 것입니다.
					</td>
				</tr>
				<tr onmouseover="view(2);" onmouseleave="viewOut(2);">
					<td>2</td>
					<td>입찰 (Last Update : 2015-03-23)</td>
				</tr>
				<tr id="replay2" style="display:none;" >
					<td colspan="2">
					   입찰은 뷰티넷 마일리지 단위인 BM을 이용합니다. 
					   본인의 등급에 맞는 경매에만 입찰이 허용됩니다. (회원 등급제 안내 참고)
					   입찰 취소는 원칙적으로 불가능 합니다.
					   입찰이 되지 않는 경우에는 마감시간 / 참여등급 / 입찰BM수 / 옵션 등을 확인하시기 바랍니다.
					   마감연장이란? 종료시간 5분이내에 입찰이 있는 경우 자동으로 종료시간이 1회 5분 연장되는 것입니다.
					</td>
				</tr>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />