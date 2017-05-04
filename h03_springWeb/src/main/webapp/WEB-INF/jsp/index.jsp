<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="kr">
<head>
<script src="https://code.jquery.com/jquery.min.js"></script>
<link
	href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#mainModal").modal("show");
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="비트 경매 사이트에 오신것을 환영합니다.">
<meta name="author" content="bit94 fifth team">
<title>비트 중고 경매</title>
</head>
<body>
	<div id="mainModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">비트 중고 경매</h4>
				</div>
				<div class="modal-body">
					<p>안녕하세요. 비트 경매 사이트 입니다. 많은 경매 정보를 공유하고 질 좋은 경매품으로 여러분에게 보답하겠습니다.
					감사합니다.</p> <p><small>- 비트 중고 경매 일동 -</small></p>
				</div>
				<div class="modal-footer">
					<form class="form-horizontal" action="/service/main" role="form" method="POST">
						<button type="submit" class="btn btn-primary" id="submitForm">메인으로</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
