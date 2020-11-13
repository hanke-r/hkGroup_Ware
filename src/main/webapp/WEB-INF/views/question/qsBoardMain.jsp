<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/user-header.jsp" %>
<style>
	#registerInquiryBtn{
		color: white;
    	background-color: #343a40;
    	float: right;
    	margin-top: -4%;
	}
</style>
<div id="wrapper">
	<div class="notice-title">
		<h2 class="pageTitle pos-rel">
			<i class="fas fa-comments"></i> 문의사항		
		</h2>
		<button id="registerInquiryBtn" type="button" class="btn" onclick="location.href='/question/inqWriteView';">
			<i class="fas fa-plus" style="color:#fff;"></i> 문의하기
		</button>
	</div>
	
	<div class="notice-content">
		<table id="inquiryTb" class="table table-bordered">
			<thead>
				<tr class="tr-title">
					<th style="width:5%;">No</th>
					<th style="width:10%;">작성자</th>
					<th style="width:45%;">제목</th>
					<th style="width:10%;">답변여부</th>
					<th style="width:15%;">작성일</th>
					<sec:authorize access="hasRole('ADMIN')">
						<th style="width:10%;">삭제</th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="inqVO" varStatus="status">
					<tr id="memStatus">
						<sec:authorize access="hasRole('USER')">
							<c:set var="name" value="${id.uno }" />
							<c:set var="cpName" value="${inqVO.uno }" />
							<c:choose>
								<c:when test="${name eq  cpName}">
									<td>${status.count }</td>
									<td>${inqVO.inq_writer }</td>
									<td>
										<span onclick="location.href='/question/inqView?inq_no=${inqVO.inq_no }';" style="cursor:pointer;">
											<b>${inqVO.inq_title }</b>
										</span>
									</td>
									<c:choose>
										<c:when test="${inqVO.inq_answer == 0 }">
											<td style="color: blue; font-weight:bold">대기중</td>
										</c:when>
										<c:when test="${inqVO.inq_answer == 1 }">
											<td style="color: red; font-weight:bold">답변완료</td>
										</c:when>
									</c:choose>
									<td>
										<fmt:formatDate value="${inqVO.regdate }" pattern="yyyy년 MM월 dd일 EE요일" />
									</td>
								</c:when>
								<c:otherwise>
									<td colspan="6" style="background-color: #e6e6e6; text-align: center;"><i class="fas fa-lock"></i></td>
								</c:otherwise>
							</c:choose>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('MANAGE','ADMIN')">
							<td>${status.count }</td>
							<td>${inqVO.inq_writer }</td>
							<td>
								<span onclick="location.href='/question/inqView?inq_no=${inqVO.inq_no }';" style="cursor:pointer;">
									<b>${inqVO.inq_title }</b>
								</span>
							</td>
							<c:choose>
								<c:when test="${inqVO.inq_answer == 0 }">
									<td style="color: blue; font-weight:bold">대기중</td>
								</c:when>
								<c:when test="${inqVO.inq_answer == 1 }">
									<td style="color: red; font-weight:bold">답변완료</td>
								</c:when>
							</c:choose>
							<td>
								<fmt:formatDate value="${inqVO.regdate }" pattern="yyyy년 MM월 dd일 EE요일" />
							</td>
							<td>
								<button type="button" class="btn btn-sm btn-danger">삭제</button>
							</td>
						</sec:authorize>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	

</div>


<script>
	$(document).ready(function() {
		$("#question").addClass("liActive");
	});
	
	$(function() {
		// 메뉴 선택 css
		var lang_kor = {
			"paginate" : {
				"first" : "첫 페이지",
				"last" : "마지막 페이지",
				"next" : ">",
				"previous" : "<"
			},
			"info" : "_START_ - _END_ (총 _TOTAL_ 개)",
			"infoEmpty" : "0개",
			"emptyTable" : "작성된 글이 없습니다.",
			"search" : "검색",
			"zeroRecords" : "검색결과가 없습니다.",
		}
		
		$("#inquiryTb").DataTable({
			"ordering" : false,
			"searching" : true,
			"lengthChange" : false,
			language : lang_kor
		});
	});
</script>
<%@ include file="/WEB-INF/views/layout/user-footer.jsp" %>