package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.entities.ItemEntity;
import com.study.shopsmanager.dto.ItemDTO;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
  ItemDTO toItemDTO(ItemEntity item);
  Collection<ItemDTO> toItemDTOs(Collection<ItemEntity> items);
  ItemEntity toItemEntity(ItemDTO item);
}
