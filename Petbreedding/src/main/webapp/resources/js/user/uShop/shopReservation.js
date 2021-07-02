$("#checkService .menu_box").on("click", function() {
	$("#secondChoose").fadeIn();
});
$("#secondChoose .dog_box").on("click", function() {
	$("#thirdChoose").fadeIn();
});
$("#thirdChoose .plus").on("click", function() {
	$("#fourthChoose").fadeIn();
});
$("#fourthChoose .time").on("click", function() {
	$("#fifthChoose").fadeIn();
	$("#btnBox").fadeIn();
});

// 메뉴 클릭
$(".menu_box").on("click", function() {
	if ($(this).hasClass("chooseMenu") == false) {
		$(".menu_box").removeClass("chooseMenu");
		$(".menu_box").addClass("normalMenu");
		$(this).addClass('chooseMenu');
		$(this).removeClass('normalMenu');
	} else {
		$(this).removeClass('chooseMenu');
		$(this).addClass('normalMenu');
	}
});

// 반려견 선택
$(".dog_box").on("click", function() {
	if ($(this).hasClass("chooseDog") == false) {
		$(".dog_box").removeClass("chooseDog");
		$(".dog_box").addClass("normalDog");
		$(this).addClass('chooseDog');
		$(this).removeClass('normalDog');
	} else {
		$(this).removeClass('chooseDog');
		$(this).addClass('normalDog');
	}
});
$("#addDogBox").on("click", function() {
	var cl_num = $("#clNum").val();
	location.href = "/petbreedding/Mypage/openMyPet?cl_num="+cl_num+"";
});

// 기타 추가요금
$(".plus").on("click", function() {
	if ($(this).hasClass("choosePlus") == false) {
		$(".plus").removeClass("choosePlus");
		$(".plus").addClass("normalPlus");
		$(this).addClass('choosePlus');
		$(this).removeClass('normalPlus');
	} else {
		$(this).removeClass('choosePlus');
		$(this).addClass('normalPlus');
	}
});

