package data.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.model.dto.MarketDto;

@Mapper // dao가 했던 sql 전달자 역할을 여기서 한다.
public interface MarketMapperInter {

	public int getTotalCountOfMarket(); // getTotalCountOfMarket이 id(framework에서 id로 썼던거) 역할을 해준다.
	public List<MarketDto> getAllSangpums();
	public void insertMarket(MarketDto dto);
	public MarketDto getData(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
	
	
}
