package jretana.ordermicroservice.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    @Id
    private UUID orderUUID;

    private List<Item> items;

    private double totalPrice;

    public Order() {
    }

    public Order(UUID orderUUID, List<Item> items, double totalPrice) {
        this.orderUUID = orderUUID;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public UUID getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(UUID orderUUID) {
        this.orderUUID = orderUUID;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.getTotalPrice(), getTotalPrice()) == 0 && Objects.equals(getOrderUUID(), order.getOrderUUID()) && Objects.equals(getItems(), order.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderUUID(), getItems(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderUUID=" + orderUUID +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
