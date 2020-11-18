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
			<i class="fas fa-bullhorn"></i> 문의사항
		</h2>
	</div>
	
	<div class="notice-content">
		<form name="form" id="form" role="form">
			<div class="mb-3">
				<label for="title">제목</label> <input type="text" class="form-control" name="title" id="title" value="<c:out value='${INQ.inq_title}'/>" readonly>
			</div>
			<div class="mb-3">
				<div class="nb-writer">
					<label for="reg_id">작성자</label> <input type="text" class="form-control" name="writer" id="writer" value="<c:out value='${INQ.inq_writer}'/>" readonly>
				</div>
				
				<div class="nb-viewcnt">
					<label for="viewCnt">이메일</label> <input type="text" class="form-control" name="email" id="email" value="<c:out value='${INQ.inq_email }'/>" readonly>
				</div>
			</div>
			
			
			<div class="mb-3">
				<div class="nb-writer">
					<label for="regdate">작성일</label> <input type="text" class="form-control" name="regdate" id="regdate" value="<c:out value='${INQ.regdate }'/>" readonly>
				</div>
				
				<div class="nb-viewcnt">
					<label for="answerYn">답변여부</label> 
					<c:choose>
						<c:when test="${INQ.inq_answer == 0 }">
							<input type="text" class="form-control" name="answer" id="answer" value="대기중" style="text-align: center; color: blue; font-weight: bold; "readonly>
						</c:when>
						<c:when test="${INQ.inq_answer == 1 }">
							<input type="text" class="form-control" name="answer" id="answer" value="답변완료" style="text-align: center; color:red; font-weight:bold;"readonly>
						</c:when>
					</c:choose>
				</div>
			</div>
			<div class="mb-3" id="inqContent">
				<div id="inqViewContent">
					<label for="content">내용</label>
					<div class="nb-content">
						${INQ.inq_content }
					</div>
				</div>
			</div>
			

			<button type="button" class="btn btn-sm btn-warning" id="list" onclick="location.href='/question/qsBoardMain';">목록</button>
		</form>
	</div>
	
	<div class="notice-reple">
		<form>
			<c:choose>
				<c:when test="${INQ.inq_answer == 0 }">
					<div class="mb-3">
						<div id="answerTab">
							<label for="title">답변</label>
							<input type="text" class="form-control" id="qaAns" style="height:200px;">
						</div>
						
						
					</div>
					<div class="mb-3">
						<button type="button" class="btn btn-default" style="margin-left: 94.7%;" onclick="QUES.reAnsChck('${INQ.inq_no}');">답변</button>
					</div>
				</c:when>
				<c:when test="${INQ.inq_answer == 1 }">
					<div class="mb-3">
						<div id="answerTab">
							<label for="title">답변</label>
							<input type="text" class="form-control" id="qaAns" style="height:200px;" value="<c:out value='${INQ.inq_reply }' />" readonly /> 
						</div>
					</div>
				</c:when>
			</c:choose>
			
		</form>
	</div>
	
	
</div>


<script>
	$(function() {
		// 메뉴 선택 css
		$("#question").addClass("liActive");
		
		
	});
	
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>