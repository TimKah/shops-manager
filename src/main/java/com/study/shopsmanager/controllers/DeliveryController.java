package com.study.shopsmanager.controllers;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.services.DeliveryService;
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
public class DeliveryController {
  @Autowired
  DeliveryService deliveryService;

  @PostMapping(value = "deliveries/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DeliveryDTO> createItem(@RequestBody DeliveryDTO deliveryDTO) {
    return new ResponseEntity<>(deliveryService.createDelivery(deliveryDTO), HttpStatus.OK);
  }

  @PutMapping(value = "deliveries/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DeliveryDTO> updateItem(@RequestParam Long id, @RequestBody DeliveryDTO deliveryDTO) {
    DeliveryDTO result = deliveryService.updateDelivery(id, deliveryDTO);

    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }

  @DeleteMapping(value = "deliveries/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> deleteItem(@RequestParam Long id) {
    deliveryService.deleteDelivery(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<DeliveryDTO>> getItems(@RequestParam(required = false) Set<Long> ids) {
    return new ResponseEntity<>(deliveryService.getDeliveries(ids), HttpStatus.OK);
  }

  @GetMapping(value = "deliveries/shop", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<DeliveryDTO>> getDeliveriesForShop(@RequestParam Long shopId) {
    return new ResponseEntity<>(deliveryService.getDeliveriesByShopId(shopId), HttpStatus.OK);
  }
}
