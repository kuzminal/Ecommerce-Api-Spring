package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.ItemEntity;
import com.kuzmin.ecommerce.model.Item;

import java.util.List;

public interface ItemService {

  ItemEntity toEntity(Item m);

  List<ItemEntity> toEntityList(List<Item> items);

  Item toModel(ItemEntity e);

  List<Item> toModelList(List<ItemEntity> itemEntities);
}
