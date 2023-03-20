package com.ricogroth.houseinventory.item;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "items")
public class ItemEntity {
    @Id
    private String id;
    private String name;
    private int numberData;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public int getNumberData() {
        return this.numberData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberData(int numberData) {
        this.numberData = numberData;
    }
}
