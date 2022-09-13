package service;

import java.util.List;

import domain.ProductVO;

public interface ProductService {
	public int register(ProductVO pvo);
	public List<ProductVO> getList();
	public List<ProductVO> getList(String category);
	public ProductVO getListOne(int pno);
	public int modify(ProductVO pvo);
	public int remove(int pno);

}
