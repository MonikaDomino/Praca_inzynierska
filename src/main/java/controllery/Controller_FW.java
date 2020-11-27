package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller_FW extends openFXMl implements Initializable {


    @FXML
    void open(ActionEvent event) {

        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);



    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}

