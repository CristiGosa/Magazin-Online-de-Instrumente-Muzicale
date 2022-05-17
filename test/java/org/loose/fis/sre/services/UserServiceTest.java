package org.loose.fis.sre.services;

import org.dizitart.no2.exceptions.InvalidIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import javax.validation.constraints.Null;

import static org.junit.jupiter.api.Assertions.*;

import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;


public class UserServiceTest {

    @Test
    @DisplayName("Username already exists test")
    void displayDatabaseIsInitialisedAndUsernameAlreadyExists(){
        UserService.initDatabase();
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser("test","test","Client");
            UserService.addUser("test","test","Client");
        });
    }
}
