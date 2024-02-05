package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.SupplierDTO;
import java.util.Set;

public interface SupplierService {
  SupplierDTO createSupplier(SupplierDTO itemDTO);
  SupplierDTO updateSupplier(Long id, SupplierDTO shop);
  void deleteSupplier(Long id);
  Iterable<SupplierDTO> getSuppliers(Set<Long> ids);
}
