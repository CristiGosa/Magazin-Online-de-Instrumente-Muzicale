package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.LoginExceptions;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class LoginController {


    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    public TextField getUsernameField() {
        return usernameField;
    }

    private Parent root;
    private Stage stage;
    @FXML
    private Text registrationMess;

    public static String getDenSeller() {
        return denSeller;
    }

    private static String denSeller;

    public static String getDenBuyer() {
        return denBuyer;
    }

    private static String denBuyer;


    public void Login(ActionEvent event) throws Exception{
        checkLogin();


        //String encryptedPass = UserService.encodePassword(username,password);

        //if(UserService.checkAccountInformation(username,encryptedPass) == 1)
        //    ClientController.display();
        //if(UserService.checkAccountInformation(username,encryptedPass) == 2)
        //    MainStageController.display();
    }

    private void checkLogin() throws IOException {
        //Main m = new Main();
        denBuyer = usernameField.getText();
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty() ) {
            registrationMess.setText("Complete all fields!");
        }else{
            String username = usernameField.getText();

            String password = passwordField.getText();
            SellerController.setInstrSeller(usernameField);
            String encryptedPass = UserService.encodePassword(username, password);

            if (UserService.checkAccountInformation(username, encryptedPass) == 1) {

                BuyerController.display();
            }
            else if (UserService.checkAccountInformation(username, encryptedPass) == 2) {
                denSeller = usernameField.getText();
                SellerController.display();
            }
            else LoginExceptions.display();

        }
    }




    public void handleLoginAction(ActionEvent event) throws Exception {
        this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(this.root);
        this.stage.setTitle("Registration");
        this.stage.setScene(scene);
        this.stage.show();
    }
}
