package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.ItemEntity;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
  Collection<ItemEntity> findAll();
  Collection<ItemEntity> findAllByIdIn(Collection<Long> id);
}
