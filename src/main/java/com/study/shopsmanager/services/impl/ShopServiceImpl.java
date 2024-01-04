package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.entities.DeliveryEntity;
import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.entities.ShopStockEntity;
import com.study.shopsmanager.services.ShopService;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.repositories.DeliveryRepository;
import com.study.shopsmanager.repositories.ItemRepository;
import com.study.shopsmanager.repositories.ShopRepository;
import com.study.shopsmanager.repositories.ShopStockRepository;
import com.study.shopsmanager.repositories.SupplierRepository;
import com.study.shopsmanager.utils.mappers.DeliveryMapper;
import com.study.shopsmanager.utils.mappers.ShopMapper;
import com.study.shopsmanager.utils.mappers.ShopStockMapper;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private ShopStockRepository shopStockRepository;
  @Autowired
  private DeliveryRepository deliveryRepository;
  @Autowired
  private SupplierRepository supplierRepository;
  @Autowired
  private ShopMapper shopMapper;
  @Autowired
  private ShopStockMapper shopStockMapper;
  @Autowired
  private DeliveryMapper deliveryMapper;

  @Override
  public ShopDTO createShop(ShopDTO shop) {
    ShopEntity shopEntity = shopMapper.toShopEntity(shop);
    shopRepository.save(shopEntity);

    return shop;
  }

  @Override
  public ShopDTO updateShop(Long id, ShopDTO shop) {
    Optional<ShopEntity> shopEntity = shopRepository.findById(id);

    if (shopEntity.isPresent()) {
      shopEntity.get().setName(shop.getName());
      shopRepository.save(shopEntity.get());
      return shop;
    }

    return null;
  }

  @Override
  public void deleteShop(Long id) {
    shopRepository.deleteById(id);
  }

  @Override
  public Collection<ShopDTO> getShops(Set<Long> ids) {
    Collection<ShopEntity> shops;

    shops = ids == null ? shopRepository.findAll() : shopRepository.findAllByIdIn(ids);
    var a = shopMapper.toShopDTOs(shops);
    return shopMapper.toShopDTOs(shops);
  }

  @Override
  public Collection<ShopStockDTO> getItemsByShopId(Long shopId) {
    Collection<ShopStockEntity> stocks = shopStockRepository.findAllByShopId(shopId);

    return shopStockMapper.toShopStockDTOs(stocks);
  }

  public Collection<DeliveryDTO> getDeliveriesByShopId(Long shopId) {
    Collection<DeliveryEntity> deliveryEntities = deliveryRepository.findAllByShopId(shopId);

    return deliveryMapper.toDeliveryDTOs(deliveryEntities);
  }
}
