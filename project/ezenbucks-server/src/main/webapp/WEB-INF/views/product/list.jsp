<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2 class="float-left">상품 목록<a href="/product/write" class="btn btn-outline-primary">상품등록</a></h2>
<div class="float-right form-group">
<form class="form-inline" action="/product/list">
<select class="form-control" name="type">
	<option value="TCW">검색범위</option>
	<option value="T">제목</option>
	<option value="W">작성자</option>
	<option value="C">내용</option>
	<option value="TW">제목or작성자</option>
	<option value="TC">제목or내용</option>
	<option value="CW">작성자or내용</option>
</select>
  <input type="text" class="form-control" placeholder="Search" name="keyword">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="amount" value="<c:out value='${pgvo.cri.amount }' />">
  <div class="input-group-append">
    <button class="btn btn-success" type="submit">검색</button>
  </div>
  </form>
</div>
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>등록번호</th>
			<th>상품명</th>
			<th>등록자</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0 }">
				<c:forEach items="${list }" var="pvo">
				<tr>
					<td>${pvo.pno }</td>
					<td><a href="/product/detail?pno=${pvo.pno }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount }&type=${pgvo.cri.type }&keyword=${pgvo.cri.keyword }">
					${pvo.title }
					<span class="badge badge-pill badge-info">${pvo.commentcnt }</span></a></td>
					<td>${pvo.writer }</td>
					<td>${pvo.readcount }</td>
					<td>${pvo.modd8 }</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="5"><h3>등록된 상품 없습니다!</h3></td></tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
 <ul class="pagination">
 <c:if test="${pgvo.prev }">
  <li class="page-item"><a class="page-link"
   href="/product/list?pageNum=${pgvo.startPage-1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type }&keyword=${pgvo.cri.keyword }">Prev</a></li>
  </c:if>
  <c:forEach var="i" begin="${pgvo.startPage }" end="${pgvo.endPage }">
  <li class="page-item ${pgvo.cri.pageNum == i ? 'active' : '' }"><a class="page-link"
   href="/product/list?pageNum=${i }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type }&keyword=${pgvo.cri.keyword }">${i }</a></li>
  </c:forEach>
 <c:if test="${pgvo.next }"> 
  <li class="page-item"><a class="page-link"
   href="/product/list?pageNum=${pgvo.endPage+1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type }&keyword=${pgvo.cri.keyword }">Next</a></li>
  </c:if>
</ul>
<script>
$(function(){
	let sform = $(".form-inline");
	$(".form-inline button").on("click",function(e){
		console.log("check1");
		e.preventDefault();
		console.log("check2 : "+ sform.find("input[name='keyword']").val());
		if(!sform.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요!");
			return false;
		}
		sform.submit();
	});
});
</script>
<script>
	let result = '<c:out value="${result}" />';
	if (result == 'write_ok') {
		alert("상품 등록이 완료되었습니다~!");
	}else if (result == 'remove_ok') {
		alert("상품 삭제 완료되었습니다~!");
	} 
	result = "";
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>
