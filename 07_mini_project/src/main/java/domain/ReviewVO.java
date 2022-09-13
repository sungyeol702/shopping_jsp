package domain;


public class ReviewVO {

	private long rno; 
	private int pno;
	private String title;
	private String writer;
	private String description;
	private String image_file;
	private String reg_at;
	private String mod_at;
	private String pname;
	public ReviewVO() {}
	
	//register
	public ReviewVO(int pno,String title, String writer, String description, String image_file) {
		this.pno = pno;
		this.title = title;
		this.writer = writer;
		this.description = description;
		this.image_file = image_file;
	}
	//mlist,
	public ReviewVO(long rno, int pno, String title, String writer, 
			String image_file, String reg_at, String pname, String description) {
		this.rno = rno;
		this.pno = pno;
		this.title = title;
		this.writer = writer;
		this.image_file = image_file;
		this.reg_at = reg_at;
		this.pname = pname;
		this.description = description;
	}
//detail
	public ReviewVO(long rno, int pno, String title, String writer, String description, String image_file,
			String reg_at, String mod_at,String pname) {
		this(rno, pno, title,writer, image_file,  reg_at,  pname,description);
		this.mod_at = mod_at;
	}
	

	//modify
	public ReviewVO(long rno,String title, String description, String image_file) {
		this.rno = rno;
		this.title = title;
		this.description = description;
		this.image_file = image_file;
	}


	

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getRno() {
		return rno;
	}

	public void setRno(long rno) {
		this.rno = rno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
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
	
	
	
}
