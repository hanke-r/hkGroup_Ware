<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>
<style>
	.notice-content {
		border: 1px solid gray;
    	border-radius: 5px;
	}
	form {
		margin : 0 auto;
		width: 90%;
		margin-top: 20px;
    	margin-bottom: 20px;
	}
</style>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 자유게시판
		</h2>
	</div>
	
	<div class="notice-content">
		<form name="form" id="form" role="form">
			<div class="mb-3">
				<label for="title">제목</label> <input type="text" class="form-control" name="title" id="title" value="<c:out value='${FRVIEW.frtitle }'/>" readonly>
			</div>
			<div class="mb-3">
				<div class="nb-writer">
					<label for="reg_id">작성자</label> <input type="text" class="form-control" name="writer" id="writer" value="<c:out value='${FRVIEW.frwriter }'/>" readonly>
				</div>
				
				<div class="nb-viewcnt">
					<label for="viewCnt">조회수</label> <input type="text" class="form-control" name="viewCnt" id="viewCnt" value="<c:out value='${FRVIEW.frviewcnt }'/>" readonly>
				</div>
			</div>
			<div class="mb-3">
				<div class="nb-regdate">
					<label for="regdate">작성일</label> <input type="text" class="form-control" name="regdate" id="regdate" value="<c:out value='${FRVIEW.regdate }'/>" readonly>
				</div>
			</div>
			<div class="mb-3" id="frbContent">
				<div id="frbViewContent">
					<label for="content">내용</label>
					<div class="nb-content">
						${FRVIEW.frcontent }
					</div>
				</div>
			</div>
			
			<c:set var="SC" value="${SC }" />
			<c:if test = "${SC eq 'SUCCESS' }">
				<button type="button" class="btn btn-sm btn-primary" id="update" onclick="FRBD.frbUpdView('${FRVIEW.frcontent }');">수정</button>
			</c:if>
			<button type="button" class="btn btn-sm btn-warning" id="list" onclick="location.href='/frBoard/frBoardMain';">목록</button>
			
			<button type="button" class="btn btn-sm btn-danger" id="updateChk" onclick="FRBD.frbUpdate('${FRVIEW.frno}');" style="display:none;">확인</button>
			<button type="button" class="btn btn-sm btn-warning" id="back" onclick="location.href='/frBoard/frBoardView?frno=${FRVIEW.frno}'" style="display:none;">back</button>
		</form>
	</div>
	
	<div class="notice-reple">
		<form>
			<div class="mb-3" id="reView">
				<b>  등록된 댓글이 없습니다.</b>
			</div>
			<div class="mb-3">
				<label for="title">댓글</label> <input type="text" class="form-control" name="title" id="re_title" placeholder="댓글을 입력해주세요.">
				<button type="button" id="noticeReple" onclick="FRBD.doCretRple('${FRVIEW.frno}');" class="btn btn-danger" style="margin-left: 92.7%; margin-top: 5px;">댓글작성</button>
			</div>
		</form>
	</div>
	
	
</div>


<script>
	$(function() {
		// 메뉴 선택 css
		$("#frBoard").addClass("liActive");
		
		
	});
	
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>