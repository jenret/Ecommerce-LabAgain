package jretana.catalogmicroservice.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

public class Item {

    @Id
    private UUID itemUUID;

    private String itemName;

    private String description;

    private double unitPrice;

    public Item() {
    }

    public Item(UUID itemUUID, String itemName, String description, double unitPrice) {
        this.itemUUID = itemUUID;
        this.itemName = itemName;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public UUID getItemUUID() {
        return itemUUID;
    }

    public void setItemUUID(UUID itemUUID) {
        this.itemUUID = itemUUID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.getUnitPrice(), getUnitPrice()) == 0 && Objects.equals(getItemUUID(), item.getItemUUID()) && Objects.equals(getItemName(), item.getItemName()) && Objects.equals(getDescription(), item.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemUUID(), getItemName(), getDescription(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemUUID=" + itemUUID +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
