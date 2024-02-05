package com.study.shopsmanager.repositories;

import com.study.shopsmanager.entities.SupplierStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierStockRepository extends JpaRepository<SupplierStockEntity, Long> { }
