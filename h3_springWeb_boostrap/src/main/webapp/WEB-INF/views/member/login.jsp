<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang=kr>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="경매사이트">
<meta name="author" content="heartof">
<title>비트 경매</title>
<link href="${rootPath}/resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${rootPath}/resources/css/member.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
		<div class="span12">
			<form class="form-horizontal" action='' method="POST">
			  <fieldset>
			    <div id="legend">
			      <legend class="">로그인</legend>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="username">ID</label>
			      <div class="controls">
			        <input type="text" id="username" name="username" placeholder="email ID를 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">패스워드</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="패스워드를 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">로그인</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
		</div>
	</div>
</div>

</body>
</html>