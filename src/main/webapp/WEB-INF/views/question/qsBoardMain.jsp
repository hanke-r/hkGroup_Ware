<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 문의사항		
		</h2>
	</div>

</div>


<script>
	$(document).ready(function() {
		$("#question").addClass("liActive");
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>