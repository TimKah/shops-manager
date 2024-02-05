package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.entities.DeliveryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
  DeliveryDTO toDeliveryDTO(DeliveryEntity delivery);
  Iterable<DeliveryDTO> toDeliveryDTOs(Iterable<DeliveryEntity> deliveries);
  DeliveryEntity toDeliveryEntity(DeliveryDTO delivery);
}
