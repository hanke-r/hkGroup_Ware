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

<title>HANKER | GroupWare</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
<link href="../assets/css/assembly/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../assets/css/assembly/fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="../assets/css/hkGroup/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
<link href="../assets/css/default/app.min.css" rel="stylesheet" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css" />

<!-- script -->
<script src="../assets/Login_v1/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="../assets/js/admin/memberManage.js"></script>
<script src="../assets/js/hkGroup/function.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="../assets/js/admin/memberManage.js"></script>
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
			<h1><a href="#">Master_k 관리자</a></h1>
		</div>
		<div id="menu">
			<ul style="margin-bottom:-5px;">
				<li class="liActive"><a href="/admin/home" accesskey="1" title="">Home</a></li>
				<li class="liDisabled"><a href="/admin/adminPage" title="">회원관리</a></li>
				<li class="liDisabled"><a href="#" accesskey="3" title=""></a></li>
				<li class="liDisabled"><a href="#" accesskey="4" title=""></a></li>
				<li class="liDisabled"><a href="#" accesskey="5" title=""></a></li>
			</ul>
		</div>
		<div id="userMenu">
			<button type="button" id="userBtn" onclick="location.href='/';">USER</button>
		</div>
	</div>
</div>

<script>
	
</script>