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
    private Pane changePane;



    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }



    @FXML
    void goToContact(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelContact.fxml"));
        changePane.getChildren().add(newLoadPane);

    }


    @FXML
    void backToStart(ActionEvent event) {

    }

    @FXML
    void goToCompanyData(ActionEvent event) {

    }


    @FXML
    void goToPersonalData(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelPersonalData.fxml"));
        changePane.getChildren().add(newLoadPane);

    }



    @FXML
    void goToAnalysisType(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelAnalysis_Type.fxml"));
        changePane.getChildren().add(newLoadPane);


    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {




    }
}