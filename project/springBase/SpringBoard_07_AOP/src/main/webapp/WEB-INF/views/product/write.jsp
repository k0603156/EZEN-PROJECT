<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>
<h2>상품 등록하기</h2>
<form method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="title">Title : </label>
    <input type="text" class="form-control" placeholder="상품명" id="title" name="title">
  </div>
  <div class="form-group">
    <label for="title">Writer : </label>
    <input type="text" class="form-control" placeholder="등록자" id="writer" name="writer">
  </div>
  <div class="form-group">
    <label for="title">File : </label>
    <input type="file" class="form-control" id="imgfile" name="imgfile">
  </div>
  <div class="form-group">
  <label for="content">Content : </label>
  <textarea class="form-control" rows="5" id="content" name="content"></textarea>
</div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="../90_footer.jsp"></jsp:include>
