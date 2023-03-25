package com.ricogroth.houseinventory.item;

import java.util.Date;

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
    public String id;
    public String category; // Oberkategorie
    public String name;     // Unterkategorie
    public int quantity;    // Anzahl
    public Date bestBefore; // Ablaufdatum
    public String weight;   // Gewicht QUESTION: Enum verwenden?

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        ItemEntity other = (ItemEntity) o;
        return (
            this.id.equals(other.id) &&
            this.category.equals(other.category) &&
            this.name.equals(other.name) &&
            this.quantity == other.quantity &&
            this.bestBefore.equals(other.bestBefore) &&
            this.weight.equals(other.weight)
        );
    }
}
