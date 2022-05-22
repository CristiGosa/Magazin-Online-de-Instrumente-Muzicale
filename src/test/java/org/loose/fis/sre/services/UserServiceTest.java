package org.loose.fis.sre.services;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;

public class UserServiceTest {

    @Test
    @DisplayName("Username already exists test")
    void checkUsernameAlreadyExists(){
        UserService.initDatabase();
        assertThrows(UsernameAlreadyExistsException.class, 
        () -> {
            UserService.addUser("test","test","Buyer");
            UserService.addUser("test","test","Buyer");
        });
    }
    
    @Test
    @DisplayName("Empty username/password field")
    void registerTestFields(){
        assertThrows(NullPointerException.class, () -> {
            UserService.addUser("", "test", "Buyer");
            UserService.addUser("test", "", "Buyer");
                });
    }   
  
    @Test
    @DisplayName("Login invalid role assignation")
    void checkAccountInformationTest() throws UsernameAlreadyExistsException {
    	UserService.addUser("testul","testul","Admin");
    	int validation = UserService.checkAccountInformation("test1", "test1");
    	assertEquals(validation,0);
    }  
}