package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;

public interface CommentService {
	public int post(CommentVO cvo);
	public List<CommentVO> getList(long bno);
	public int remove(long cno);
	public int removeAll(long bno);
}
