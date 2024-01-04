package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.SupplierEntity;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity, Long> {
  Collection<SupplierEntity> findAll();
}
