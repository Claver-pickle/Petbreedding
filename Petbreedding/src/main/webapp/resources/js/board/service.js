$( document ).ready(function() {
$(".que").click(function() {
    $(this).next(".anw").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
 });


 $(".que2").click(function() {
    $(this).next(".anw2").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw2").siblings(".anw2").slideUp(300); // 1개씩 펼치기
 });
});