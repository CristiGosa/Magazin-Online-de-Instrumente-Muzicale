package org.loose.fis.sre.exceptions;

public class SellerNotExistsException extends Exception {

    private String seller;

    public SellerNotExistsException(String seller) {
        super(String.format("An account with the seller %s does not exists!", seller));
        this.seller = seller;
    }

    public String getUsername() {
        return seller;
    }
}
