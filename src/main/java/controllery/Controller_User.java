package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_User extends openFXMl {


    @FXML
    private BorderPane borderPane;


    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }

    @FXML
    void backToStart(MouseEvent event) {

    }

    @FXML
    void goToAnalysis(MouseEvent event) {

    }

    @FXML
    void goToCompanyData(MouseEvent event) {

    }

    @FXML
    void goToContact(MouseEvent event) {

        loadPage("/fxml/panelUser_type/panelContact");

    }

    @FXML
    void goToPersonalData(MouseEvent event) {

    }

    private void loadPage (String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(Controller_User.class.getName()).log(Level.SEVERE, null, e);
        }
            borderPane.setCenter(root);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}