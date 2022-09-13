package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import orm.DataBaseBuilder;

public class ReviewDAOImpl implements ReviewDAO {
	private static Logger log = LoggerFactory.getLogger(BoardDAOIpml.class);
	private SqlSession sql;
	private final String NS = "ReviewMapper.";
	
	public ReviewDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(ReviewVO rvo) {
		int isUp = sql.insert(NS+"reg",rvo);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ReviewVO> selectPList(int pno) {
		
		return  sql.selectList(NS+"plist",pno);
	}

	@Override
	public List<ReviewVO> selectMList(String id) {
		
		return sql.selectList(NS+"mlist",id);
	}

	@Override
	public ReviewVO selectOne(long rno) {
		
		return sql.selectOne(NS+"detail",rno);
	}

	@Override
	public int update(ReviewVO rvo) {
		int isUp = sql.update(NS+"mod",rvo); 
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long rno) {
		int isUp = sql.delete(NS+"del", rno);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public String fileName(long rno) {
		
		return sql.selectOne(NS+"fileName",rno);
	}

}
