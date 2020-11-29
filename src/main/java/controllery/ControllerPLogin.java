package controllery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPLogin extends openFXMl implements Initializable {

    @FXML
    private TextField loginUtxt;

    @FXML
    private PasswordField passUtxt;


    @FXML
    void changePassword(ActionEvent event)  {



    }

    @FXML
    void logIN(ActionEvent event) {

        String link = "/fxml/panelUser.fxml";
        readFXML(event, link);
        frame(event);

    }

    @FXML
    void register(ActionEvent event) {

        String link = "/fxml/panelRegist.fxml";
        readFXML(event, link);
        frame(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
