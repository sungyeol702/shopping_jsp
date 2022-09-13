package repository;

import java.util.List;

import domain.BuyListVO;
import domain.MemberVO;

public interface MemberDAO {
	public int insert(MemberVO mvo);
	public List<MemberVO> selectList();
	public MemberVO selectOne(String id);
	public int update(MemberVO mvo);
	public int delete(String id);
	public MemberVO selectOne(MemberVO mvo);
	public int updateLogin(String email);
	public String findpwd(String id,String name);
	public int updateAmount(BuyListVO buyVO);
	public List<String> findId(String name);
	
}
