package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import repository.ReviewDAO;
import repository.ReviewDAOImpl;

public class ReviewServiceImpl implements ReviewService {
	private static Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);
	private ReviewDAO rdao;
	public ReviewServiceImpl() {
		rdao = new ReviewDAOImpl();
	}
	@Override
	public int register(ReviewVO rvo) {

		return rdao.insert(rvo);
	}

	@Override
	public List<ReviewVO> getPList(int pno) {

		return rdao.selectPList(pno);
	}

	@Override
	public List<ReviewVO> getMList(String id) {

		return rdao.selectMList(id);
	}

	@Override
	public ReviewVO getDetail(long rno) {

		return rdao.selectOne(rno);
	}

	@Override
	public int modify(ReviewVO rvo) {

		return rdao.update(rvo);
	}

	@Override
	public int remove(long rno) {

		return rdao.delete(rno);
	}
	@Override
	public String getFileName(long rno) {
		
		return rdao.fileName(rno);
	}

}
