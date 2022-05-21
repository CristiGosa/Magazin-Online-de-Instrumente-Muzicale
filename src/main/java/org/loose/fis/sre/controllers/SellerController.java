package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.model.Inst;
import org.loose.fis.sre.model.Instrument;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.InstrService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerController implements Initializable {
    @FXML
    private TableColumn<Instrument, String> tableName = new TableColumn<>();
    @FXML
    private TableColumn<Instrument, String> tableCat = new TableColumn<>();;
    @FXML
    private TableColumn<Instrument, String> tablePrice = new TableColumn<>();;
    @FXML
    private TableColumn<Instrument, String> tableDesc = new TableColumn<>();;
    @FXML
    private TableView<Instrument> Table = new TableView<>();
    @FXML
    private TableView<Instrument> Table1 = new TableView<Instrument>();
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
    private Button SignOutSeller, Home, Sell, Delete, Review, History, myInst;
    private Stage stage;
    private Parent root;

    ObservableList<Instrument> instr = FXCollections.observableArrayList();
    private ArrayList<Instrument> list = new ArrayList<>();


    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCat.setCellValueFactory(new PropertyValueFactory<>("category"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableDesc.setCellValueFactory(new PropertyValueFactory<>("descr"));
        Table1.setItems(getInstruments());
        //Table1.getColumns().addAll(tableName, tableCat, tablePrice, tableDesc);
    }
    private ObservableList<Instrument> getInstruments()  {
        for (Instrument in : InstrService.GetRepository().find())
            if(in.getSeller().equals(LoginController.getDenUser())) {
                list.add(in);
            }

        instr.addAll(list);
        return instr;
    }

    public void handleAddAction() {
        Instrument i = new Instrument();
        InstrBuyer ="none";
        if(InstrName.getText().equals("") || InstrCateg.getText().equals("") || InstrDescr.getText().equals("") || InstrSeller.getText().equals("") || InstrBuyer == "" ){
            AddException.displayInvalid();
            return;
        }
        else try {
            i.setName(InstrName.getText());
            i.setCategory(InstrCateg.getText());
            i.setPrice(InstrPrice.getText());
            i.setBuyer(InstrBuyer);
            i.setSeller(InstrSeller.getText());
            InstrService.addInstr(InstrName.getText(), InstrCateg.getText(), InstrDescr.getText(), InstrPrice.getText(), InstrBuyer, InstrSeller.getText());
            Table.getItems().add(i);
            AddException.displayValid();
        } catch (UsernameAlreadyExistsException e) {
            AddException.displayInvalid();
        }
        InstrName.clear();
        InstrPrice.clear();
        InstrDescr.clear();
        InstrCateg.clear();
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
        if(event.getSource() == myInst){
            this.root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("MyInstruments.fxml"));
            this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(this.root);
            this.stage.setTitle("My Instruments");
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
