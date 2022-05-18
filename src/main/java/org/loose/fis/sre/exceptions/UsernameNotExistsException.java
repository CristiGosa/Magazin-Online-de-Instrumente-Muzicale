package org.loose.fis.sre.exceptions;

public class UsernameNotExistsException extends Exception {

    private String username;

    public UsernameNotExistsException(String username) {
        super(String.format("An account with the username %s does not exists!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}