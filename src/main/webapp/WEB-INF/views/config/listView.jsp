<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 형상관리		
		</h2>
	</div>
	<div class="notice-content">
		<h5>Commit List</h5>
		<button type="button" class="btn btn-warning" id="commitSch">커밋관리</button>
		<div class="confContainer">
				
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#config").addClass("liActive");
		
		$("#commitSch").click(function(){
		    $("#myModal").modal();
		});

		var auth = window.btoa("");
		$.ajax({
			type : "GET",
			headers : {
				Authorization : "Basic " + auth,
			},
			url : "https://api.github.com/repos/hanjaeok/hkGroup_Ware/commits",
			dataType : "json",
			success : function(response) {
				var array = response;
				var max = array.length;
				for (var i = 0; i < array.length; i++) {
					var cal = array[i].commit.author.date;
					var result = cal.split('T', 1);
					$(".confContainer").append(
											"<div class='commitCon'><b class='fntSize'> "
												+ max
												+ ". "
												+ array[i].commit.message
												+ "</b></div><div style='color: orange;margin-left: 87%;'>"
												+ array[i].commit.author.date
												+ "</div>");
					max = max - 1;
				}
			},
			error : function(e) {
				console.log("error");
			}
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>