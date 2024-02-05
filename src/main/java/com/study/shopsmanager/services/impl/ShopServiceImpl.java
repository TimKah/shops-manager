package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.entities.ShopStockEntity;
import com.study.shopsmanager.services.ShopService;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.repositories.ShopRepository;
import com.study.shopsmanager.repositories.ShopStockRepository;
import com.study.shopsmanager.utils.exceptions.ShopNotFoundException;
import com.study.shopsmanager.utils.mappers.ShopMapper;
import com.study.shopsmanager.utils.mappers.ShopStockMapper;
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
  private ShopStockRepository shopStockRepository;
  @Autowired
  private ShopMapper shopMapper;
  @Autowired
  private ShopStockMapper shopStockMapper;

  @Override
  public ShopDTO createShop(ShopDTO shopDTO) {
    ShopEntity shopEntity = shopMapper.toShopEntity(shopDTO);
    shopDTO = shopMapper.toShopDTO(shopRepository.save(shopEntity));

    return shopDTO;
  }

  @Override
  public ShopDTO updateShop(Long id, ShopDTO shopDTO) throws ShopNotFoundException {
    Optional<ShopEntity> shopEntity = shopRepository.findById(id);

    if (shopEntity.isPresent()) {
      shopEntity.get().setName(shopDTO.getName());
      shopDTO = shopMapper.toShopDTO(shopRepository.save(shopEntity.get()));
      return shopDTO;
    } else {
      throw new ShopNotFoundException(String.format("Shop with id %s was not found", id));
    }
  }

  @Override
  public void deleteShop(Long id) {
    shopRepository.deleteById(id);
  }

  @Override
  public Iterable<ShopDTO> getShops(Set<Long> ids) {
    Iterable<ShopEntity> shopEntities;
    shopEntities = ids == null ? shopRepository.findAll() : shopRepository.findAllById(ids);

    return shopMapper.toShopDTOs(shopEntities);
  }

  @Override
  public Iterable<ShopStockDTO> getItemsByShopId(Long shopId) {
    Iterable<ShopStockEntity> stocks = shopStockRepository.findAllByShopId(shopId);

    return shopStockMapper.toShopStockDTOs(stocks);
  }
}
