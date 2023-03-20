package com.ricogroth.houseinventory.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ricogroth.houseinventory.item.ItemEntity;

public interface ItemRepository extends MongoRepository<ItemEntity, String> {
}
