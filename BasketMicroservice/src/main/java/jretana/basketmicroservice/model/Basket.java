package jretana.basketmicroservice.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Basket {

    @Id
    private UUID basketUUID;

    private List<Item> items = new ArrayList<>();

    public Basket() {
    }

    public Basket(UUID basketUUID) {
        this.setBasketUUID(basketUUID);
    }

    public Basket(UUID basketUUID, List<Item> items) {
        this.basketUUID = basketUUID;
        this.items = items;
    }

    public UUID getBasketUUID() {
        return basketUUID;
    }

    public void setBasketUUID(UUID basketUUID) {
        this.basketUUID = basketUUID;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(getBasketUUID(), basket.getBasketUUID()) && Objects.equals(getItems(), basket.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBasketUUID(), getItems());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketUUID=" + basketUUID +
                ", items=" + items +
                '}';
    }
}
