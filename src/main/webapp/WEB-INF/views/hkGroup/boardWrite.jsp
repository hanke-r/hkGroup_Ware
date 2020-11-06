<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 공지하기
		</h2>
	</div>
	
	<div class="notice-content">
		<form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
			<div class="mb-3">
				<label for="title">제목</label> <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
			</div>
			<div class="mb-3">
				<label for="reg_id">작성자</label> <input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">
			</div>
			<div class="mb-3">
				<label for="content">내용</label>
				<textarea class="form-control" rows="5" name="content" id="summernote" placeholder="내용을 입력해 주세요"></textarea>
			</div>
		</form>
		<button type="button" class="btn btn-sm btn-primary" id="noBtnSave">작성</button>
		<button type="button" class="btn btn-sm btn-warning" id="noBtnList">목록</button>
	</div>
</div>


<script>
	$('#summernote').summernote({
		height: 300,                 // 에디터 높이
		minHeight: null,             // 최소 높이
		maxHeight: null,             // 최대 높이
		focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		lang: "ko-KR",					// 한글 설정
		placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
	});
	
	$(function() {
		// 메뉴 선택 css
		$("#notice").addClass("liActive");
		
		
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>