package org.rakib.beans;

import java.util.List;

public class OrderDto {
    private Integer id;
    private List<String> itemName;

    public OrderDto(Integer id, List<String> itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getItemName() {
        return itemName;
    }

    public void setItemName(List<String> itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", itemName=" + itemName +
                '}';
    }
}
