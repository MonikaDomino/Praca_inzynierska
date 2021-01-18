package controllery;


import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    private Label errorEmail;

    @FXML
    private Label errorFname;

    @FXML
    private Label errorName;

    @FXML
    private Label errorLogin;

    @FXML
    private Label errorPassLen;
    @FXML
    private Label errorPassLet;

    @FXML
    private Label errorPassNum;

    @FXML
    private Label errorSpecCh;

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
            alert.setHeaderText("Rejestracja zakoñczona sukcesem! ");
            alert.setTitle(null);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(400,0);

            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {

                String adress = "/fxml/panelLogIN.fxml";
                readFXML(event, adress);
                frame(event);
            }

            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }


        }


    @FXML
    void exit(ActionEvent event) {

        ButtonType buttonYES = new ButtonType("Tak, chce");
        ButtonType buttonNO = new ButtonType("Nie, zostañ");
        String link = "/fxml/panelLogIN.fxml";
        Alert alert_exit = new Alert(Alert.AlertType.CONFIRMATION, "", buttonYES, buttonNO);
        alert_exit.setHeaderText("Czy na pewno chcesz przerwaæ rejestracjê?");
        alert_exit.setContentText(null);
        alert_exit.setTitle(null);
        DialogPane dialogPane = alert_exit.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(450,0);
        alert_exit.showAndWait();


        if (alert_exit.getResult() == buttonYES) {

            readFXML(event, link);
            frame(event);
        }
    }

    @FXML
    void howStrong(KeyEvent event) {
        String nP = passwdtxt.getText();

        Pattern hasUpper = Pattern.compile(".*[A-Z].*");
        Pattern hasLowercase = Pattern.compile(".*[a-z].*");
        Pattern hasNumber = Pattern.compile(".*[0-9].*");
        Pattern hasSpecialChar = Pattern.compile(".*[@#$%!].*");
        Pattern lenght = Pattern.compile(".{8,}");


        if (!lenght.matcher(nP).matches()) {
            errorPassLen.setText("Has³o musi zawieraæ min 8 znaków!");
            passwdtxt.setStyle("-fx-background-radius:16px; -fx-background-color:#FF4747 ");

            if (!hasLowercase.matcher(nP).matches() || !hasUpper.matcher(nP).matches())
                errorPassLet.setText("Musi posiadaæ jedn¹ wielk¹ i ma³¹ literê,");


            if (!hasNumber.matcher(nP).matches())
                errorPassNum.setText("jedn¹ cyfrê oraz");

            if (!hasSpecialChar.matcher(nP).matches())
                errorSpecCh.setText("jeden symbol specjalny.");

        }else{
            errorPassNum.setText(null);
            errorSpecCh.setText(null);
            errorPassLet.setText(null);
            errorPassLen.setText(null);
            passwdtxt.setStyle("-fx-background-radius: 16px");
        }


    }

    @FXML
    void validate(KeyEvent event) {

        // first name and name must have only letters
        Pattern letter = Pattern.compile("^[A-Za-z]+$");

        String fnameR = fnametxt.getText();
        String nameR = lnametxt.getText();

        if(letter.matcher(fnameR).matches()) {
            fnametxt.setStyle("-fx-background-radius:16px;");
            errorFname.setText(null);
        }else if(fnameR.isEmpty()){
            fnametxt.setStyle("-fx-background-radius: 16px;");
            errorFname.setText(null);
        }else{
            fnametxt.setStyle("-fx-background-radius:16px; -fx-background-color: #FF4747");
            errorFname.setText("Imiê nie mo¿e zawieraæ liczb!");

        }

        if(letter.matcher(nameR).matches()) {
            lnametxt.setStyle("-fx-background-radius: 16px");
            errorName.setText(null);
        }else if(nameR.isEmpty()){
            lnametxt.setStyle("-fx-background-radius: 16px;");
            errorName.setText(null);
        }else{
            lnametxt.setStyle("-fx-background-radius:16px;-fx-background-color: #FF4747");
            errorName.setText("Nazwisko nie mo¿e zawieraæ liczb!");
        }

        // validation for email

        Pattern email = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

        String mailR = emailtxt.getText();

        if(email.matcher(mailR).matches()) {
            emailtxt.setStyle("-fx-background-radius: 16px;");
            errorEmail.setText(null);
        }else if(mailR.isEmpty()){
            emailtxt.setStyle("-fx-background-radius: 16px");
            errorEmail.setText(null);
        }else{
            emailtxt.setStyle("-fx-background-radius: 16px; -fx-background-color:#FF4747 ");
            errorEmail.setText("Niepoprawny email!");
        }

        // validate for login

        Pattern loginUser = Pattern.compile("^[a-zA-Z0-9]{5,}$");

        String log = logintxt.getText();

        if(loginUser.matcher(log).find()) {
            logintxt.setStyle("-fx-background-radius: 16px");
            errorLogin.setText(null);

        }else if(log.isEmpty()){
            logintxt.setStyle("-fx-background-radius: 16px");
            errorLogin.setText(null);
        }else{
            logintxt.setStyle("-fx-background-radius: 16px; -fx-background-color:#FF4747");
            errorLogin.setText("Login musi zawieraæ min 5 znaki!");
        }
    }

    @FXML
    void checkTheSame(KeyEvent event) {

        String newPass = passwdtxt.getText();
        String confirmPass = conpasswdtxt.getText();

        if(confirmPass.equals(newPass)) {
            conpasswdtxt.setStyle("-fx-background-radius: 16px;");
        }else if(confirmPass.isEmpty()){
            conpasswdtxt.setStyle("-fx-background-radius: 16px;");
        }else{
            conpasswdtxt.setStyle("-fx-background-radius:16px; -fx-background-color: red;");

        }

    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }
}
