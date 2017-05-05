<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp"></jsp:include>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="padding:0px;margin:0px;" href="#"><img style="width: 90px;height: auto;" src="${contenxtPath}/resources/imgs/logo.png" ><img></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">비트 중고 경매란...</a></li>
					<li><a href="#" data-toggle="modal" data-target="#memberModal">회원정보</a></li>
					<li><a href="#">고객센터</a></li>
				</ul>
				
				<c:choose>
					<c:when test="${!isLogin}">
						<button class="btn navbar-btn" data-toggle="modal" data-target="#loginModal">로그인</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-danger navbar-btn" data-toggle="modal" data-target="#logoutModal">로그아웃</button>
					</c:otherwise>	
				</c:choose>
				
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
					<c:when test="${!isLogin}">
						<button class="btn btn-success navbar-btn" data-toggle="modal" data-target="#loginModal">경매참가</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-danger navbar-btn" data-toggle="modal" data-target="#logoutModal">경매등록</button>
					</c:otherwise>	
				</c:choose>
				</ul>
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	
	<div id="memberModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="container" >
				<jsp:include page="../member/memberinfo.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<!-- /.로그인 컨테이너 container -->
	<div id="logoutModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">로그아웃</h4>
				</div>
				<div class="modal-body">
					<p>감사합니다. 안전하게 로그아웃 되셨습니다.</p>
					<p>
						<small>- 비트 중고 경매 일동 -</small>
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- /.로그인 컨테이너 container -->
	<div id="loginModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="container" >
				<jsp:include page="../member/login.jsp"></jsp:include>
			</div>
		</div>
	</div>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<!-- 사이트 메뉴 -->
			<div class="col-md-3">
				<p class="lead">중고경매</p>
				<div class="list-group">
					<a href="#" class="list-group-item">가전제품</a> 
					<a href="#" class="list-group-item">의류</a> 
					<a href="#" class="list-group-item">티켓</a>
				</div>
			</div>

			<div class="col-md-9">
				<div class="row carousel-holder">
					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" style="width:800px;height:500px" src="${contenxtPath}/resources/imgs/main_p_1.png"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" style="width:800px;height:500px" src="${contenxtPath}/resources/imgs/main_p_2.png"
										alt="">
								</div>	
								<div class="item">
									<img class="slide-image" style="width:800px;height:500px" src="${contenxtPath}/resources/imgs/main_p_3.png"
										alt="">
								</div>					
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<jsp:include page="elecItem.jsp"></jsp:include>				
			</div>
		</div>

	</div>
	<!-- /.container -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
