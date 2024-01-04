package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.ShopEntity;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
  Collection<ShopEntity> findAll();
  Collection<ShopEntity> findAllByIdIn(Collection<Long> id);
}
