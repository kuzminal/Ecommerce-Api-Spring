package com.kuzmin.ecommerce.service;

import static java.util.stream.Collectors.toList;

import com.kuzmin.ecommerce.domain.ItemEntity;
import com.kuzmin.ecommerce.domain.ProductEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.kuzmin.ecommerce.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Override
  public ItemEntity toEntity(Item m) {
    ItemEntity e = new ItemEntity();
    e.setProduct(new ProductEntity().setId(UUID.fromString(m.getId()))).setPrice(m.getUnitPrice())
        .setQuantity(m.getQuantity());
    return e;
  }

  @Override
  public List<ItemEntity> toEntityList(List<Item> items) {
    if (Objects.isNull(items)) {
      return Collections.emptyList();
    }
    return items.stream().map(this::toEntity).collect(toList());
  }

  @Override
  public Item toModel(ItemEntity e) {
    Item m = new Item();
    m.id(e.getProduct().getId().toString()).unitPrice(e.getPrice()).quantity(e.getQuantity());
    return m;
  }

  @Override
  public List<Item> toModelList(List<ItemEntity> itemEntities) {
    if (Objects.isNull(itemEntities)) {
      return Collections.emptyList();
    }
    return itemEntities.stream().map(this::toModel).collect(toList());
  }
}
