package controllery;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller_Register extends openFXMl  implements Initializable {

    @FXML
    private TextField lnametxt;

    @FXML
    private TextField emailtxt;

    @FXML
    private PasswordField passwdtxt;

    @FXML
    private TextField fnametxt;

    @FXML
    private PasswordField conpasswdtxt;

    @FXML
    private TextField captchatxt;

    @FXML
    private ImageView imageV;

    @FXML
    private Label dane;



    @FXML
    void register(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }
}
