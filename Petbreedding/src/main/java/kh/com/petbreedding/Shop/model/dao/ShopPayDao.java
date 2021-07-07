package kh.com.petbreedding.Shop.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;

@Repository("shopPayDao")
public class ShopPayDao {

	@Autowired
	private SqlSession sqlSession;
	
	
//	미용실 결제 테이블 저장
	public int harPay(HarPay harPay) {
		return sqlSession.insert("shopPay.harPay", harPay);
	}

//	미용실 예약 상태 변경
	public int harRevUp(String har_rnum) {
		return sqlSession.update("shopPay.harRevUp", har_rnum);
	}
	
//	동물병원 결제 테이블 저장
	public int hosPay(HosPay hosPay) {
		return sqlSession.insert("shopPay.hosPay", hosPay);
	}

//	동물병원 예약 상태 변경
	public int hosRevUp(String hos_rnum) {
		return sqlSession.update("shopPay.hosRevUp", hos_rnum);
	}
	
	
	public void updateRevByScheduled(){
		try {
			sqlSession.update("shopPay.updateRevByScheduled");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void updateRevByScheduled2(){
		try {
			sqlSession.update("shopPay.updateRevByScheduled2");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
}
