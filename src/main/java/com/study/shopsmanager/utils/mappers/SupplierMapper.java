package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.entities.SupplierEntity;
import com.study.shopsmanager.dto.SupplierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
  SupplierDTO toSupplierDTO(SupplierEntity supplier);
  Iterable<SupplierDTO> toSupplierDTOs(Iterable<SupplierEntity> suppliers);
  SupplierEntity toShopEntity(SupplierDTO supplier);
}
