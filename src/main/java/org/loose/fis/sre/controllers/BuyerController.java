package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
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
    @FXML
    private Button AvailableProducts, Buy, HomePage;


    public void gotoPages(ActionEvent event)throws Exception{
        if(event.getSource() == AvailableProducts){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("AvailableProducts.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Products Available");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == HomePage){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("BuyerHomePage.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Home Page");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == Buy){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("Buy.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Home Page");
            this.stage.setScene(scene);
            this.stage.show();
        }
    }
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
