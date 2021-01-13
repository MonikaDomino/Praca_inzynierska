package controllery;

import hibernate.Firma;
import hibernate.FirmaQuery;
import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    Controller_Pass password;

    @FXML
    void changePassword(ActionEvent event)  {

        String link = "/fxml/panelPass.fxml";
        readFXML(event, link);
        frame(event);


        Controller_Pass passW = read.getController();
        password = passW;
        passW.hidden();


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
            personalId.readLabel(user.getImie(), user.getNazwisko());

            frame(event);

            FirmaQuery company = new FirmaQuery();
            Firma comp = company.showCompany(user.getIdUzytkownika());

            if(comp == null){
                personalId.showAlert();
            }


        } else {
            Alert alert_El = new Alert(Alert.AlertType.ERROR);
            alert_El.setHeaderText(null);
            alert_El.setContentText("Niepoprawna nazwa u¿ytkownika lub has³o! ");
            DialogPane dialogPane = alert_El.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");

            dialogPane.setPrefSize(450, 20);
            alert_El.showAndWait();

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
