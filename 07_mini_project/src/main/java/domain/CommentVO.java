package domain;

public class CommentVO {
	private long cno;
	private long bno;
	private String writer;
	private String content;
	private String reg_at;
	
	public CommentVO() {}

	
	//post
	public CommentVO(long bno, String writer, String content) {
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}
//list
	public CommentVO(long cno, long bno, String writer, String content, String reg_at) {
		this(bno, writer, content);
		this.cno = cno;
		this.reg_at = reg_at;
	}


	public long getCno() {
		return cno;
	}


	public void setCno(long cno) {
		this.cno = cno;
	}


	public long getBno() {
		return bno;
	}


	public void setBno(long bno) {
		this.bno = bno;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getReg_at() {
		return reg_at;
	}


	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	};
	
	
}
