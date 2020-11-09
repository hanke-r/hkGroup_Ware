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
		<div class="confContainer">
				
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		var auth = window.btoa("");
		$.ajax({
			type: "GET",
			headers: {
				Authorization : "Basic " + auth,
			},
			url: "https://api.github.com/repos/hanjaeok/hkGroup_Ware/commits",
			dataType: "json",
			success:function(response){
				console.log(response);
				var array = response;
				for(var i = 0 ; i < array.length ; i++){
					$(".confContainer").append("<p>" + array[i].commit.message + "</p>");
				}
			},
			error:function (e){
				console.log("error");
			}
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>