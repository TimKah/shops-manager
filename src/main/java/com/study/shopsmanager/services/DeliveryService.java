package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.DeliveryDTO;
import java.util.Set;

public interface DeliveryService {
  DeliveryDTO createDelivery(DeliveryDTO deliveryDTO);
  DeliveryDTO updateDelivery(Long id, DeliveryDTO deliveryDTO);
  void deleteDelivery(Long id);
  Iterable<DeliveryDTO> getDeliveries(Set<Long> ids);
  Iterable<DeliveryDTO> getDeliveriesByShopId(Long shopId);
}
