package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BuyListVO;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	@Override
	public int register(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO getDetail(String id) {
		return mdao.selectOne(id);
	}

	@Override
	public int modify(MemberVO mvo) {
		
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		
		return mdao.delete(id);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		
		return mdao.selectOne(mvo);
	}
	@Override
	public String findPwd(String id,String name) {
		
		return mdao.findpwd(id,name);
	}
	@Override
	public int plusAmount(BuyListVO buyVO) {
		
		return mdao.updateAmount(buyVO);
	}
	@Override
	public List<String> findID(String name) {
		
		return mdao.findId(name);
	}

	

}
