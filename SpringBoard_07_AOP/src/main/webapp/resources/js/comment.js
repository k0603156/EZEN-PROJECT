thisLI = {};
thisBtn = {};
modVal = "";
function removeComment(thisCno){	
	$.ajax({		
		url: "/comment/"+thisCno,
		type: "delete"			
	}).done(function(result) {
		alert(result);
	}).fail(function() {
		alert("댓글 삭제 실패!");
	});
}
function changeComment(){
	$("#modInput").remove();
	thisLI.find(".cmtText").text(modVal);
	thisLI.find(".badge-light").after(thisBtn);	
}
function modifyComment(modVal,thisCno){
	let cno = thisCno;
	let cmtText = modVal;
	$.ajax({
		url: "/comment/"+cno,
		type: "put",
		data: JSON.stringify({cno:cno,content:cmtText}),
		contentType: "application/json; charset=utf-8"
	}).done(function(result) {
		alert(result);
		changeComment();
	}).fail(function() {
		alert("댓글 수정을 실패하였습니다.");
	});	
}
function printListPaging(cmtTotal,page){
	let cmtListPaging = $("#cmtListPaging");
	let pagingStr ='';
	let pageNum = page;
	
	let endPage = Math.ceil(pageNum/10.0)*10;
	let startPage = endPage-9;
	let prev = startPage != 1;
	let next = false;
	
	if(endPage*10 >= cmtTotal){
		endPage = Math.ceil(cmtTotal/10.0);
	}else{
		next = true;
	}
	
	if(prev){
		pagingStr += '<li class="page-item">';
		pagingStr += '<a class="page-link" href="'
			+(startPage-1)+'">Prev</a></li>';
	}
	for (var i = startPage ; i <= endPage; i++) {
		let clsActive = pageNum==i ? 'active' : '';
		pagingStr += '<li class="page-item '+clsActive+'">';
		pagingStr += '<a class="page-link" href="'+i+'">'+i+'</a></li>';		
	}	
	if(next){
		pagingStr += '<li class="page-item">';
		pagingStr += '<a class="page-link" href="'
			+(endPage+1)+'">Next</a></li>';
	}
	cmtListPaging.html(pagingStr).trigger("create");
	
}
function dpTime(modd8) {
	let today = new Date();
	let mdobj = new Date(modd8);
	
	let todayYear = today.getFullYear();
	let todayMonth = today.getMonth()+1;
	let todayDate = today.getDate();
	let year = mdobj.getFullYear();
	let month = mdobj.getMonth()+1;
	let day = mdobj.getDate();
	let hour = mdobj.getHours();
	let min = mdobj.getMinutes();
	let sec = mdobj.getSeconds();
	
	hour = (hour > 9 ? "" :"0")+hour;
	min = (min > 9 ? "" :"0")+min;
	sec = (sec > 9 ? "" :"0")+sec;
	month = (month > 9 ? "" :"0")+month;
	day = (day > 9 ? "" :"0")+day;
	
	let diff = todayYear == year && todayMonth == month && todayDate == day;
	let timeArrStr = [hour,":",min,":",sec].join("");
	let dateArrStr = [year,"/",month,"/",day].join("");
	
	return diff ? timeArrStr : dateArrStr+"-"+timeArrStr;
}
function printList(cmtList,cmtTotal,page) {
	if(page < 1){
		page = 1;
	}else if(cmtList == null || cmtList.length == 0){
		return;
	}
	let cmtListULTag = $("#cmtListULTag"); // html 객체(노드)를 가져옴
	let cmtStr = "";
	for (var i = 0; i < cmtList.length; i++) {
		cmtStr += "<li data-cno="+cmtList[i].cno+" class='list-group-item d-flex justify-content-between align-items-center'>";
		cmtStr += "<span class='badge badge-secondary'>"+cmtList[i].writer+"</span>";
		cmtStr += "<span class='cmtText'>"+cmtList[i].content+"</span>";
		cmtStr += "<span class='badge badge-light'>"+dpTime(cmtList[i].modd8)+"</span>"
		cmtStr += "<button type='button' class='btn btn-outline-warning btn-sm' id='modCmtBtn'>수정</button>";
		cmtStr += "<button type='button' class='btn btn-outline-danger btn-sm' id='delCmtBtn'>삭제</button>";
		cmtStr += "</li>";
	}
	cmtListULTag.html(cmtStr).trigger("create");	
	printListPaging(cmtTotal,page);
}
function listComment(pno, page) {
	let pageNo = page > 1 ? page : 1;
	$.getJSON("/comment/p/"+pno+"/"+pageNo+".json", function(cdto) {
		printList(cdto.list, cdto.commentcnt, pageNo);
	}).fail(function() {
		alert("댓글 리스트 출력 실패");
	});	
}
function addComment(params) { //이벤트 핸들링으로 전송된 객체는 객체이름.data.keyName으로 접근
	let pno = params.data.pno;
	let writer = params.data.writer;
	let content = $("#cmtText").val();
	if (content==null || content=='') {
		alert("댓글 내용을 입력해주세요~!");
		return false;
	}else{
		let cmtData = {pno:pno, writer:writer, content:content};
		$.ajax({
			type: "post",
			url: "/comment/new",
			data: JSON.stringify(cmtData),
			contentType: "application/json; charset=utf-8"
		}).done(function(result) {
			alert(result);
			listComment(pno,1);
		}).fail(function() {
			alert("댓글 등록 실패!");
		}).always(function() {
			$("#cmtText").val("");
		});
	}
}