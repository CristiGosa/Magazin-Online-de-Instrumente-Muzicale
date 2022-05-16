package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private PasswordField Password;
    @FXML
    private TextField Username;
    private Parent root;
    private Stage stage;


    public void Login(ActionEvent event)throws Exception{


        //String encryptedPass = UserService.encodePassword(username,password);

        //if(UserService.checkAccountInformation(username,encryptedPass) == 1)
        //    ClientController.display();
        //if(UserService.checkAccountInformation(username,encryptedPass) == 2)
        //    MainStageController.display();
    }


    public void handleLoginAction(ActionEvent event) throws Exception {
        this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(this.root, 300,275);
        this.stage.setTitle("Registration");
        this.stage.setScene(scene);
        this.stage.show();
    }
}
