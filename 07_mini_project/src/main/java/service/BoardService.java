package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;

public interface BoardService {
	public int register(BoardVO bvo);
	public List<BoardVO> getList();
	public BoardVO getdetail(long bno);
	public int modify(BoardVO bvo);
	public int remove(long bno);
	public List<BoardVO> getSearch(String scope, String keyword);
}
