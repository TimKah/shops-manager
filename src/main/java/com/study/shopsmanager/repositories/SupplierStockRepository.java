package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.SupplierStockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierStockRepository extends CrudRepository<SupplierStockEntity, Long> {
}