// 날짜에 따른 시간선택
$("#choDate").on("propertychange change keyup paste input oninput ",function() {
	var res_date = $("#choDate").val();
	var har_num = $("#harNum").val();
	$.ajax({
		url : "checkTime",
		type : "POST",
		data : {
			res_date : res_date,
			har_num : har_num
		},
		success : function(data) {
			console.log(data);
			if (data == "" || data == null || data == undefined) {
				$("#1000")
						.html(
								"<input type='text' value='10:00' readonly>");
				$("#1000").removeClass("cannotCheck");
				$("#1000").addClass("time");
				$("#1030")
						.html(
								"<input type='text' value='10:30' readonly>");
				$("#1030").removeClass("cannotCheck");
				$("#1030").addClass("time");

				$("#1100")
						.html(
								"<input type='text' value='11:00' readonly>");
				$("#1100").removeClass("cannotCheck");
				$("#1100").addClass("time");
				$("#1130")
						.html(
								"<input type='text' value='11:30' readonly>");
				$("#1130").removeClass("cannotCheck");
				$("#1130").addClass("time");

				$("#1200")
						.html(
								"<input type='text' value='12:00' readonly>");
				$("#1200").removeClass("cannotCheck");
				$("#1200").addClass("time");
				$("#1230")
						.html(
								"<input type='text' value='12:30' readonly>");
				$("#1230").removeClass("cannotCheck");
				$("#1230").addClass("time");

				$("#1300")
						.html(
								"<input type='text' value='13:00' readonly>");
				$("#1300").removeClass("cannotCheck");
				$("#1300").addClass("time");
				$("#1330")
						.html(
								"<input type='text' value='13:30' readonly>");
				$("#1330").removeClass("cannotCheck");
				$("#1330").addClass("time");

				$("#1400")
						.html(
								"<input type='text' value='14:00' readonly>");
				$("#1400").removeClass("cannotCheck");
				$("#1400").addClass("time");
				$("#1430")
						.html(
								"<input type='text' value='14:30' readonly>");
				$("#1430").removeClass("cannotCheck");
				$("#1430").addClass("time");

				$("#1500")
						.html(
								"<input type='text' value='15:00' readonly>");
				$("#1500").removeClass("cannotCheck");
				$("#1500").addClass("time");
				$("#1530")
						.html(
								"<input type='text' value='15:30' readonly>");
				$("#1530").removeClass("cannotCheck");
				$("#1530").addClass("time");

				$("#1600")
						.html(
								"<input type='text' value='16:00' readonly>");
				$("#1600").removeClass("cannotCheck");
				$("#1600").addClass("time");
				$("#1630")
						.html(
								"<input type='text' value='16:30' readonly>");
				$("#1630").removeClass("cannotCheck");
				$("#1630").addClass("time");

				$("#1700")
						.html(
								"<input type='text' value='17:00' readonly>");
				$("#1700").removeClass("cannotCheck");
				$("#1700").addClass("time");
				$("#1730")
						.html(
								"<input type='text' value='17:30' readonly>");
				$("#1730").removeClass("cannotCheck");
				$("#1730").addClass("time");
			} else {
				for ( var i in data) {
					if (data[i] == "10:00") {
						$("#1000")
								.html(
										"<input type='text' value='10:00' readonly disabled>");
						$("#1000").addClass(
								"cannotCheck");
						$("#1000").removeClass("time");
					} else if (data[i] == "10:30") {
						console.log("true");
						$("#1030")
								.html(
										"<input type='text' value='10:30' readonly disabled>");
						$("#1030").addClass(
								"cannotCheck");
						$("#1030").removeClass("time");
					} else if (data[i] == "11:00") {
						$("#1100")
								.html(
										"<input type='text' value='11:00' readonly disabled>");
						$("#1100").addClass(
								"cannotCheck");
						$("#1100").removeClass("time");
					} else if (data[i] == "11:30") {
						$("#1130")
								.html(
										"<input type='text' value='11:30' readonly disabled>");
						$("#1130").addClass(
								"cannotCheck");
						$("#1130").removeClass("time");
					} else if (data[i] == "12:00") {
						$("#1200")
								.html(
										"<input type='text' value='12:00' readonly disabled>");
						$("#1200").addClass(
								"cannotCheck");
						$("#1200").removeClass("time");
					} else if (data[i] == "12:30") {
						$("#1230")
								.html(
										"<input type='text' value='12:30' readonly disabled>");
						$("#1230").addClass(
								"cannotCheck");
						$("#1230").removeClass("time");
					} else if (data[i] == "13:00") {
						$("#1300")
								.html(
										"<input type='text' value='13:00' readonly disabled>");
						$("#1300").addClass(
								"cannotCheck");
						$("#1300").removeClass("time");
					} else if (data[i] == "13:30") {
						$("#1330")
								.html(
										"<input type='text' value='13:30' readonly disabled>");
						$("#1330").addClass(
								"cannotCheck");
						$("#1330").removeClass("time");
					} else if (data[i] == "14:00") {
						$("#1400")
								.html(
										"<input type='text' value='14:00' readonly disabled>");
						$("#1400").addClass(
								"cannotCheck");
						$("#1400").removeClass("time");
					} else if (data[i] == "14:30") {
						$("#1430")
								.html(
										"<input type='text' value='14:30' readonly disabled>");
						$("#1430").addClass(
								"cannotCheck");
						$("#1430").removeClass("time");
					} else if (data[i] == "15:00") {
						$("#1500")
								.html(
										"<input type='text' value='15:00' readonly disabled>");
						$("#1500").addClass(
								"cannotCheck");
						$("#1500").removeClass("time");
					} else if (data[i] == "15:30") {
						$("#1530")
								.html(
										"<input type='text' value='15:30' readonly disabled>");
						$("#1530").addClass(
								"cannotCheck");
						$("#1530").removeClass("time");
					} else if (data[i] == "16:00") {
						$("#1600")
								.html(
										"<input type='text' value='16:00' readonly disabled>");
						$("#1600").addClass(
								"cannotCheck");
						$("#1600").removeClass("time");
					} else if (data[i] == "16:30") {
						$("#1630")
								.html(
										"<input type='text' value='16:30' readonly disabled>");
						$("#1630").addClass(
								"cannotCheck");
						$("#1630").removeClass("time");
					} else if (data[i] == "17:00") {
						$("#1700")
								.html(
										"<input type='text' value='17:00' readonly disabled>");
						$("#1700").addClass(
								"cannotCheck");
						$("#1700").removeClass("time");
					} else if (data[i] == "17:30") {
						$("#1730")
								.html(
										"<input type='text' value='17:30' readonly disabled>");
						$("#1730").addClass(
								"cannotCheck");
						$("#1730").removeClass("time");
					}
				}
			}

		},
		complete : function(data) {

		},
		error : function() {
			console.log("error");
		}
	});
});

