package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
import java.util.Objects;

public class Review {


    @Id
    private int index;
    private String text;
    private String buyer;
    private String seller;


    public Review(int index, String text, String buyer, String seller){
        this.index = index;
        this.text = text;
        this.buyer = buyer;
        this.seller = seller;

    }

    public Review(){}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review inst = (Review) o;
        return Objects.equals(index, inst.index) && Objects.equals(text, inst.text) && Objects.equals(buyer, inst.buyer) && Objects.equals(seller, inst.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, text, buyer, seller);
    }
}
