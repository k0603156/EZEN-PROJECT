<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>상품 상세 정보</h2>
<form action="/product/modify" method="post" enctype="multipart/form-data">
<input type="hidden" name="imgfile" value="${pvo.imgfile }">
<input type="hidden" name="pageNum" value="${cri.pageNum }">
<input type="hidden" name="amount" value="${cri.amount }">
<input type="hidden" name="type" value="<c:out value='${cri.type }' />">
<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }' />">
  <table class="table table-bordered">    
      <tr>
        <th>등록번호</th>
        <td><input type="text" name="pno" value="${pvo.pno }" readonly class="form-control"></td>        
      </tr>
      <tr>
        <th>상품이름</th>
        <td><input type="text" name="title" value="${pvo.title }" class="form-control"></td>        
      </tr>
      <tr>
        <th>등록자</th>
        <td>${pvo.writer }</td>        
      </tr>     
      <tr>
        <th>최종수정일</th>
        <td>${pvo.modd8 }</td>        
      </tr>
      <tr>
        <th>상세설명</th>
        <td><textarea rows="5" name="content" class="form-control">${pvo.content }</textarea></td>        
      </tr>
      <tr>
        <th>상품 이미지</th>
        <td id="imgzone">
        <c:choose>
			<c:when test="${!pvo.imgfile.equals('NONE') }">
				<img src="/images/${pvo.imgfile }" width="33%">
			</c:when>
			<c:otherwise>
				${pvo.imgfile }
			</c:otherwise>
		</c:choose>
        </td>        
      </tr>
       <tr>
        <th>상품 이미지 수정</th>
        <td><input type="file" name="new_imgfile" value="${pvo.imgfile }" class="form-control"></td>        
      </tr>
      <tr>
      	<td colspan="2">
      		<button type="submit" class="btn btn-primary">수정완료</button>
      	</td>
      </tr>
  </table>
</form>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		$(document).on("click","img",function(){
			let inpno = '<c:out value="${pvo.pno}" />';
			let inimgfile = '<c:out value="${pvo.imgfile}" />';
			if (confirm("삭제하시겠습니까?")) {
				$.ajax({
					url: "/product/rmimg",
					type: "POST",
					data: {pno: inpno, imgfile: inimgfile}
				}).done(function(result) {
					alert("이미지 삭제를 성공하였습니다.");
					location.replace("/product/detail?pno="+inpno);
					/* $("img").remove();
					$("#imgzone").append().text("NONE"); */
				}).fail(function() {
					alert("이미지 삭제를 실패하였습니다");
				}).always(function() {					
					//location.replace("/product/detail?pno="+inpno);
				});
			  } else {
				
			  }
		});
	});
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>