// 시간 클릭
$(".time").on("click",function() {
	if ($(this).hasClass("chooseTime") == false
			&& $(this).hasClass("cannotCheck") == false) {
		$(".time").removeClass("chooseTime");
		$(".time").addClass("normalTime");
		$(this).addClass('chooseTime');
		$(this).removeClass('normalTime');
		$(".chooseTime input").css("color", "var(--font-color)");
		$(".normalTime input").css("color", "var(--main-color)");
	} else {
		$(this).removeClass('chooseTime');
		$(this).addClass('normalTime');
		$(".chooseTime input").css("color", "var(--font-color)");
		$(".normalTime input").css("color", "var(--main-color)");
	}
});

var style_num2;
$("#noPlus").on("click", function() {
	style_num2 = $("#noPlus").find(".styleNum").val();
});

var tex = "";
// 예약하기
$("#reservation_btn").on("click", function() {
	var style_num = $(".chooseMenu").find(".styleNum").val();
	var pet_num = $(".chooseDog").find(".petNum").val();
	style_num2 = $(".choosePlus").find(".styleNum").val();
	var res_date = $("#choDate").val(); // 연월일
	var res_time = $(".chooseTime input").val(); // 시간
	var cl_num = $("#clNum").val();
	var har_num = $(".harNum").val();

	if(res_time == null || res_time == ""){
		alert("시간을 선택해주세요!");
		return false;
	}else if(style_num == null || style_num == ""){
		alert("스타일을 선택해주세요!");
		return false;
	}else if(pet_num == null || pet_num == ""){
		alert("서비스를 이용할 반려견을 선택해주세요!");
		return false;
	}else if(style_num2 == null || style_num2 == ""){
		alert("추가 이용을 하지 않으시려면 선택안함을 체크해주세요!");
		return false;
	}else{
		$.ajax({
			url : "doReservation",
			type : "POST",
			data : {
				cl_num : cl_num,
				pet_num : pet_num,
				style_num : style_num,
				har_num : har_num,
				res_date : res_date,
				res_time : res_time,
				style_num2 : style_num2
			},
			success : function(data) {
				console.log(data);
				text = "HAR000";
				text += data;
				$("#har_rnum").val(har_rnum);
				getModal();
			}
		});
	}
	
});

// 결제 안해요~~
$("#nextTime").on("click", function() {
	location.href = "/petbreedding/successRev";
});

// 바로결제!!
$("#goTOPay").on("click", function() {
	console.log("text : " + text);
	location.href = "/petbreedding/shopPayment?har_rnum=" + text + "";
});

// 모달

function modal(id) {
	var zIndex = 9999;
	var modal = document.getElementById(id);

	// 모달 div 뒤에 희끄무레한 레이어
	var bg = document.createElement('div');
	bg.setStyle({
		position : 'fixed',
		zIndex : zIndex,
		left : '0px',
		top : '0px',
		width : '100%',
		height : '100%',
		overflow : 'auto',
		// 레이어 색갈은 여기서 바꾸면 됨
		backgroundColor : 'rgba(0,0,0,0.4)'
	});
	document.body.append(bg);

	// 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
	modal.querySelector('.modal_close_btn').addEventListener('click',
			function() {
				bg.remove();
				modal.style.display = 'none';
			});

	modal.setStyle({
		position : 'fixed',
		display : 'block',
		boxShadow : '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

		// 시꺼먼 레이어 보다 한칸 위에 보이기
		zIndex : zIndex + 1,

		// div center 정렬
		top : '50%',
		left : '50%',
		transform : 'translate(-50%, -50%)',
		msTransform : 'translate(-50%, -50%)',
		webkitTransform : 'translate(-50%, -50%)'
	});
}
// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function(styles) {
	for ( var k in styles)
		this.style[k] = styles[k];
	return this;
};
function getModal(){
	modal('my_modal');
}

	


/* 슬라이더 */

document.addEventListener("DOMContentLoaded", function() {

	var mySwiper = new Swiper('.swiper-container', {
		slidesPerView : 4,
		slidesPerGroup : 4,
		observer : true,
		observeParents : true,
		spaceBetween : 24,
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
		breakpoints : {
			1280 : {
				slidesPerView : 3,
				slidesPerGroup : 3,
			},
			720 : {
				slidesPerView : 1,
				slidesPerGroup : 1,
			}
		}
	});

});
