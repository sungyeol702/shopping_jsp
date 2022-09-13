package service;

import java.util.List;
import domain.ProductVO;
import repository.ProductDAO;
import repository.ProductDAOIpml;

public class ProductServiceIpml implements ProductService {
	private ProductDAO pdao;
	public ProductServiceIpml() {
	pdao = new ProductDAOIpml();
	}
	@Override
	public int register(ProductVO pvo) {

		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList() {

		return pdao.selectList();
	}

	@Override
	public List<ProductVO> getList(String category) {

		return pdao.selectList(category);
	}

	@Override
	public ProductVO getListOne(int pno) {

		return pdao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {

		return pdao.update(pvo);
	}

	@Override
	public int remove(int pno) {

		return pdao.delete(pno);
	}

}
