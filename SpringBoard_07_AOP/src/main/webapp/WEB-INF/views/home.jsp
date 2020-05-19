<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="00_header.jsp"></jsp:include>
<jsp:include page="10_nav.jsp"></jsp:include>

<div class="jumbotron mt-5">
  <h1>Welcome to Spring World~!~!~!</h1>
  <p>Bootstrap is the most popular HTML, CSS...</p>
  <p>현재 시간은 ${serverTime } 입니다.</p>
</div>

<jsp:include page="90_footer.jsp"></jsp:include>
