<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 공지사항		
		</h2>
	</div>
	<div class="notice-content">
		<h5>Issue List</h5>
		<div class="container">
				
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		var auth = window.btoa("hanjaeok:c33a14c3714f4f16bb458b2b7f872e7690f14450");
		$.ajax({
			type: "GET",
			headers: {
				Authorization : "Basic " + auth,
			},
			url: "https://api.github.com/user/repos",
			dataType: "json",
			success:function(response){
				console.log(response);
				var array = response;
				for(var i = 0 ; i < array.length ; i++){
					$(".container").append("<p>" + array[i] + "</p>");
				}
			},
			error:function (e){
				console.log("error");
			}
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>