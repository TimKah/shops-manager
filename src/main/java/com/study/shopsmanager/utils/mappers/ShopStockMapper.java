package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.entities.ShopStockEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopStockMapper {
  ShopStockDTO toShopStockDTO(ShopStockEntity shopStocks);
  Collection<ShopStockDTO> toShopStockDTOs(Collection<ShopStockEntity> shopStocks);
  ShopStockEntity toShopStockEntity(ShopStockDTO shopStock);
}
