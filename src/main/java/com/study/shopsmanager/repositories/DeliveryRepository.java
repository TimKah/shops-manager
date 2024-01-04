package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.DeliveryEntity;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<DeliveryEntity, Long> {
  Collection<DeliveryEntity> findAllByShopId(Long shopId);
}