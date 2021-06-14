package kh.com.petbreedding;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class shopController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public String shopList(Locale locale, Model model) {
		return "/shop/shopList";
	}
	
	@RequestMapping(value = "/shopPage", method = RequestMethod.GET)
	public String shopPage(Locale locale, Model model) {
		return "/shop/shopInfoRead";
	}
	
	@RequestMapping(value = "/shopReservation", method = RequestMethod.GET)
	public String shopReservation(Locale locale, Model model) {
		return "/shop/salonReservation";
	}
	
	@RequestMapping(value = "/shopPayment", method = RequestMethod.GET)
	public String shopPayment(Locale locale, Model model) {
		return "/shop/shopPayment";
	}
	
	@RequestMapping(value = "/successPay", method = RequestMethod.GET)
	public String successPay(Locale locale, Model model) {
		return "/shop/successPay";
	}
	
//	사업자 예약관리
	@RequestMapping(value = "/bReservation", method = RequestMethod.GET)
	public String bReservation(Locale locale, Model model) {
		return "/shop/bReservation";
	}
//	사업자 예약확인
	@RequestMapping(value = "/bReservationDetail", method = RequestMethod.GET)
	public String bReservationDetail(Locale locale, Model model) {
		return "/shop/bReservationDetail";
	}
	
//사업자 화상채팅하기
	@RequestMapping(value = "/bFaceChat", method = RequestMethod.GET)
	public String bFaceChat(Locale locale, Model model) {
		return "/shop/bFaceChat";
	}
}
