package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyerController {

    private Parent root;
    private Stage stage;
    @FXML
    private Button SignOutBuyer;

    public static void display() {
        Stage window = new Stage();
        Parent root ;
        try {
            root = FXMLLoader.load(BuyerController.class.getClassLoader().getResource("BuyerHomePage.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SignOut()
    {
        Stage stage = (Stage) SignOutBuyer.getScene().getWindow();
        stage.close();
    }
}
