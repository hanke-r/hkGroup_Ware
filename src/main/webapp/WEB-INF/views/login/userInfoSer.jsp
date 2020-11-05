<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Login V1</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<!-- <link rel="icon" href="../assets/Login_v1/images/icons/favicon.ico"/> -->
<!--===============================================================================================-->
	<link rel="stylesheet" href="../assets/Login_v1/vendor/bootstrap/css/bootstrap.min.css">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="../assets/Login_v1/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="../assets/Login_v1/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" href="../assets/Login_v1/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="../assets/Login_v1/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="../assets/Login_v1/css/util.css">
	<link rel="stylesheet" href="../assets/Login_v1/css/main.css">
<!--===============================================================================================-->
</head>
<body>

<div class="limiter">
	<div class="container-login100">
		<div class="container">
			<div class="row">
				<section>
		        <div class="wizard">
		            <div class="wizard-inner">
		                <div class="connecting-line"></div>
		                <ul class="nav nav-tabs" role="tablist">
		
		                    <li role="presentation" class="active">
		                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1">
		                            <span class="round-tab">
		                                <i class="glyphicon glyphicon-folder-open"></i>
		                            </span>
		                        </a>
		                    </li>
		
		                    <li role="presentation" class="disabled">
		                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2">
		                            <span class="round-tab">
		                                <i class="glyphicon glyphicon-pencil"></i>
		                            </span>
		                        </a>
		                    </li>
		                    <li role="presentation" class="disabled">
		                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
		                            <span class="round-tab">
		                                <i class="glyphicon glyphicon-ok"></i>
		                            </span>
		                        </a>
		                    </li>
		                </ul>
		            </div>
		
		            <form role="form">
		                <div class="tab-content">
		                    <div class="tab-pane active" role="tabpanel" id="step1">
		                        <h3 style="text-align: center;">ID | PASSWORD 찾기</h3>
		                        <div style="text-align: center; margin-top:30px;">
		                        	<div>
			                        	<img src="../assets/Login_v1/images/icon-icons-ID.png" alt="IMG" onclick="USIC.idSearch();" 
			                        		style="float:left; margin-left:20%; cursor:pointer; border: 3px solid lightgrey; 
			                        		-webkit-border-radius: 40px;">
			                        </div>
			                        <div>
			                        	<img src="../assets/Login_v1/images/Selman-PW.png" alt="IMG" onclick="USIC.pwSearch();"
			                        		style="border: 3px solid lightgrey; cursor:pointer; -webkit-border-radius: 40px;">
			                        </div>
		                        </div>
		                        <div style="height: 50px;">
		                        	
		                        </div>
		                    </div>
		                    <div class="tab-pane" role="tabpanel" id="step2">
		                    	<div id="idSearch">
			                        <h3>ID찾기</h3>
			                        <p> < 가입 시 인증했던 Email주소를 입력해주세요 > </p>
			                        <div>
				                        <input type="text" id="email" placeholder="E-Mail">
				                        <button type="button" class="btn btn-gray certBtn" onclick="USIC.emailCert();">인증번호 전송</button>
									</div>
									<div id="idCertCheck">
				                        <input type="text" id="emailToken" placeholder="인증번호" style="width:228px">
				                        <button type="button" class="btn btn-gray certBtn" onclick="USIC.emailCertChck();">확인</button>
									</div>
			                        <ul class="list-inline pull-right" style="margin-top: 7%;">
			                            <li><button type="button" class="btn btn-default" onclick="location.href='/login/loginForm';">HOME</button></li>
			                        </ul>
		                        </div>
		                        <div id="pwSearch" style="display:none;">
			                        <h3>PW찾기</h3>
			                        <p> < 가입 시 인증했던 ID, Email주소를 입력해주세요 > </p>
			                        <div style="margin-left: -69px; margin-bottom: 5px; width: 1135px;">
				                        <input type="text" placeholder="ID" id="pwFindId">
			                        </div>
			                        <div>
				                        <input type="text" placeholder="Email" id="pwFindEmail">
				                        <button type="button" class="btn btn-gray certBtn" onclick="USIC.pwFind();">인증번호 전송</button>
			                        </div>
			                        <div id="pwCertCheck">
				                        <input type="text" id="emailPwToken" placeholder="인증번호" style="width:228px">
				                        <button type="button" class="btn btn-gray certBtn" onclick="USIC.pwEmailCertChck();">확인</button>
									</div>
			                        <ul class="list-inline pull-right" >
			                            <li><button type="button" class="btn btn-default" onclick="location.href='/login/loginForm';">HOME</button></li>
			                        </ul>
		                        </div>
		                    </div>
		                    <div class="tab-pane" role="tabpanel" id="complete">
		                    	<div id="compIdShow">

			                       
			                    </div>
		                    </div>
		                    <div class="clearfix"></div>
		                </div>
		            </form>
		        </div>
		    </section>
		   </div>
		</div>
	</div>
</div>

<div class="wrap-loading display-none">
	<div><img src="../assets/Login_v1/images/ajax-loader.gif"></div>
</div>


<!--===============================================================================================-->	
	<script src="../assets/Login_v1/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../assets/Login_v1/vendor/bootstrap/js/popper.js"></script>
	<script src="../assets/Login_v1/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../assets/Login_v1/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../assets/Login_v1/vendor/tilt/tilt.jquery.min.js"></script>
	<script src="../assets/Login_v1/js/main.js"></script>
	<script src="../assets/js/login/register.js"></script>
	<script src="../assets/js/login/userInfoSearch.js"></script>
<!--===============================================================================================-->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
		    //Initialize tooltips
		    $('.nav-tabs > li a[title]').tooltip();
		    
		    //Wizard
		    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
	
		        var $target = $(e.target);
		    
		        if ($target.parent().hasClass('disabled')) {
		            return false;
		        }
		    });
	
		    $(".next-step").click(function (e) {
		        var $active = $('.wizard .nav-tabs li.active');
		        nextTab($active);
	
		    });
		    $(".prev-step").click(function (e) {
		        var $active = $('.wizard .nav-tabs li.active');
		        prevTab($active);
		    });
		});
	
		function nextTab(elem) {
			$(elem).next().attr('class','active');
		    $(elem).next().find('a[data-toggle="tab"]').click();
		    $('li.active').prev().attr('class','disabled');
		}
		function prevTab(elem) {
			$(elem).prev().addClass('active');
			$(elem).prev().find('a[data-toggle="tab"]').click();
			$('.wizard .nav-tabs li.active').next().attr('class','disabled');
		}
	</script>
<!--===============================================================================================-->
	

</body>
</html>