<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
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
	
	h2 {
	   text-decoration: underline;
	}
</style>

<div id="wrapper">
	<div id="three-column" class="container">
		<div class="title">
			<h3>최근수정내용</h3>
			<span class="byline">회원정보를 확인할 수 있습니다.</span>
		</div>
		<div class="boxA">
			<p>Phasellus pellentesque, ante nec iaculis dapibus, eros justo auctor lectus, a lobortis lorem mauris quis nunc. Praesent pellentesque facilisis elit. Class aptent taciti sociosqu ad  torquent per conubia nostra.</p>
			<a href="#" class="button button-alt">최근 가입신청자</a>
		</div>
		<div class="boxB">
			<p>Etiam neque. Vivamus consequat lorem at nisl. Nullam  wisi a sem semper eleifend. Donec mattis. Phasellus pellentesque, ante nec iaculis dapibus, eros justo auctor lectus, a lobortis lorem mauris quis nunc.</p>
			<a href="#" class="button button-alt">최근 등급변경 내용</a>
		</div>
		<div class="boxC">
			<p> Aenean lectus lorem, imperdiet at, ultrices eget, ornare et, wisi. Pellentesque adipiscing purus. Phasellus pellentesque, ante nec iaculis dapibus, eros justo auctor lectus, a lobortis lorem mauris quis nunc.</p>
			<a href="#" class="button button-alt">최근 탈퇴 인원</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
