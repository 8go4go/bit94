<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container">
	<form class="form-horizontal">
		<!-- Form Name -->
		<legend>경매 상품 등록</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">경매 상품명</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="경매 상품 명을 입력하세요" class="form-control input-md">
			</div>
		</div>

		<!-- Textarea -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textarea">경매 상품 설명</label>
			<div class="col-md-4">
				<textarea class="form-control" id="textarea" name="textarea"></textarea>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">경매 시작
				가격</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="경매 시작 가격을 입력하세요" class="form-control input-md">

			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">경매
				카테고리 선택</label>
			<div class="col-md-4">
				<select id="selectbasic" name="selectbasic" class="form-control">
					<option value="1">전자제품</option>
					<option value="2">의류</option>
					<option value="3">티켓</option>
				</select>
			</div>
		</div>

		<!-- File Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="filebutton">사진 등록(320*150)</label>
			<div class="col-md-4">
				<input id="filebutton" name="filebutton" class="input-file"
					type="file">
			</div>
		</div>

		<!-- File Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="filebutton">사진 등록(800*300)</label>
			<div class="col-md-4">
				<input id="filebutton" name="filebutton" class="input-file"
					type="file">
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">검색 키워드
				입력</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="검색할 키워드를 입력해 주세요" class="form-control input-md">
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">수량</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="상품 수량을 입력하세요" class="form-control input-md">

			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">경매 시작일</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="경매 시작일시를 입력하세요" class="form-control input-md">

			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">경매 종료일</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text"
					placeholder="경매 종료일시를 입력하세요" class="form-control input-md">

			</div>
		</div>
	</form>
	
	<div id="mainModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
	
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">비트 중고 경매</h4>
					</div>
					<div class="modal-body">
						<p>안녕하세요. 비트 경매 사이트 입니다. 정상적으로 상품등록이 완료 되었습니다. 
						감사합니다.</p> 
					</div>
					<div class="modal-footer">
						<form class="form-horizontal" action="/service/main" role="form" method="POST">
							<button type="submit" class="btn btn-primary" id="submitForm">메인으로</button>
						</form>
					</div>
				</div>
	
			</div>
		</div>
	<!-- Button -->
	<div class="form-group">
		<label class="col-md-4 control-label" for="singlebutton"></label>
		<div class="col-md-4">
			<button id="singlebutton" name="singlebutton" 
			class="btn btn-success" data-toggle="modal" data-target="#mainModal" >등록</button>
			<button id="singlebutton" name="singlebutton" class="btn btn-success">취소</button>
		</div>
	</div>

</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
