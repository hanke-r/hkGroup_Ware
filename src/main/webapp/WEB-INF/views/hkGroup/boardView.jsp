<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>
<style>
	.notice-content {
		border: 1px solid gray;
    	border-radius: 5px;
	}
	#form {
		margin : 0 auto;
		width: 90%;
		margin-top: 20px;
    	margin-bottom: 20px;
	}
</style>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 공지보기
		</h2>
	</div>
	
	<div class="notice-content">
		<form name="form" id="form" role="form">
			<div class="mb-3">
				<label for="title">제목</label> <input type="text" class="form-control" name="title" id="title" value="<c:out value='${NBVIEW.nbtitle }'/>" readonly>
			</div>
			<div class="mb-3">
				<div class="nb-writer">
					<label for="reg_id">작성자</label> <input type="text" class="form-control" name="writer" id="writer" value="<c:out value='${NBVIEW.nbwriter }'/>" readonly>
				</div>
				
				<div class="nb-viewcnt">
					<label for="viewCnt">조회수</label> <input type="text" class="form-control" name="viewCnt" id="viewCnt" value="<c:out value='${NBVIEW.nbviewcnt }'/>" readonly>
				</div>
			</div>
			<div class="mb-3">
				<div class="nb-regdate">
					<label for="regdate">작성일</label> <input type="text" class="form-control" name="regdate" id="regdate" value="<c:out value='${NBVIEW.regdate }'/>" readonly>
				</div>
			</div>
			<div class="mb-3">
				<label for="content">내용</label>
				<div class="nb-content">
					${NBVIEW.nbcontent }
				</div>
			</div>
			<button type="button" class="btn btn-sm btn-primary" onclick="FUCN.noticeWriter();">작성</button>
			<button type="button" class="btn btn-sm btn-warning" onclick="location.href='/hkGroup/board';">목록</button>
		</form>
	</div>
</div>


<script>
	
	$(function() {
		// 메뉴 선택 css
		$("#notice").addClass("liActive");
		
		
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>