package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.entities.ItemEntity;
import com.study.shopsmanager.dto.ItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
  ItemDTO toItemDTO(ItemEntity item);
  Iterable<ItemDTO> toItemDTOs(Iterable<ItemEntity> items);
  ItemEntity toItemEntity(ItemDTO item);
}
