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
	#memTitle {
	   text-decoration: underline;
	}
</style>


<div id="wrapper">
	<div id="three-column" class="container">
		<div class="title" id="memTitle">
			<h2>회원정보 확인</h2>
			<span class="byline">회원정보를 확인할 수 있습니다.</span>
		</div>
		<table id="memberTable" class="table table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>ID</th>
					<th>이름</th>
					<th>등급</th>
					<th>상태</th>
					<th>가입일</th>
					<th>기타</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="memberVO" varStatus="status">
					<tr id="memStatus">
						<td>${status.count }</td>
						<td>${memberVO.username }</td>
						<td>${memberVO.uname }</td>
						<td>${memberVO.authority }</td>
						<td>
							<c:choose>
								<c:when test="${memberVO.enabled == 1}">
									승인
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${memberVO.enabled == 0}">
									<span style="color:red;">가입대기</span>
								</c:when>
							</c:choose>
						</td>
						<td>
							<fmt:formatDate value="${memberVO.regdate }" pattern="yyyy년 MM월 dd일 EE요일" />
						</td>
						<td>
							<button type="button" id="memOptChange" onclick="MANAGE.memOptionChange('${memberVO.username}');" class="btn btn-sm btn-primary">승인</button>
							<button type="button" id="memExpire" onclick="MANAGE.memExpire('${memberVO.username}')" class="btn btn-sm btn-danger">강퇴</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


</body>
</html>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

