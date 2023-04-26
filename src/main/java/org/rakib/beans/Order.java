package org.rakib.beans;

import java.util.List;

public class Order {
    private Integer orderId;
    private List<Item> items;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", items=" + items +
                '}';
    }

    public Order(Integer orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }
}
