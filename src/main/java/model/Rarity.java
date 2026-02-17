package model;

import java.util.Objects;

public class Rarity {
    private Integer id;
    private String rarity_ds;

    public Rarity(Integer id, String rarity_ds) {
        this.id = id;
        this.rarity_ds = rarity_ds;
    }

    public Integer getRarity_id() {
        return id;
    }

    public String getRarity_ds() {
        return rarity_ds;
    }

    @Override
    public String toString() {
        return this.getRarity_ds();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rarity rarity = (Rarity) o;
        return Objects.equals(getRarity_ds(), rarity.getRarity_ds());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRarity_ds());
    }
}
