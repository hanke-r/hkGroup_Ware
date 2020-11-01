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
			<table id="newMemList" class="table table-striped">
				<thead>
					<tr class="bg-dark text-white">
						<th >no</th>
						<th>ID</th>
						<th>이름</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${newMemList }" var="memberVO" varStatus="status">
					<tr id="memStatus">
						<td>${status.count }</td>
						<td>${memberVO.username }</td>
						<td>${memberVO.uname }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<a href="/admin/adminPage" class="button button-alt">가입대기중</a>
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
<style type="text/css">
	.dataTables_scrollBody::-webkit-scrollbar-track {
	     -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	    background-color: #F5F5F5;
	    border-radius: 10px;
    }
    .dataTables_scrollBody::-webkit-scrollbar {
        width: 6px;
   		background-color: #F5F5F5;
    }
    .dataTables_scrollBody::-webkit-scrollbar-thumb {
	    background-color: #777;
    	border-radius: 10px;
    }
    .dataTables_wrapper.no-footer .dataTables_scrollBody{
   		border-bottom: 1px solid #f7f7f7;
    }
</style>
<script>
	$(function(){
		$("#newMemList").DataTable({
			"ordering": false,
			"pageLength": 5,
			"lengthChange": false,
			"searching": false,
			"scrollY": true,
			"scrollY": "200px",
			"paging": false,
			"info": false
			
			
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
