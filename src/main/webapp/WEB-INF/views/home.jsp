<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-home"></i> Main
		</h2>
	</div>
	<div style="width: 60%; margin-left: 20%;">
		<canvas id="myChart" width="550" height="300" style="margin-left:3%; margin-top:3%;"></canvas>
		<div style="width: 20%; float: right; margin-top: -20%; margin-right: 15%;">
			<div id="totalCntWr">총 방문자 수</div>
			<div id="totalCnt">${RS.total }</div>
			
			<div id="todayCntWr" style="margin-top: 25%;">오늘 방문자 수</div>
			<div id="todayCnt">${RS.today }</div>
		</div>3
		
	</div>

	<div id="ttVisit">
			<div id="visitCntTt">
				
			</div>
			<div id="visitCntMo">
				
			</div>
			<div id="visitCntTd">
				
			</div>
		</div>

	

</div>

<script>
	$(function(){
		$("#home").addClass("liActive");
		
		var ctx = document.getElementById('myChart').getContext('2d');
		var chart = new Chart(ctx, {
		    // The type of chart we want to create
		    type: 'line',

		    // The data for our dataset
		    data: {
		        labels: ['${DAY.day6}', '${DAY.day5}', '${DAY.day4}', '${DAY.day3}', '${DAY.day2}', '${DAY.day1}', '${DAY.day0}'],
		        datasets: [{
		            label: '일일 방문자',
		            backgroundColor: 'rgb(255, 255, 255)',
		            borderColor: 'rgb(0, 0, 255)',
		            data: ['${CHART.dt6}', '${CHART.dt5}', '${CHART.dt4}', '${CHART.dt3}', '${CHART.dt2}', '${CHART.dt1}', '${CHART.dt0}']
		        }]
		    },

		    // Configuration options go here
		    options: {
		    	responsive: false,
		    	animation:{
		    		animateScale: true
		    	},
		    }
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>