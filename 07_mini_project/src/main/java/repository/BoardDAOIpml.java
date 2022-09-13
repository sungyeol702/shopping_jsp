package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DataBaseBuilder;

public class BoardDAOIpml implements BoardDAO {
	private static Logger log = LoggerFactory.getLogger(BoardDAOIpml.class);
	private SqlSession sql;
	private final String NS = "BoardMapper.";
	public BoardDAOIpml() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(BoardVO bvo) {
		int isUp = sql.insert(NS+"reg",bvo);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<BoardVO> selectList() {

		return  sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectOne(long bno) {

		return sql.selectOne(NS+"detail",bno);
	}

	@Override
	public int update(BoardVO bvo) {
		int isUp = sql.update(NS+"mod",bvo); 
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long bno) {
		int isUp = sql.delete(NS+"del", bno);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public List<BoardVO> searchList(String scope, String keyword) {
		Map<String, String> map = new HashMap<>();
		map.put("scope",scope);
		map.put("keyword",keyword);
		return sql.selectList(NS+"search",map);
	}

}
