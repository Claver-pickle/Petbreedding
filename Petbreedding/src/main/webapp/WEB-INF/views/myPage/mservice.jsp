<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/mservice.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../myPage/mAside.jsp"/>
	 <div class="mContent">
	  <div class="mboardhead">
                <h1>공지사항 게시판</h1>
                <div class="select">
                    <select>
                        <option value="1">전체</option>
                        <option value="2">회원</option>
                        <option value="3">사업자</option>
                    </select>

                </div>
                <button class="basicBtn" id="writeBtn">글쓰기</button>

            </div>
            <div class="mboardrow">
                <table class="myboard">
                    <thead>
                    <tr>
                      <th scope="cols" width="200px">구분</th>
                      <th scope="cols"  width="1400px">제목</th>
                      <th scope="cols" width="200px">작성자</th>
                      <th scope="cols" width="200px">작성일</th>
                    
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>[회원]</td>
                      <td>결제문의 드립니다.</td>
                      <td>또비언니</td>
                      <td>2021-06-15</td>
                     
                    </tr>
                    <tr>
                        <td>[회원]</td>
                      <td>결제문의 드립니다.</td>
                      <td>또비언니</td>
                      <td>2021-06-15</td>
                      
                      </tr>
                      <tr>
                        <td>[회원]</td>
                      <td>결제문의 드립니다.</td>
                      <td>또비언니</td>
                      <td>2021-06-15</td>
                  
                      </tr>
                    </tbody>
                  </table>
            </div>
            <div class="page_wrap">
                <div class="page_nation">
                   <a class="arrow prev" href="#">이전</a>
                   <a href="#" class="active">1</a>
                   <a href="#">2</a>
                   <a href="#">3</a>
                   <a href="#">4</a>
                   <a href="#">5</a>
                   <a href="#">6</a>
                   <a href="#">7</a>
                   <a href="#">8</a>
                   <a href="#">9</a>
                   <a href="#">10</a>
                   <a class="arrow next" href="#">다음</a>
                </div>
             </div>
    
    </div>
	   </section>
	<jsp:include page="../footer.jsp" />
	</div>	 
<script type="text/javascript" src="${path}/resources/js/mypage/mAside.js"></script>
	</body>
	</html>