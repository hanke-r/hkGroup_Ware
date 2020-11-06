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
					<th style="width:5%;">No</th>
					<th style="width:10%;">작성자</th>
					<th style="width:58%;">제목</th>
					<th style="width:7%;">조회수</th>
					<th style="width:20%;">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="noticeBoardVO" varStatus="status">
					<tr id="memStatus">
						<td>${status.count }</td>
						<td>${noticeBoardVO.nbwriter }</td>
						<td>
							<span onclick="location.href='/hkGroup/boardView?nbno=${noticeBoardVO.nbno}';" style="cursor: pointer;">
								<b>${noticeBoardVO.nbtitle }</b>
							</span>
						</td>
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
			"info" : "_START_ - _END_ (총 _TOTAL_ 개)",
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