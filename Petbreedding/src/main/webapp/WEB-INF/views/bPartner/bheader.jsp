<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="Bheader">
    <nav class="UserNav">
        <ul>
        	<c:if test = "${!empty bP }">
	            <li class="alertBell"><a href="#"><i class="fas fa-bell"></i><span class="alertCircle"></span></a></li>
	            <li id="userName"><a href="#">${bP.bp_name}님</a></li>
	            <li><a href="${pageContext.request.contextPath}/blogout">로그아웃</a></li>
            </c:if>
            <c:if test = "${empty bP }">
	            <li><a href="${pageContext.request.contextPath}/bLogin">로그인</a></li>
            </c:if>
        </ul>
    </nav>
    <!-- 사업자 ver 변경예쩡 -->
    <a href="/petbreedding/bIndex"><img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" ></a>          
</header>