<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp"></jsp:include>
<div class="col-md-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>로그인</strong>
			</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="/member/loginConfirm">
				<div class="form-group">
					<label for="exampleInputEmail1">사용자 ID(email id)</label> <input
						type="email" class="form-control" id="USRID"
						placeholder="이메일 ID를 입력하세요">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">패스워드 <a
						href="/sessions/forgot_password">(패스워드 찾기)</a></label> <input
						type="password" class="form-control"
						id="PASSWD" placeholder="패스워드를 입력하세요">
				</div>
				<button type="submit" class="btn btn-sm btn-default">로그인</button>
				<button type="submit" class="btn btn-sm btn-default">취소</button>
			</form>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>	