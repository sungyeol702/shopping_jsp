package repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BuyListVO;

public interface BuyListDAO {
	public int insert(BuyListVO buyvo);
	public List<BuyListVO> selectList(String id);
	public List<BuyListVO> selectAllList();
	public int deleteAll(String id);
}
