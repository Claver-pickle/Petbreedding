package kh.com.petbreedding.Shop.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.MyPointService;
import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Controller
public class ShopPayController {

	@Autowired
	private ShopPayService shopPayService;
	
	@Autowired
	private MyPointService myPointService;
	
	@RequestMapping("harPay")
	@ResponseBody
	public int harPay(HarPay harPay) {

		int result = shopPayService.harPay(harPay);
		
		return result;
	}
	//결제시 포인트 사용
	@RequestMapping("myPoint")
	@ResponseBody
	public int myPointUpdate(MyPoint myPoint) {
		int result = myPointService.myPointUpdate(myPoint);
		
		return result;
	}
	//결제취소시 포인트 롤백
	@RequestMapping("myPointCancle")
	@ResponseBody
	public int myPointCancle(MyPoint myPoint) {
		int result = myPointService.myPointCancle(myPoint);
		return result;
	}
	
	@RequestMapping("harRevUp")
	@ResponseBody
	public int harRevUp(String har_rnum) {
		int result = shopPayService.harRevUp(har_rnum);
		return result;
	}
	
	@RequestMapping("hosPay")
	@ResponseBody
	public int hosPay(HosPay hosPay) {
		
		int result = shopPayService.hosPay(hosPay);
		return result;
	}
	
	@RequestMapping("hosRevUp")
	@ResponseBody
	public int hosRevUp(String hos_rnum) {
		int result = shopPayService.hosRevUp(hos_rnum);
		return result;
	}
}
