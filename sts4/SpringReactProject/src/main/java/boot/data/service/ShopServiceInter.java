package boot.data.service;

import boot.data.dto.ShopDto;

import java.util.List;

public interface ShopServiceInter {
    public void insertShop(ShopDto dto);
    public List<ShopDto> getShopDatas();
    public ShopDto getData(int num);
}
