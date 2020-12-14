package controllery;

import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import javax.management.Notification;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPLogin extends openFXMl implements Initializable {

    Uzytkownik user;

    @FXML
    private TextField loginUtxt;

    @FXML
    private PasswordField passUtxt;

    Notification notification;

    @FXML
    void changePassword(ActionEvent event)  {



    }

    @FXML
    void logIN(ActionEvent event) throws IOException {

        String login = loginUtxt.getText();
        String passwd = passUtxt.getText();
        UzytkownikQuery users = new UzytkownikQuery();
        boolean userVerification = users.selectByLoginandPassword(login, passwd);


        if (userVerification) {
            Uzytkownik logowanie = users.selecyByLoginandPassword(login, passwd);
            user = logowanie;

            String link = "/fxml/panelUser.fxml";
            readFXML(event, link);

            Controller_User personalId = read.getController();
            personalId.readIdUser(user.getIdUzytkownika());
            personalId.readInfoUser(user.getImie(), user.getNazwisko(), user.getEmail());


            frame(event);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Niepoprawna nazwa uzytkownika lub haslo! ");
            alert.setContentText("Sprawdz dane!");
            alert.show();

        }
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
