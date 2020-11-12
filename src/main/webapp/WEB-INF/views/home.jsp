<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-home"></i> Main
		</h2>
	</div>
<style>
#visitCntTt, #visitCntMo, #visitCntTd {
	width: 15%;
	height: 33%;
	color: black;
	
}

#totalCntWr, #monthCntWr, #todayCntWr {
	width: 50%;
	float: left;
	text-align: center;
	background-color: black;
	color:orange;
	border: 1px solid orange;
}

#totalCnt, #monthCnt, #todayCnt {
	float: right;
	width: 50%;
	background-color: black;
	color:orange;
	text-align: center;
	border: 1px solid orange;
}
#ttVisit{
	height: 69px;
    width: 75%;
    top: 20%;
    left: 7%;
    position: relative;
}
</style>

<div id="ttVisit">
	<div id="visitCntTt">
		<div id="totalCntWr">총 방문자수</div>
		<div id="totalCnt">${RS.total }</div>
	</div>
	<div id="visitCntMo">
		<div id="monthCntWr">이번달 방문자수</div>
		<div id="monthCnt">${RS.month }</div>
	</div>
	<div id="visitCntTd">
		<div id="todayCntWr">오늘 방문자수</div>
		<div id="todayCnt">${RS.today }</div>
	</div>
</div>

</div>

<script>
	$(function(){
		$("#home").addClass("liActive");
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>