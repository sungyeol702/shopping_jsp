package repository;


import java.util.List;

import domain.ReviewVO;

public interface ReviewDAO {
	public int insert(ReviewVO rvo);
	public List<ReviewVO> selectPList(int pno);
	public List<ReviewVO> selectMList(String id);
	public ReviewVO selectOne(long rno);
	public int update(ReviewVO rvo);
	public int delete(long rno);
	public String fileName(long rno);
}
