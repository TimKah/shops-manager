package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.entities.SupplierEntity;
import com.study.shopsmanager.dto.SupplierDTO;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
  SupplierDTO toSupplierDTO(SupplierEntity supplier);
  Collection<SupplierDTO> toSupplierDTOs(Collection<SupplierEntity> suppliers);
  SupplierEntity toShopEntity(SupplierDTO supplier);
}
