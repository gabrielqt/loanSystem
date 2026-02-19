package model;

import java.util.Objects;

public class Item {
    private Integer id;
    private String item_ds;
    private boolean available;
    private Rarity rarity;

    public Item(){}

    public Item(Integer id, String item_ds, boolean available, Rarity rarity) {
        this.id = id;
        this.item_ds = item_ds;
        this.available = available;
        this.rarity = rarity;
    }

    public Item(String item_ds, boolean available, Rarity rarity) {
        this.id = null;
        this.item_ds = item_ds;
        this.available = available;
        this.rarity = rarity;
    }

    public Integer getItem_id() {
        return id;
    }

    public String getItem_ds() {
        return item_ds;
    }

    public boolean isAvailable() {
        return available;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItem_ds(String item_ds) {
        this.item_ds = item_ds;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
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
