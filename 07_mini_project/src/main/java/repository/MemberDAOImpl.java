package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BuyListVO;
import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int isUp = sql.insert(NS+"reg", mvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<MemberVO> selectList() {

		return sql.selectList(NS+"list");
	}

	@Override
	public MemberVO selectOne(String id) {

		return sql.selectOne(NS+"detail", id);
	}

	@Override
	public int update(MemberVO mvo) {
		int isUp = sql.update(NS+"mod", mvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public int delete(String id) {
		int isUp = sql.delete(NS+"del", id);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		MemberVO member = sql.selectOne(NS+"login", mvo);
		if(member != null) {
			String id =member.getId();
			int isUp =sql.update(NS+"last", id);
			if (isUp > 0) {
				sql.commit();
				return member;
			}
		}
		
		return null;
	}
	

	@Override
	public int updateLogin(String id) {
		int isUp = sql.update(NS+"last", id);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public String findpwd(String id,String name) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		return sql.selectOne(NS+"findpwd", map);
	}

	@Override
	public int updateAmount(BuyListVO buyVO) {
		int isUp = sql.update(NS+"plus", buyVO);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	
	}

	@Override
	public List<String> findId(String name) {
		
		return sql.selectList(NS+"findid", name);
	}


}
