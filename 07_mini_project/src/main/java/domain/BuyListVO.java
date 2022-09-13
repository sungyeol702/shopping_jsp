package domain;


public class BuyListVO {
	private String buyer;
	private String address;
	private int pno;
	private int price;
	private String buy_date;
	private String pname;
	public BuyListVO() {}
	
	//생성
	public BuyListVO(String buyer, int pno) {
		this.buyer = buyer;
		this.pno = pno;
	}
	//list 
	public BuyListVO(String buyer, String address, int pno, String pname, 
			int price, String buy_date ) {
		this(buyer, pno);
		this.price = price;
		this.address = address;
		this.buy_date = buy_date;
		this.pname = pname;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	
	}
