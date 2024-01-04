package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.dto.ShopDTO;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
  ShopDTO toShopDTO(ShopEntity shop);
  Collection<ShopDTO> toShopDTOs(Collection<ShopEntity> shops);
  ShopEntity toShopEntity(ShopDTO shop);
}
