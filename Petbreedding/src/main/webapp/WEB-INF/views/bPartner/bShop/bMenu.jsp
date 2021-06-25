<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bShop/bMenu.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/user/uBoard/service.js"></script>
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../bAside.jsp"/>
	 <div class="bContent">
	 	<div class="menuhead">
        	<h1>메뉴관리</h1>
        
		    <div class="menucon">
		    <button id="addItemBtn" class="basicBtn" onclick="tableCreate()">옵션추가</button>
		    <button id="delItemBtn" class="basicBtn" onclick="tableDelete()">옵션삭제</button>
		    
		    </div>
	       <table style="border: 1px;" id="dynamicTable">
	        <thead>
	        <tr>
	        <th width="400">타입</th>
	        <th width="400">메뉴명</th>
	        <th width="400">가격</th>
	        <th width="400">소요시간</th>
	        <th width="200"></th>
	        <th width="200"></th>
	        
	        
	        </tr>
	        </thead>
	        <tbody id="dynamicTbody">
	            
	        </tbody>
	        </table>
	        </div>
	        <div class="insert">
	        <!-- style_deep (0 : 메인메뉴  1: 서브메뉴) -->
	        <form action="${path}/bp/bMenu/write" method="POST">
	        <!-- 예약 페이지: 이용하실 서비스를 입력해주세요 -->
 			<label><input type="radio" name="style_deep" value="0" >메인메뉴</label>
 			<!-- 예약 페이지: 기타 추가요금 -->
  			<label><input type="radio" name="style_deep" value="1">서브메뉴</label>
	        <input  type="text" placeholder="메뉴" id="menu" name="style_name">
	        <input  type="text" placeholder="가격" id="price" name="price"> 
	        <input  type="text" placeholder="소요시간" id="time" name="style_time"> 
			<button type="submit" class="basicBtn" >완료</button>
	 		</form>
      		</div>
			 <!-- c:if -->
			 <!-- 수정버튼 -->
			 <!-- 삭제버튼 -->
	 </div>
	
	<!-- 삭제 모달 -->
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 