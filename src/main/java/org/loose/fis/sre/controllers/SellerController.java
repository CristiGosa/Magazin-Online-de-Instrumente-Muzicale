package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.model.Instrument;
import org.loose.fis.sre.services.InstrService;
import org.loose.fis.sre.services.UserService;

import java.awt.*;
import java.io.IOException;

public class SellerController {
    @FXML
    private TableView<Instrument> Table = new TableView<>();
    @FXML
    private TextField InstrName;
    @FXML
    private TextField InstrCateg;
    @FXML
    private TextArea InstrDescr;
    @FXML
    private TextField InstrPrice;
    @FXML
    private TextField deleteName;

    public static void setInstrSeller(TextField instrSeller) {
        InstrSeller = instrSeller;
    }

    @FXML
    private static TextField InstrSeller;
    @FXML
    private String InstrBuyer;
    @FXML
    private Button SignOutSeller, Home, Sell, Delete, Review, History;
    private Stage stage;
    private Parent root;

    public void handleAddAction() {
        //Instrument i = new Instrument();
        InstrBuyer ="none";
        if(InstrName.getText().equals("") || InstrCateg.getText().equals("") || InstrDescr.getText().equals("") || InstrSeller.getText().equals("") || InstrBuyer == "" ){
            AddException.displayInvalid();
            return;
        }
        else try {
            InstrService.addInstr(InstrName.getText(), InstrCateg.getText(), InstrDescr.getText(), InstrPrice.getText(), InstrBuyer, InstrSeller.getText());
            AddException.displayValid();
        } catch (UsernameAlreadyExistsException e) {
            AddException.displayInvalid();
        }
    }
    public void handleDeleteAction() {
        if(deleteName.getText().equals("")){
            AddException.displayInvalid();
            return;
        }
        else try {
            InstrService.deleteInstr(deleteName.getText());
            SuccesDeleteException.displayValid();
        } catch (UsernameNotExistsException e) {
            AddException.displayInvalid();
        }
    }

    public void gotoPages(ActionEvent event)throws Exception{
        if(event.getSource() == Home){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("SellerHomePage.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Home Page");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == Sell){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("ListForSelling.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Sell");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == Delete){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("DeleteInstrument.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Delete");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == Review){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("SellerReviews.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Reviews");
            this.stage.setScene(scene);
            this.stage.show();
        }
        if(event.getSource() == History){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("HistorySeller.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("History");
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
            window.setTitle("Home Page");
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
