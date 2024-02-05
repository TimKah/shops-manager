package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.SupplierDTO;
import com.study.shopsmanager.entities.SupplierEntity;
import com.study.shopsmanager.repositories.SupplierRepository;
import com.study.shopsmanager.services.SupplierService;
import com.study.shopsmanager.utils.exceptions.ItemNotFoundException;
import com.study.shopsmanager.utils.mappers.SupplierMapper;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
  @Autowired
  SupplierRepository supplierRepository;
  @Autowired
  SupplierMapper supplierMapper;

  @Override
  public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
    SupplierEntity supplierEntity = supplierMapper.toShopEntity(supplierDTO);
    supplierRepository.save(supplierEntity);

    return supplierDTO;
  }

  @Override
  public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
    Optional<SupplierEntity> supplierEntity = supplierRepository.findById(id);

    if (supplierEntity.isPresent()) {
      supplierEntity.get().setName(supplierDTO.getName());
      supplierRepository.save(supplierEntity.get());
      return supplierDTO;
    } else {
      throw new ItemNotFoundException(String.format("Item with id %s was not found", id));
    }
  }

  @Override
  public void deleteSupplier(Long id) {
    supplierRepository.deleteById(id);
  }

  @Override
  public Iterable<SupplierDTO> getSuppliers(Set<Long> ids) {
    Iterable<SupplierEntity> suppliers;
    suppliers = ids == null ? supplierRepository.findAll() : supplierRepository.findAllById(ids);

    return supplierMapper.toSupplierDTOs(suppliers);
  }
}
