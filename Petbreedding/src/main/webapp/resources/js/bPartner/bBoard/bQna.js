/**
 * 
 */

$(function() {
	var userNum = "${user_num}";
	console.log(userNum);
	$(".pointline").click(function() {
		var idVar = $(this).attr("id");
		console.log(idVar);
		goDetail(idVar);
	});
	
	$("#myAskBtn").click(function() {
		location.href = "/petbreedding/bQna/write?user_num="+userNum+"";
	});
	
	function goDetail(value){
		console.log(value);
		location.href = "/petbreedding//mypage/askdetail?qna_num="+value+"";
	}
});