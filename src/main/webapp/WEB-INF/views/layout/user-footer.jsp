<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	#visitCntTt, #visitCntMo, #visitCntTd{
		width:15%;
		color:white;
	}
	#totalCntWr, #monthCntWr, #todayCntWr{
		width: 50%;
    	float: left;
    	text-align: center;
	}
	#totalCnt, #monthCnt, #todayCnt{
		float: right;
	    width: 50%;
	    text-align: center;
	}
</style>
 
<div id="ttVisit">
	<div id="visitCntTt">
		<div id="totalCntWr">
			총 방문자수
		</div>
		<div id="totalCnt">
			${RS.total }
		</div>
	</div>
	<div id="visitCntMo">
		<div id="monthCntWr">
			이번달 방문자수
		</div>
		<div id="monthCnt">
			${RS.month }
		</div>
	</div>
	<div id="visitCntTd">
		<div id="todayCntWr">
			오늘 방문자수
		</div>
		<div id="todayCnt">
			${RS.today }
		</div>
	</div>
</div>

<div id="footer-wrapper">
	<div id="copyright" class="container">
		<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
	</div>
</div>
</body>

</html>