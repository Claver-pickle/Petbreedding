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
<link href="${path}/resources/css/mypage/mfreeboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="${path}/resources/js/board/service.js"></script>    
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../myPage/mAside.jsp"/>
	 <div class="mContent">
	    <div class="mboardhead">
            <div class="myboardhead">
                <h1>자유게시판</h1>
                <table class="myboard">
                    <thead>
                    <tr>
                      <th scope="cols" width="200px"><input type="checkbox"  value='selectall'
                        onclick='selectAll(this)'>전체선택</th>
                      <th scope="cols"  width="1000px">제목</th>
                      <th scope="cols" width="1000px">내용</th>
                      <th scope="cols" width="200px">조회수</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td><input type="checkbox" name="board"></td>
                      <td>살찌면 뒷목살도 접히나요?</td>
                      <td>저희 강아지가 뒷목살이 접히는데..</td>
                      <td>3</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="board"></td>
                        <td>살찌면 뒷목살도 접히나요?</td>
                        <td>저희 강아지가 뒷목살이 접히는데..</td>
                        <td>3</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="myboardrow">
                    <button class="basicBtn" id="basicBtn"><a href="#">삭제</a></button>
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
	