<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/board/freeboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
  <div class="wrapper">    
  <jsp:include page="../header.jsp" />
	<section class="section">
           
            <div class="bheader">
        <h1>자유게시판</h1>
            <div class="search-box">
            <input type="text" class="search-txt" name="#" placeholder="Type to search">
            <a class="search-btn" href="#">
              <i class="fas fa-search"></i>
            </a>
        </div><br><br>
        <!-- <form action="qnalist" method="get">
            
			<select id="searchType" name="searchType">
				<option value="1">전체</option>
				<option value="2">작성자</option>
				<option value="3">글내용</option>
			</select> <input type='search' id="search" name="search"
				placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp질문을 검색하세요.">
			<button type=submit id="btnsearch"> <i class="fas fa-search"></i></button>
           
		</form> -->
        </div>
             <div class="write">
                <button class="writebtn basicBtn"><a href="#">글쓰기</a></button>
              </div>  
              <div class="boardlist">
                <div class="subdiv">
                    <div class="img"><a href="#"><img src="http://placehold.it/150x100"  alt="boardimg"></a></div>
                    <div class="title"><a href="fboardcon"><p>강아지도 살찌면 뒷목살이 접히나요?(10)</p></a></div>
                    <div class="writer"><a href="fboardcon">또비언니</a></div>
                    <div class="regdate"><a href="fboardcon">2021-06-08</a></div>
                    <div class="count"><a href="fboardcon">0</a></div>
                    </div>
                    
                </div>
              

                <!--일단 디자인 구현만, 나중에 foreach 써서 기능 구현 -->
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
             

        </section>
        <jsp:include page="../footer.jsp" />
    </div>
</body>
</html>