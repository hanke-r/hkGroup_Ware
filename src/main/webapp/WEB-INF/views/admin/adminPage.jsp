<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Assembly 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140330

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HANKER</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
<link href="../assets/css/default/app.min.css" rel="stylesheet" />
<link href="../assets/css/assembly/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../assets/css/assembly/fonts.css" rel="stylesheet" type="text/css" media="all" />

<style>
	#loginOut{
    top: 40px;
    right: 40px;
    position: absolute;
    background: transparent;
    outline:none;
    border:none;
  	color:white;
	},
	#memTitle {
	   text-decoration: underline;
	}
</style>

</head>
<body>
<div id="header-wrapper">
	<sec:authorize access="isAnonymous()"> 
		<p><a href="<c:url value="/login/loginForm" />" id="loginOut" >로그인</a></p>>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath }/logout" method="POST">
			<input type = "submit" id="loginOut" value="로그아웃" />
		</form:form>
	</sec:authorize>
	
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">Master_k</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/" accesskey="1" title="">Homepage</a></li>
				<li class="active"><a href="#" accesskey="2" title="">회원관리</a></li>
				<li><a href="#" accesskey="3" title=""></a></li>
				<li><a href="#" accesskey="4" title=""></a></li>
				<li><a href="#" accesskey="5" title=""></a></li>
			</ul>
		</div>
	</div>
</div>
<div id="wrapper">
	<div id="three-column" class="container">
		<div class="title" id="memTitle">
			<h2>회원정보 확인</h2>
			<span class="byline">회원정보를 확인할 수 있습니다.</span>
		</div>
		<table id="memberTable" class="table table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>ID</th>
					<th>이름</th>
					<th>등급</th>
					<th>상태</th>
					<th>가입일</th>
					<th>기타</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="memberVO" varStatus="status">
					<tr id="memStatus">
						<td>${status.count }</td>
						<td>${memberVO.username }</td>
						<td>${memberVO.uname }</td>
						<td>${memberVO.authority }</td>
						<td>
							<c:choose>
								<c:when test="${memberVO.enabled == 1}">
									승인
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${memberVO.enabled == 0}">
									<span style="color:red;">가입대기</span>
								</c:when>
							</c:choose>
						</td>
						<td>
							<fmt:formatDate value="${memberVO.regdate }" pattern="yyyy년 MM월 dd일 EE요일" />
						</td>
						<td>
							<button type="button" id="memOptChange" onclick="MANAGE.memOptionChange('${memberVO.username}');" class="btn btn-sm btn-primary">승인</button>
							<button type="button" id="memExpire" onclick="MANAGE.memExpire('${memberVO.username}')" class="btn btn-sm btn-danger">강퇴</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div>

</div>

<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<script src="../assets/Login_v1/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="../assets/js/admin/memberManage.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	$(function(){
		$("#memberTable").DataTable({
			"language":{
				"emptyTable" : "가입한 회원이 없습니다.",
				"info" : "총 _TOTAL_명",
				"lengthMenu" : "_MENU_ 개씩 보기 ",
				"processing" : "로드 중...",
				"search" : "검색 : ",
				"paginate" : {
					"first" : "처음",
					"last" : "마지막",
					"next" : "다음",
					"previous" : "이전"
				},
				"aria": {
					"sortAscending" : ": 오름차순으로 정렬",
					"sordDescending" : ": 내림차순으로 정렬"
				}
			},
			"aoColumnDefs" : [
				{ 'bSortable': false, 'aTargets' : [ 1, 2, 3, 4, 5, 6 ] }
			]
		});
	});
</script>
</body>
</html>
