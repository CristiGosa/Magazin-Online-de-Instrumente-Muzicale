package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class SellerController {

    @FXML
    private Button SignOutSeller, Sell;
    private Stage stage;
    private Parent root;

    public void gotoPages(ActionEvent event)throws Exception{
        if(event.getSource() == Sell){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("ListForSelling.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Login");
            this.stage.setScene(scene);
            this.stage.show();
        }
    }

    public static void display() {
        Stage window = new Stage();
        Parent root ;
        try {
            root = FXMLLoader.load(BuyerController.class.getClassLoader().getResource("SellerHomePage.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SignOut()
    {
        Stage stage = (Stage) SignOutSeller.getScene().getWindow();
        stage.close();
    }
}
