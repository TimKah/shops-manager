package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import java.util.Set;

public interface ShopService {
  ShopDTO createShop(ShopDTO shop);
  ShopDTO updateShop(Long id, ShopDTO shop);
  void deleteShop(Long id);
  Iterable<ShopDTO> getShops(Set<Long> ids);
  Iterable<ShopStockDTO> getItemsByShopId(Long shopId);
}
