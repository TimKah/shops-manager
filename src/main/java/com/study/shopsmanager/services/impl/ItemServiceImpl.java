package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.ItemDTO;
import com.study.shopsmanager.entities.ItemEntity;
import com.study.shopsmanager.repositories.ItemRepository;
import com.study.shopsmanager.services.ItemService;
import com.study.shopsmanager.utils.exceptions.ItemNotFoundException;
import com.study.shopsmanager.utils.mappers.ItemMapper;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
  @Autowired
  ItemRepository itemRepository;
  @Autowired
  ItemMapper itemMapper;

  @Override
  public ItemDTO createItem(ItemDTO itemDTO) {
    ItemEntity itemEntity = itemMapper.toItemEntity(itemDTO);
    itemDTO = itemMapper.toItemDTO(itemRepository.save(itemEntity));

    return itemDTO;
  }

  @Override
  public ItemDTO updateItem(Long id, ItemDTO itemDTO) throws ItemNotFoundException {
    Optional<ItemEntity> itemEntity = itemRepository.findById(id);

    if (itemEntity.isPresent()) {
      itemEntity.get().setName(itemDTO.getName());
      itemEntity.get().setMeasure(itemDTO.getMeasure());
      itemDTO = itemMapper.toItemDTO(itemRepository.save(itemEntity.get()));
      return itemDTO;
    } else {
      throw new ItemNotFoundException(String.format("Item with id %s was not found", id));
    }
  }

  @Override
  public void deleteItem(Long id) {
    itemRepository.deleteById(id);
  }

  @Override
  public Iterable<ItemDTO> getItems(Set<Long> ids) {
    Iterable<ItemEntity> items;
    items = ids == null ? itemRepository.findAll() : itemRepository.findAllById(ids);

    return itemMapper.toItemDTOs(items);
  }
}
