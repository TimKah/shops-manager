package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
  Iterable<DeliveryEntity> findAllByShopId(Long shopId);
}