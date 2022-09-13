package domain;


public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private String category;
	private String reg_at;
	private String mod_at;
	private String description;
	
	public ProductVO() {}
	//register
	public ProductVO( String pname, int price, String category, String description) {
		this.pname = pname;
		this.price = price;
		this.category = category;
		this.description= description;
	}
	//list
	public ProductVO(int pno,  int price, String pname, String reg_at,String category) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.reg_at = reg_at;
		this.category = category;
		
	}
	//modify
	public ProductVO(int pno, String pname,  String category,int price,String description) {
		this(pname, price, category, description);
		this.pno = pno;
	}
	
	//detail
	public ProductVO(int pno, String pname, int price, String category, String reg_at, String mod_at,String description) {
		this(pno, pname, category, price, description);
		this.reg_at = reg_at;
		this.mod_at = mod_at;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReg_at() {
		return reg_at;
	}
	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	}
	public String getMod_at() {
		return mod_at;
	}
	public void setMod_at(String mod_at) {
		this.mod_at = mod_at;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
