<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp"></jsp:include>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h1 class="entry-title">
					<span>회원가입</span>
				</h1>
				<hr>
				<form class="form-horizontal" method="post" name="signup"
					id="signup" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-sm-3">이메일ID <span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input type="email"
									class="form-control" name="emailid" id="emailid"
									placeholder="Email을 입력하세요" value="">
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
									class="form-control" name="password" id="password"
									placeholder="5~15자로 패스워드를 입력하세요" value="">
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
									class="form-control" name="cpassword" id="cpassword"
									placeholder="다시한번 패스워드를 입력하세요" value="">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">이 름<span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<input type="text" class="form-control" name="mem_name"
								id="mem_name" placeholder="이름을 입력하세요" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">생년월일<span
							class="text-danger">*</span></label>
						<div class="col-xs-8">
							<div class="form-inline">
								<div class="form-group">
									<select name="yyyy" class="form-control">
										<option value="0">년</option>
										<option value="1955">1955</option>
										<option value="1956">1956</option>
										<option value="1957">1957</option>
										<option value="1958">1958</option>
										<option value="1959">1959</option>
										<option value="1960">1960</option>
										<option value="1961">1961</option>
										<option value="1962">1962</option>
										<option value="1963">1963</option>
										<option value="1964">1964</option>
										<option value="1965">1965</option>
										<option value="1966">1966</option>
										<option value="1967">1967</option>
										<option value="1968">1968</option>
										<option value="1969">1969</option>
										<option value="1970">1970</option>
										<option value="1971">1971</option>
										<option value="1972">1972</option>
										<option value="1973">1973</option>
										<option value="1974">1974</option>
										<option value="1975">1975</option>
										<option value="1976">1976</option>
										<option value="1977">1977</option>
										<option value="1978">1978</option>
										<option value="1979">1979</option>
										<option value="1980">1980</option>
										<option value="1981">1981</option>
										<option value="1982">1982</option>
										<option value="1983">1983</option>
										<option value="1984">1984</option>
										<option value="1985">1985</option>
										<option value="1986">1986</option>
										<option value="1987">1987</option>
										<option value="1988">1988</option>
										<option value="1989">1989</option>
										<option value="1990">1990</option>
										<option value="1991">1991</option>
										<option value="1992">1992</option>
										<option value="1993">1993</option>
										<option value="1994">1994</option>
										<option value="1995">1995</option>
										<option value="1996">1996</option>
										<option value="1997">1997</option>
										<option value="1998">1998</option>
										<option value="1999">1999</option>
										<option value="2000">2000</option>
										<option value="2001">2001</option>
										<option value="2002">2002</option>
										<option value="2003">2003</option>
										<option value="2004">2004</option>
										<option value="2005">2005</option>
										<option value="2006">2006</option>
									</select>
								</div>
								<div class="form-group">
									<select name="mm" class="form-control">
										<option value="">월</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select>
								</div>
								<div class="form-group">
									<select name="dd" class="form-control">
										<option value="">일</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
									</select>
								</div>

							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">성별 <span
							class="text-danger">*</span></label>
						<div class="col-md-8 col-sm-9">
							<label> <input name="gender" type="radio" value="Male"
								checked> 남자
							</label> <label> <input name="gender" type="radio" value="Female">
								여자
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">연락처<span
							class="text-danger">*</span></label>
						<div class="col-md-5 col-sm-8">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-phone"></i></span> <input type="text"
									class="form-control" name="contactnum" id="contactnum"
									placeholder="연락처를 입력하세요" value="">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">다른 연락처<br></label>
						<div class="col-md-5 col-sm-8">
							<input type="text" class="form-control" name="contactnum2"
								id="contactnum2" placeholder="연락 가능한 다른 연락처를 입력하세요" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">프로필 사진<br> <small>(선택)</small></label>
						<div class="col-md-5 col-sm-8">
							<div class="input-group">
								<span class="input-group-addon" id="file_upload"><i
									class="glyphicon glyphicon-upload"></i></span> <input type="file"
									name="file_nm" id="file_nm" class="form-control upload"
									placeholder="" aria-describedby="file_upload">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-10">
							<input name="Submit" type="submit" value="가입하기"
								class="btn btn-primary"> <input name="Submit"
								type="submit" value="취소" class="btn btn-primary">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>