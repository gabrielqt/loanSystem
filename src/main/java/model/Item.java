package model;

import java.util.Objects;

public class Item {
    private Integer item_id;
    private String item_ds;
    private boolean available;
    private Rarity rarity;

    public Item(Integer item_id, String item_ds, boolean available, Rarity rarity) {
        this.item_id = item_id;
        this.item_ds = item_ds;
        this.available = available;
        this.rarity = rarity;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public String getItem_ds() {
        return item_ds;
    }

    public boolean isAvailable() {
        return available;
    }

    public Rarity getRarity_id() {
        return rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(getItem_id(), item.getItem_id());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getItem_id());
    }


}
