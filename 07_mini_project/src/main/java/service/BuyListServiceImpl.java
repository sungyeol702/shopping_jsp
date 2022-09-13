package service;

import java.util.List;


import domain.BuyListVO;
import repository.BuyListDAO;
import repository.BuyListDAOImpl;

public class BuyListServiceImpl implements BuyListService {
	private BuyListDAO buydao;
	public BuyListServiceImpl() {
		buydao = new BuyListDAOImpl();
	}
	@Override
	public int register(BuyListVO buyvo) {

		return buydao.insert(buyvo);
	}

	@Override
	public List<BuyListVO> getList(String id) {

		return buydao.selectList(id);
	}

	@Override
	public List<BuyListVO> getListAll() {

		return buydao.selectAllList();
	}

	@Override
	public int remove(String id) {

		return buydao.deleteAll(id);
	}

}
