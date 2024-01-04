package com.study.shopsmanager.controllers;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.services.ShopService;
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {
  @Autowired
  ShopService shopService;

  @PostMapping(value = "shops/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ShopDTO> addShop(@RequestBody ShopDTO shop) {
    return new ResponseEntity<>(shopService.createShop(shop), HttpStatus.OK);
  }

  @PutMapping(value = "shops/update", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ShopDTO> addShop(@RequestParam Long id, @RequestBody ShopDTO shop) {
    ShopDTO result = shopService.updateShop(id, shop);

    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }

  @DeleteMapping(value = "shops/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<HttpStatus> deleteShop(@RequestParam Long id) {
    shopService.deleteShop(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "shops", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Collection<ShopDTO>> getShops(@RequestParam(required = false) Set<Long> ids) {
    return new ResponseEntity<>(shopService.getShops(ids), HttpStatus.OK);
  }

  @GetMapping(value = "shop-stock", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Collection<ShopStockDTO>> getItemsInShop(@RequestParam Long id) {
    return new ResponseEntity<>(shopService.getItemsByShopId(id), HttpStatus.OK);
  }

  @GetMapping(value = "shop-deliveries", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Collection<DeliveryDTO>> getDeliveriesForShop(@RequestParam Long id) {
    return new ResponseEntity<>(shopService.getDeliveriesByShopId(id), HttpStatus.OK);
  }



}
