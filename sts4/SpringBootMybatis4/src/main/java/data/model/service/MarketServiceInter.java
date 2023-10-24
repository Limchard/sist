package data.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.model.dto.MarketDto;

@Mapper
public interface MarketServiceInter { 	// 이건 필요없다. 단지 MarketMapperInter.java 의 method들을 한번에 가져오기 위해(implement받기 위해) 생성했을뿐.. 다른 의미는 없다.
	

	// mapper를 service 를 가져와.. 
	// Controller에서 service를 가져온다.??
	// controller 에서 해야하는데 이거에 대한 부담감을 줄이기 위해 service 라는 공간을 만든다.

	public int getTotalCountOfMarket(); // getTotalCountOfMarket이 id(framework에서 id로 썼던거) 역할을 해준다.
	public List<MarketDto> getAllSangpums();
	public void insertMarket(MarketDto dto);
	public MarketDto getData(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
	
	// map의 경우 풀이해서 적어준다. int a,int b 이런 식으로..
}
