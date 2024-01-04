package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.entities.DeliveryEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
  DeliveryDTO toDeliveryDTO(DeliveryEntity delivery);
  Collection<DeliveryDTO> toDeliveryDTOs(Collection<DeliveryEntity> deliveries);
  DeliveryEntity toDeliveryEntity(DeliveryDTO delivery);
}
