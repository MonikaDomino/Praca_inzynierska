package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_User extends openFXMl {


    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}