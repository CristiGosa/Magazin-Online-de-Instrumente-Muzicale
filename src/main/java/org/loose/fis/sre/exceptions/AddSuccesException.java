package org.loose.fis.sre.exceptions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AddSuccesException {

    public static void displayInvalid(){
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

}
