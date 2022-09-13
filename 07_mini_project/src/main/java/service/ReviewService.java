package service;

import java.util.List;

import domain.ReviewVO;

public interface ReviewService {
	public int register(ReviewVO rvo);
	public List<ReviewVO> getPList(int pno);
	public List<ReviewVO> getMList(String id);
	public ReviewVO getDetail(long rno);
	public int modify(ReviewVO rvo);
	public int remove(long rno);
	public String getFileName(long rno);

}
