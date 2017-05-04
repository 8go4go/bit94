<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp"></jsp:include>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10 ">
				<form class="form-horizontal">
					<fieldset>

						<!-- Form Name -->
						<legend>사용자 정보</legend>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Email Address">ID</label>
							<div class="col-md-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope-o"></i>

									</div>
									<input id="id" name="Email Address" type="text"
										placeholder="id" class="form-control input-md"
										value="8go4go@gmail.com">
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="password">패스워드</label>
							<div class="col-md-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope-o"></i>

									</div>
									<input id="password" name="password" type="text"
										placeholder="id" class="form-control input-md"
										value="*********">
								</div>
							</div>
						</div>


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label" for="Name">이름</label>
							<div class="col-md-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"> </i>
									</div>
									<input id="name" name="name" type="text" placeholder="이름"
										class="form-control input-md" value="이상욱">
								</div>
							</div>
						</div>

						<!-- File Button -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Upload photo">사진</label>
							<div class="col-md-4">
								<input id="photo" name="photo" class="input-file" type="file">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Date Of Birth">생년월일</label>
							<div class="col-md-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-birthday-cake"></i>
									</div>
									<input id="Date Of Birth" name="Date Of Birth" type="text"
										placeholder="생년월일" class="form-control input-md"
										value="1926년 5월 29일">
								</div>
							</div>
						</div>

						<!-- Multiple Radios (inline) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Gender">성별</label>
							<div class="col-md-4">
								<label class="radio-inline" for="Gender-0"> <input
									type="radio" name="Gender" id="Gender-0" value="1"
									checked="checked"> 남자
								</label> <label class="radio-inline" for="Gender-1"> <input
									type="radio" name="Gender" id="Gender-1" value="2"> 여자
								</label>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Phonenumber ">전화번호</label>
							<div class="col-md-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-phone"></i>

									</div>
									<input id="phone" name="phone" type="text" placeholder="전화번호"
										class="form-control input-md" value="010-2222-2222">

								</div>
								<div class="input-group othertop">
									<div class="input-group-addon">
										<i class="fa fa-mobile fa-1x" style="font-size: 20px;"></i>

									</div>
									<input id="phone" name="phone" type="text"
										placeholder="가능한 연락처" class="form-control input-md"
										value="010-2222-2222">
								</div>

							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<a href="#" class="btn btn-success" data-toggle="modal" data-target="#mainModal"><span
									class="glyphicon glyphicon-thumbs-up" ></span>수정</a> 
									<a href="${contextPath}/service/main" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove-sign"></span>
									취소</a>

							</div>
						</div>

					</fieldset>
				</form>
			</div>
			<div class="col-md-2 hidden-xs">
				<img src="http://websamplenow.com/30/userprofile/images/avatar.jpg"
					class="img-responsive img-thumbnail ">
			</div>
		</div>
	</div>
	<div id="mainModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">회원정보 수정</h4>
				</div>
				<div class="modal-body">
					<p>회원정보 수정이 완료 되었습니다. 메인 페이지로 이동으로 누르면 메인 페이지로 이동합니다.</p><p>감사합니다.</p>
					<p>
				</div>
				<div class="modal-footer">
					<form class="form-horizontal" action="/service/main" role="form"
						method="POST">
						<button type="submit" class="btn btn-primary" id="submitForm">메인으로</button>
					</form>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>