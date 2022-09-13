package domain;


public class BoardVO {
	private long bno ;
	private String title;
	private String description;
	private String writer;
	private String reg_at;
	private String mod_at;
	public BoardVO() {}
	//register
	public BoardVO(String title, String description, String writer) {
		this.title = title;
		this.description = description;
		this.writer = writer;
	}
	//list
	public BoardVO(long bno, String title, String writer, String reg_at) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.reg_at = reg_at;
	}
	//modify
	public BoardVO(long bno, String title, String description) {
		this.bno = bno;
		this.title = title;
		this.description = description;
	}
	//detail
	public BoardVO(long bno, String title, String description, String writer, String reg_at, String mod_at) {
		this(bno, title, writer, reg_at);
		this.description = description;
		this.mod_at = mod_at;
	}
	public long getBno() {
		return bno;
	}
	public void setBno(long bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
