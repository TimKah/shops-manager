package com.study.shopsmanager.controllers;

import com.study.shopsmanager.dto.ItemDTO;
import com.study.shopsmanager.services.ItemService;
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
public class ItemController {
  @Autowired
  ItemService itemService;

  @PostMapping(value = "items/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO shop) {
    return new ResponseEntity<>(itemService.createItem(shop), HttpStatus.OK);
  }

  @PutMapping(value = "items/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ItemDTO> updateItem(@RequestParam Long id, @RequestBody ItemDTO shop) {
    ItemDTO result = itemService.updateItem(id, shop);

    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }

  @DeleteMapping(value = "items/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> deleteItem(@RequestParam Long id) {
    itemService.deleteItem(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "items", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<ItemDTO>> getItems(@RequestParam(required = false) Set<Long> ids) {
    return new ResponseEntity<>(itemService.getItems(ids), HttpStatus.OK);
  }
}
