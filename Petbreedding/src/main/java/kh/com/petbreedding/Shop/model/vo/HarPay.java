package kh.com.petbreedding.Shop.model.vo;

public class HarPay {
	private String pay_num;
	private String har_rnum;
	private String card_num;
	private String pay_date;
	private int pay_price;
	private int total_price;
	
	@Override
	public String toString() {
		return "HarPay [pay_num=" + pay_num + ", har_rnum=" + har_rnum + ", card_num="
				+ card_num + ", pay_date=" + pay_date + ", pay_price=" + pay_price + ", total_price=" + total_price
				+ "]";
	}
	public String getPay_num() {
		return pay_num;
	}
	public void setPay_num(String pay_num) {
		this.pay_num = pay_num;
	}
	public String getHar_rnum() {
		return har_rnum;
	}
	public void setHar_rnum(String har_rnum) {
		this.har_rnum = har_rnum;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
