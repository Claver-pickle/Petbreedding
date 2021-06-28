<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bQna.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function() {
	var userNum = "${user_num}";
	console.log(userNum);
	$(".pointline").click(function() {
		var idVar = $(this).attr("id");
		console.log(idVar);
		goDetail(idVar);
	});
	
	$("#myAskBtn").click(function() {
		location.href = "/petbreedding/bQna/write?user_num="+userNum+"";
	});
	
	function goDetail(value){
		console.log(value);
		location.href = "/petbreedding//mypage/askdetail?qna_num="+value+"";
	}
});
</script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
			<jsp:include page="../bheader.jsp" />
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<h1>1:1 문의 내역</h1>
					<button id="myAskBtn" class="basicBtn">1:1문의하기</button>
				<table class="asktable">
					<br>
					<br>
					<br>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부</th>
					</tr>
					<c:forEach items="${bQnaList}" var="list">
					<tr id="${list.qnaNum}" class="pointline">
						<td>${list.qnaNum}</td>
						<td><a>${list.qnaTitle}</a></td>
						<td>${list.qnaDate}</td>
						<c:choose>
							<c:when test="${list.qnaChk eq 0}">
								<td>N</td>
							</c:when>
							<c:otherwise>
								<td>Y</td>
							</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>

				</table>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
</body>
</html>