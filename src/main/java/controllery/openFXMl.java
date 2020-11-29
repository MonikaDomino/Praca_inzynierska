package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;


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
