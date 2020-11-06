<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>

<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-bullhorn"></i> 공지사항		
		</h2>
		<sec:authorize access="hasAnyRole('MANAGER','ADMIN')">
			<div id="notice-write">
				<button type="button" class="btn" id="noWrite" onclick="location.href='/hkGroup/boardWrite';">공지 작성</button>
			</div>
		</sec:authorize>
	</div>
	
	<div class="notice-content">
		<table id="noticeTb" class="table table-bordered">
			<thead>
				<tr class="tr-title">
					<th>No</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="noticeBoardVO" varStatus="status">
					<tr id="memStatus">
						<td>${status.count }</td>
						<td>${noticeBoardVO.nbwriter }</td>
						<td>${noticeBoardVO.nbtitle }</td>
						<td>${noticeBoardVO.nbcontent }</td>
						<td>${noticeBoardVO.nbviewcnt }</td>
						<td>
							<fmt:formatDate value="${noticeBoardVO.regdate }" pattern="yyyy년 MM월 dd일 EE요일" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<div class="modal fade" id="noModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">모달 타이틀</h4>
			</div>
			<div class="modal-body">내용</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">확인</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>



<script>
	$(function() {
		// 메뉴 선택 css
		$("#notice").addClass("liActive");

		var lang_kor = {
			"paginate" : {
				"first" : "첫 페이지",
				"last" : "마지막 페이지",
				"next" : "다음",
				"previous" : "이전"
			},
			"info" : "_START_ - _END_ (총 _TOTAL_ 명)",
			"infoEmpty" : "0개",
			"emptyTable" : "등록된 공지가 없습니다.",

		}
		$("#noticeTb").DataTable({
			"ordering" : false,
			"searching" : false,
			"lengthChange" : false,
			language : lang_kor
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>