package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.ShopStockEntity;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopStockRepository extends CrudRepository<ShopStockEntity, Long> {
  Collection<ShopStockEntity> findAllByShopId(Long shopId);
}