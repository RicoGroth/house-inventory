package com.ricogroth.houseinventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricogroth.houseinventory.item.ItemEntity;
import com.ricogroth.houseinventory.item.ItemRepository;

@SpringBootApplication
@RestController
public class HouseInventoryApplication {

    @Autowired
    private ItemRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HouseInventoryApplication.class, args);
    }

    @GetMapping(path = "/get-items")
    public List<ItemEntity> helloWorld() {
        List<ItemEntity> items = repository.findAll();
        return items;
    }

    @GetMapping(path = "/insert-item")
    public String insertItem() {
        ItemEntity entity = new ItemEntity();
        entity.setName("MyName");
        entity.setNumberData(72);
        repository.save(entity);
        return "Inserted item";
    }
}
