package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import java.util.Collection;
import java.util.Set;

public interface ShopService {
  ShopDTO createShop(ShopDTO shop);
  ShopDTO updateShop(Long id, ShopDTO shop);
  void deleteShop(Long id);
  Collection<ShopDTO> getShops(Set<Long> ids);
  Collection<ShopStockDTO> getItemsByShopId(Long shopId);
  Collection<DeliveryDTO> getDeliveriesByShopId(Long shopId);
}
