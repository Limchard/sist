package data.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.model.dto.MarketDto;
import data.model.mapper.MarketMapperInter;

@Service // 자바로직을 사용하기 위해 보완해주는 공간.. 여기서는 mapper에서 interface, dao 생략하고 controller로 작업.. dao가 생략되었기 때문에 원래 dao에서 작업하던 java로직을 수행하기 위해 만든 임의의 공간이라고 생각하자.
// controller에서 로직을 한번에 다 처리하면.. 부담스럽다.. 렉도 많이 걸리고.. 그래서 나눠준다고 생각하면 될듯...
// 가독성을 위해서도 나누는게 좋다.
// 
public class MarketService implements MarketServiceInter { // 여기서의 int MarketServiceInter는 단순 편의성을 위해서 가지고 온 것이다.
	
	@Autowired
	MarketMapperInter mapperInter;
	
		
	// 매퍼인터페이스는 sql문을 전달하는 것이고.. 
	// 맵을 
	// 보통 map을 사용할때, 답변형 게시판을 만들때 service를 사용한다.
	// map의 경우 파라미터값을 int a,int b 이런식으로 풀어서 넘길 수 있다.

	// 재정리
	// 매 Service interface 는 서비스를 편하게 받기위한 인터페이스 뿐이다. 없어도 된다. 단,, 없으면 수작업으로 열심히 쳐야지... 
	// 서비스 구현은 메퍼를 가지고 와서 한다.
	
	
	@Override
	public int getTotalCountOfMarket() {
		// TODO Auto-generated method stub
		return mapperInter.getTotalCountOfMarket();
	}

	@Override
	public List<MarketDto> getAllSangpums() {
		// TODO Auto-generated method stub
		return mapperInter.getAllSangpums();
	}

	@Override
	public void insertMarket(MarketDto dto) {
		// TODO Auto-generated method stub
		mapperInter.insertMarket(dto);
	}

	@Override
	public MarketDto getData(String num) {
		// TODO Auto-generated method stub
		return mapperInter.getData(num);
	}

	@Override
	public void updateMarket(MarketDto dto) {
		// TODO Auto-generated method stub
		mapperInter.updateMarket(dto);
	}

	@Override
	public void deleteMarket(String num) {
		// TODO Auto-generated method stub
		mapperInter.deleteMarket(num);
	}

	
	
}
