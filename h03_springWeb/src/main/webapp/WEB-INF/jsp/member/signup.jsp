<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-8">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>회원가입</strong>
			</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" method="post" 
				enctype="multipart/form-data" id="signupForm">
				<div class="form-group">
					<label class="control-label col-sm-3">회원구분 <span
						class="text-danger">*</span></label>
					<div class="col-md-8 col-sm-9">
						<label> <input name="USR_CD" type="radio" value="1">
							기업
						</label> <label> <input name="USR_CD" type="radio" value="2"
							checked> 개인
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">이메일ID <span
						class="text-danger">*</span></label>
					<div class="col-md-8 col-sm-9">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input type="email"
								class="form-control" name="EMAIL" id="EMAIL"
								placeholder="Email을 입력하세요" value="8go4go@gmail.com">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3">패스워드<span
						class="text-danger">*</span></label>
					<div class="col-md-5 col-sm-8">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								class="form-control" name="PASSWD" id="PASSWD"
								placeholder="5~15자로 패스워드를 입력하세요" value="1234">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">패스워드 확인<span
						class="text-danger">*</span></label>
					<div class="col-md-5 col-sm-8">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								class="form-control" name="CPASSWD" id="CPASSWD"
								placeholder="다시한번 패스워드를 입력하세요" value="1234">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">연락처<span
						class="text-danger">*</span></label>
					<div class="col-md-5 col-sm-8">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone"></i></span> <input type="text"
								class="form-control" name="TELNO" id="TELNO"
								placeholder="연락처를 입력하세요" value="010-1234-1234">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">우편번호<br></label>
					<div class="col-md-5 col-sm-8">
						<input type="text" class="form-control" name="ZIPNO"
							id="ZIPNO" placeholder="우편번호를 입력하세요" value="132123">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">주소<br></label>
					<div class="col-md-5 col-sm-8">
						<input type="text" class="form-control" name="ADDRESS"
							id="ADDRESS" placeholder="주소를 입력하세요" value="서울시 마포구 대흥동">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">프로필 사진<br> <small>(선택)</small></label>
					<div class="col-md-5 col-sm-8">
						<div class="input-group">
							<span class="input-group-addon" id="file_upload"><i
								class="glyphicon glyphicon-upload"></i></span> <input type="file"
								name="FILE_NM" id="FILE_NM" class="form-control upload"
								placeholder="" aria-describedby="file_upload">
						</div>
					</div>
				</div>
				
				<!-- 개인 회원 영역 -->
				<div id="div_privateUser" class="form-group">
				<div class="form-group">
					<label class="control-label col-sm-3">이 름<span
						class="text-danger">*</span></label>
					<div class="col-md-8 col-sm-9">
						<input type="text" class="form-control" name="NM"
							id="NM" placeholder="이름을 입력하세요" value="이상욱">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">생년월일<span
						class="text-danger">*</span></label>
					<div class="col-md-8 col-sm-9">
						<input type="text" class="form-control" name="SOCIAL_NO"
							id="SOCIAL_NO" placeholder="생년월일을 입력하세요" value="19760528">
					</div>
				</div>
				</div>
				<!-- 기업 회원 영역 -->
				<div id="div_companyUser" class="form-group" style="display:none"">
					<div class="form-group">
						<label class="control-label col-sm-3">회사명<span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<input type="text" class="form-control" name="COM_NM"
								id="COM_NM" placeholder="회사명을 입력하세요" value="비트컴퓨터">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">사업자등록번호<span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<input type="text" class="form-control" name="BUS_NO"
								id="BUS_NO" placeholder="사업자등록번호를 입력하세요" value="132454545">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">대표자명<span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<input type="text" class="form-control" name="CEO_NM"
								id="CEO_NM" placeholder="대표자명을 입력하세요" value="이상욱">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">담당자명<span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<input type="text" class="form-control" name="CHG_NM"
								id="CHG_NM" placeholder="담당자명을 입력하세요" value="이상욱">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-offset-3 col-xs-10">
						<input type="submit" name="Submit" value="가입하기"
							class="btn btn-primary" id="signupbtn"> 
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$("input[name=USR_CD]").bind("click", usr_cdFunc);

		function usr_cdFunc() {
			var radioValue = $(this).val();
			if (radioValue == "1") {
				$("#div_privateUser").css("display", "none");
				$("#div_companyUser").css("display", "block");
			} else {
				$("#div_privateUser").css("display", "block");
				$("#div_companyUser").css("display", "none");
			} 
		}
	});
	
	$('#signupbtn').click(function(event){
		var joinUrl;
		var radioValue = $("input[name=USR_CD]:checked").val();
		if (radioValue == "1") { // 기업
			joinUrl = '/member/signupConfirm/company';
		} else {                 // 개인
			joinUrl = '/member/signupConfirm/private';
		}
		
		$.ajax({
			   type : 'POST',
			   url : joinUrl,
			   dataType: 'text',
			   cache : false,
			   data : $('#signupForm').serialize(),
			   success : function(result) {
				   var jsonData = $.parseJSON(result);
				   console.log(jsonData);
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
				    
				    $('#signupForm').after("<p> "+msg+"</p>");
				    $('#signupForm').after(error.responseText);
			   }
		});
		event.preventDefault();
	});
	
	
</script>
