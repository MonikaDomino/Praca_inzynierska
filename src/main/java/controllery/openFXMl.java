package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class openFXMl {

    Parent home;
    FXMLLoader read;
    Stage app;




    // method to open FXML

    public void readFXML (ActionEvent event, String link){

        try{
            read = new FXMLLoader(getClass().getResource(link));
            home = read.load();

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // method to create Scene

    public void frame (ActionEvent event){

        try{
            Scene homeScene = new Scene(home);
            app = (Stage) ((Node)event.getSource()).getScene().getWindow();
            app.hide();
            app.setScene(homeScene);
            app.show();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }

    public abstract void initialize(URL url, ResourceBundle rb);

}
