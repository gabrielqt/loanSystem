package model;

import java.util.Objects;

public class Rarity {
    private Integer rarity_id;
    private String rarity_ds;

    public Rarity(Integer rarity_id, String rarity_ds) {
        this.rarity_id = rarity_id;
        this.rarity_ds = rarity_ds;
    }

    public Integer getRarity_id() {
        return rarity_id;
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
