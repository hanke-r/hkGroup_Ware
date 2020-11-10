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
		<button type="button" class="btn btn-warning" id="commitSch" data-toggle="modal" data-target="#myModal">커밋관리</button>
		<div class="confContainer">
				
		</div>
	</div>
</div>
<!-- Modal window -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="z-index:1100;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">Modal body</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#config").addClass("liActive");
		
		$("#commitSch").click(function(){
		    
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