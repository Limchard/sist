package boot.data.mapper;

import boot.data.dto.ShopDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface ShopMapper {

    public void insertShop(ShopDto dto);
    public List<ShopDto> getShopDatas();
    public ShopDto getData(int num);
    public void deleteShop(int num);
}
