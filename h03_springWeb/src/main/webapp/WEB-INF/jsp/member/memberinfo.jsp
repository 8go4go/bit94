<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>사용자 정보</strong>
			</h3>
		</div>
		<div class="panel-body">
			<form role="form">
				<!-- Text input-->
				<div class="form-group">
					<label for="Email Address">ID</label> <input id="id"
						name="Email Address" type="text" placeholder="id"
						class="form-control" value="8go4go@gmail.com">
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label for="password">패스워드</label> <input id="password"
						name="password" type="password" placeholder="id"
						class="form-control" value="1234567">
				</div>

				<div class="form-group">
					<label for="Name">이름</label> <input id="name" name="name"
						type="text" placeholder="이름" class="form-control input-md"
						value="이상욱">
				</div>

				<!-- File Button -->
				<div class="form-group">
					<label for="Upload photo">사진</label>
					<input id="photo" name="photo" class="input-file" type="file">
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label for="Date Of Birth">생년월일</label> <input id="Date Of Birth"
						name="Date Of Birth" type="text" placeholder="생년월일"
						class="form-control" value="1926년 5월 29일">
				</div>

				<div class="form-group">
					<label for="Gender">성별</label>
					<input type="radio" name="Gender" id="Gender-0" value="1"
						checked="checked"
						>남자 
					
					<input type="radio" name="Gender" id="Gender-1" value="2"
					>여자 
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label for="Phonenumber ">전화번호</label> 
					<input id="phone"
						name="phone" type="text" placeholder="전화번호"
						class="form-control" value="010-2222-2222">
				</div>
				<div class="form-group">
					<label for="Phonenumber ">가능 연락처</label> <input id="phone"
						name="phone" type="text" placeholder="가능한 연락처"
						class="form-control" value="010-2222-2222">
				</div>

				<a href="#" class="btn btn-sm btn-default">수정</a> 
				<a href="${contextPath}/service/main" class="btn btn-sm btn-default">취소</a>
			</form>
		</div>
	</div>
</div>
