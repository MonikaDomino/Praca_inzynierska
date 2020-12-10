package controllery;

import controllery.panelUsers.Controller_PersonalData;
import hibernate.Firma;
import hibernate.FirmaQuery;
import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPLogin extends openFXMl implements Initializable {

    Uzytkownik user;

    @FXML
    private TextField loginUtxt;

    @FXML
    private PasswordField passUtxt;



    @FXML
    void changePassword(ActionEvent event)  {



    }

    @FXML
    void logIN(ActionEvent event) throws IOException {

    String login = loginUtxt.getText();
    String passwd = passUtxt.getText();
        UzytkownikQuery users = new UzytkownikQuery();
        boolean userVerification = users.selectByLoginandPassword(login, passwd);


    if(userVerification) {
        Uzytkownik logowanie = users.selecyByLoginandPassword(login,passwd);
        user = logowanie;

        String link = "/fxml/panelUser.fxml";
        readFXML(event, link);

        Controller_User personalId = read.getController();
        personalId.readIdUser(user.getIdUzytkownika());
        personalId.readInfoUser(user.getImie(), user.getNazwisko(), user.getEmail());


        frame(event);


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
