package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.entities.ShopStockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopStockMapper {
  ShopStockDTO toShopStockDTO(ShopStockEntity shopStocks);
  Iterable<ShopStockDTO> toShopStockDTOs(Iterable<ShopStockEntity> shopStocks);
  ShopStockEntity toShopStockEntity(ShopStockDTO shopStock);
}
