package controllery;


import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    private TextField logintxt;



    @FXML
    void register(ActionEvent event) {

        String firstName = fnametxt.getText();
        String lastname = lnametxt.getText();
        String login = logintxt.getText();
        String password = passwdtxt.getText();
        String email = emailtxt.getText();


        UzytkownikQuery usser = new UzytkownikQuery();

        try {

            usser.register(firstName, lastname, login, password, email);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Rejestracja zakonczona sukcesem! Mozesz sie teraz zalogowac!");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {

                String adress = "/fxml/panelLogIN.fxml";
                readFXML(event, adress);
                frame(event);

            }else{
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setHeaderText("Rejestracja zakończyła się niepowodzeniem!");
                    alert2.show();
                }

            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }


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
