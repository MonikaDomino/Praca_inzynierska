package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_User extends openFXMl {



    @FXML
    private Pane pane;
    @FXML
    private BorderPane border;




    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }



    @FXML
    void goToContact(ActionEvent event) {
        String link = "/fxml/panelUser_type/panelContact.fxml";
        readFXMLInBorderPane(event,link);

    }


    @FXML
    void backToStart(ActionEvent event) {

    }

    @FXML
    void goToCompanyData(ActionEvent event) {

    }


    @FXML
    void goToPersonalData(ActionEvent event) {

    }



    @FXML
    void goToAnalysisType(ActionEvent event) {
        String link = "/fxml/panelUser_type/panelAnalysis_Type.fxml";
        readFXMLInBorderPane(event,link);

    }

   public void readFXMLInBorderPane (ActionEvent event, String link){

        try{
            read = new FXMLLoader(getClass().getResource(link));
            pane = read.load();
            border.setCenter(pane);


        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {




    }
}