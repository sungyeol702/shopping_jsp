package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BuyListVO;

public interface BuyListService {
	public int register(BuyListVO buyvo);
	public List<BuyListVO> getList(String id);
	public List<BuyListVO> getListAll();
	public int remove(String id);
}
