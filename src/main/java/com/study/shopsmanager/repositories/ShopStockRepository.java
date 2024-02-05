package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.ShopStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopStockRepository extends JpaRepository<ShopStockEntity, Long> {
  Iterable<ShopStockEntity> findAllByShopId(Long id);
}