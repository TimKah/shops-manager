package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.entities.DeliveryEntity;
import com.study.shopsmanager.repositories.DeliveryRepository;
import com.study.shopsmanager.services.DeliveryService;
import com.study.shopsmanager.utils.mappers.DeliveryMapper;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
  @Autowired
  private DeliveryRepository deliveryRepository;
  @Autowired
  private DeliveryMapper deliveryMapper;

  @Override
  public DeliveryDTO createDelivery(DeliveryDTO deliveryDTO) {
    return null;
  }

  @Override
  public DeliveryDTO updateDelivery(Long id, DeliveryDTO deliveryDTO) {
    return null;
  }

  @Override
  public void deleteDelivery(Long id) {
    deliveryRepository.deleteById(id);
  }

  @Override
  public Iterable<DeliveryDTO> getDeliveries(Set<Long> ids) {
    Iterable<DeliveryEntity> deliveryEntities = deliveryRepository.findAllById(ids);

    return deliveryMapper.toDeliveryDTOs(deliveryEntities);
  }

  @Override
  public Iterable<DeliveryDTO> getDeliveriesByShopId(Long shopId) {
    Iterable<DeliveryEntity> deliveryEntities = deliveryRepository.findAllByShopId(shopId);

    return deliveryMapper.toDeliveryDTOs(deliveryEntities);
  }
}
