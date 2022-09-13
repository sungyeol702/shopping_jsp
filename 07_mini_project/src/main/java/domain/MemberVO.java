package domain;


public class MemberVO {
	private String id; 
	private String pwd;
	private String name;
	private String address; 
	private int grade;
	private int total_amount; 
	private String reg_at;
	private String mod_at;
	private String last_login;
	public MemberVO() {}
	//join
	public MemberVO(String id, String pwd, String name ,String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}
	//list
	public MemberVO(String id, String name, String address, int grade, String last_login) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.grade = grade;
		this.last_login = last_login;
	}
	//modify
	public MemberVO(String id, String pwd, String name, String address, int grade) {
		this.id = id;
		this.pwd = pwd;
		this.grade=grade;
		this.name = name;
		this.address = address;
	}
	//detail
	public MemberVO(String id, String pwd, String name, String address, int grade, int total_amount, String reg_at,
			String mod_at, String last_login) {
		this(id, pwd, name, address, grade);
		this.total_amount = total_amount;
		this.reg_at = reg_at;
		this.mod_at = mod_at;
		this.last_login = last_login;
	}
	
	public MemberVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public MemberVO(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id; 
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
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
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
}
