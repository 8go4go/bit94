<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-md-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>로그인</strong>
			</h3>
		</div>
		<div class="panel-body">
			<form role="form" id="loginForm" method="POST">
				<div class="form-group">
					<label for="exampleInputEmail1">사용자 ID(email id)</label> <input
						type="email" class="form-control" id="USRID" name="USRID"
						placeholder="이메일 ID를 입력하세요">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">패스워드 <a
						href="/sessions/forgot_password">(패스워드 찾기)</a></label> <input
						type="password" class="form-control" id="PASSWD" name="PASSWD"
						placeholder="패스워드를 입력하세요">
				</div>
				<button type="submit" class="btn btn-sm btn-default" id="loginbtn">로그인</button>
				<button type="button" class="btn btn-default" data-dismiss="loginModal">취소</button>
			</form>
		</div>
	</div>
</div>

<script>
	$('#loginbtn').click(function(event){
		$.ajax({
			   type : 'POST',
			   url : '/member/loginConfirm',
			   dataType: 'text',
			   cache : false,
			   data : $('#loginForm').serialize(),
			   success : function(result) {
				   var jsonData = $.parseJSON(result);
				   $('#auctionMenu').after("<a id=userinfo href='/member/memberinfo'>" + jsonData.usrid + "</a>");
			   },
			   error : function(request, status, error) {
				    if (request.status === 0) {
						msg = 'Not connect.\n Verify Network.';
					} else if (request.status == 404) {
						msg = 'Requested page not found. [404]';
					} else if (request.status == 500) {
						msg = 'Internal Server Error [500].';
					} else if (error === 'parsererror') {
						msg = 'Requested JSON parse failed.';
					} else if (error === 'timeout') {
						msg = 'Time out error.';
					} else if (error === 'abort') {
						msg = 'Ajax request aborted.';
					} else {
						msg = 'Uncaught Error.\n' + request.responseText;
					}
				    
				    $('#loginForm').after("<p> "+msg+"</p>");
				    $('#loginForm').after(error.responseText);
			   }
		});
		event.preventDefault();
	});
</script>