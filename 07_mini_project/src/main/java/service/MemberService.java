package service;

import java.util.List;

import domain.BuyListVO;
import domain.MemberVO;

public interface MemberService {
	public int register(MemberVO mvo);
	public List<MemberVO> getList();
	public MemberVO getDetail(String id);
	public int modify(MemberVO memberVO);
	public int remove(String id);
	public MemberVO login(MemberVO mvo);
	public String findPwd(String id,String name);
	public int plusAmount(BuyListVO buyVO);
	public List<String> findID(String name);
}
