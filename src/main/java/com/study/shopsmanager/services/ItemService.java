package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.ItemDTO;
import java.util.Set;

public interface ItemService {
  ItemDTO createItem(ItemDTO itemDTO);
  ItemDTO updateItem(Long id, ItemDTO shop);
  void deleteItem(Long id);
  Iterable<ItemDTO> getItems(Set<Long> ids);
}
