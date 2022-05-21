package org.loose.fis.sre.exceptions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyerExceptions {
    public static void displayInvalid(){
        Stage window = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(AddException.class.getClassLoader().getResource("InvalidAddException.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayValid(){
        Stage window = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(AddException.class.getClassLoader().getResource("AddInstrument.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }
    public static void alreadyBought(){
        Stage window = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(AddException.class.getClassLoader().getResource("Bought.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }
}
