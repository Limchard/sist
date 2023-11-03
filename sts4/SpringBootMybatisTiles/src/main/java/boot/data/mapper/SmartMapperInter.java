package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.SmartDto;

@Mapper
public interface SmartMapperInter {

	public void insertSmShop(SmartDto dto);
	public List<SmartDto> getAllSmShop(int num);
	public SmartDto getSmShopData(int num);
	public void updateSmShop(SmartDto dto);
	public void deleteSmShop(int num);
	
}
