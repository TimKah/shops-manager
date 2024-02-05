package com.study.shopsmanager.controllers;

import com.study.shopsmanager.dto.SupplierDTO;
import com.study.shopsmanager.services.SupplierService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
  @Autowired
  SupplierService supplierService;

  @PostMapping(value = "suppliers/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SupplierDTO> createItem(@RequestBody SupplierDTO supplierDTO) {
    return new ResponseEntity<>(supplierService.createSupplier(supplierDTO), HttpStatus.OK);
  }

  @PutMapping(value = "suppliers/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SupplierDTO> updateItem(@RequestParam Long id, @RequestBody SupplierDTO supplierDTO) {
    SupplierDTO result = supplierService.updateSupplier(id, supplierDTO);

    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }

  @DeleteMapping(value = "suppliers/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> deleteItem(@RequestParam Long id) {
    supplierService.deleteSupplier(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<SupplierDTO>> getItems(@RequestParam(required = false) Set<Long> ids) {
    return new ResponseEntity<>(supplierService.getSuppliers(ids), HttpStatus.OK);
  }
}
