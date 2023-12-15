package boot.data.service;

import boot.data.dto.ShopDto;
import boot.data.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements ShopServiceInter {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void insertShop(ShopDto dto) {
        shopMapper.insertShop(dto);
    }

    @Override
    public List<ShopDto> getShopDatas() {
        return shopMapper.getShopDatas();
    }

}
