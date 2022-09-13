package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BuyListVO;
import orm.DataBaseBuilder;

public class BuyListDAOImpl implements BuyListDAO {
	private static Logger log = LoggerFactory.getLogger(BuyListDAOImpl.class);
	private SqlSession sql;
	private final String NS = "BuyListMapper.";
	public BuyListDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(BuyListVO buyvo) {
		int isUp = sql.insert(NS+"reg",buyvo);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<BuyListVO> selectList(String id) {

		return sql.selectList(NS+"list",id);
	}

	@Override
	public List<BuyListVO> selectAllList() {

		return sql.selectList(NS+"listAll");
	}

	@Override
	public int deleteAll(String id) {
		int isUp = sql.delete(NS+"delAll", id);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

}
