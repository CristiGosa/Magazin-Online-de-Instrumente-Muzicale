package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
import java.util.Objects;

public class Instrument {
    @Id
    private String name;
    private String category;
    private String descr;
    private String price;

    public Instrument(String name, String category, String descr, String price){
        this.name = name;
        this.category = category;
        this.descr = descr;
        this.price = price;
    }

    public Instrument(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument inst = (Instrument) o;
        return Objects.equals(name, inst.name) && Objects.equals(category, inst.category) && Objects.equals(descr, inst.descr) && Objects.equals(price, inst.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, descr, price);
    }
}
