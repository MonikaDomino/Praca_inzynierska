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
    private ProgressBar strongPass;

    @FXML
    private Label checkSecurity;

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
        DialogPane dialogPane = alert_exit.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(450,0);;
        alert_exit.showAndWait();


        if (alert_exit.getResult() == buttonYES) {

            readFXML(event, link);
            frame(event);
        }
    }

    @FXML
    void howStrong(KeyEvent event) {
        strongPass.setVisible(true);
        String nP = passwdtxt.getText();

       Pattern hasUpper = Pattern.compile(".*[A-Z].*");
       Pattern hasLowercase = Pattern.compile(".*[a-z].*");
       Pattern hasNumber = Pattern.compile(".*[0-9].*");
       Pattern hasSpecialChar = Pattern.compile(".*[@#$%!].*");

        int len = nP.length();

        if(len< 6){
            checkSecurity.setText("Bardzo s³abe");
            strongPass.setProgress(0.05);
            strongPass.setStyle("-fx-accent: red;");
            strongPass.setProgress(0);

        }
        if (len>= 6 || hasLowercase.matcher(nP).find()) {
            checkSecurity.setText("Bardzo s³abe");
            strongPass.setProgress(0.05);
            strongPass.setStyle("-fx-accent: red;");



            if (hasUpper.matcher(nP).find()) {
                checkSecurity.setText("S³abo");
                strongPass.setProgress(0.5);
                strongPass.setStyle("-fx-accent: #0027c1");

            }

            if (hasNumber.matcher(nP).find()) {
                checkSecurity.setText("Dobre");
                strongPass.setProgress(0.75);
                strongPass.setStyle("-fx-accent: #24d160");


            }


            if (hasSpecialChar.matcher(nP).find()) {
                checkSecurity.setText("Silne");
                strongPass.setStyle("-fx-accent: #098534");
                strongPass.setProgress(1);
            }
        }



    }

    @FXML
    void validate(KeyEvent event) {

        // first name and name must begin for upper letter
        Pattern letter = Pattern.compile("(.*[A-Z].*)(.*[a-z].*)");

        String fnameR = fnametxt.getText();
        String nameR = lnametxt.getText();

        if(letter.matcher(fnameR).matches()) {
            fnametxt.setStyle("-fx-background-radius:16px;");
        }else if(fnameR.isEmpty()){
            fnametxt.setStyle("-fx-background-radius: 16px;");
        }else{
            fnametxt.setStyle("-fx-background-radius:16px; -fx-background-color: #FF4747");
        }

        if(letter.matcher(nameR).matches()) {
            lnametxt.setStyle("-fx-background-radius: 16px");
        }else if(nameR.isEmpty()){
            lnametxt.setStyle("-fx-background-radius: 16px;");
        }else{
            lnametxt.setStyle("-fx-background-radius:16px;-fx-background-color: #FF4747");
        }

        // validation for email

        Pattern email = Pattern.compile("[A-Za-z0-9+_.]+@[a-z]+.[a-z]{2,}");

        String mailR = emailtxt.getText();

        if(email.matcher(mailR).matches()) {
            emailtxt.setStyle("-fx-background-radius: 16px;");
        }else if(mailR.isEmpty()){
            emailtxt.setStyle("-fx-background-radius: 16px");
        }else{
            emailtxt.setStyle("-fx-background-radius: 16px; -fx-background-color:#FF4747 ");
        }

        // validate for login

        Pattern loginUser = Pattern.compile("[A-Za-z0-9]");

        String log = logintxt.getText();

        if(loginUser.matcher(log).find()) {
            logintxt.setStyle("-fx-background-radius: 16px");
        }else if(log.isEmpty()){
            logintxt.setStyle("-fx-background-radius: 16px");
        }else{
            logintxt.setStyle("-fx-background-radius: 16px; -fx-background-color:#FF4747");
        }
    }

    @FXML
    void checkTheSame(KeyEvent event) {

        String newPass = passwdtxt.getText();
        String confirmPass = conpasswdtxt.getText();

        if(confirmPass.equals(newPass)) {
            conpasswdtxt.setStyle("-fx-background-radius: 16px;-fx-background-color: #7BCE7D;");
        }else if(confirmPass.isEmpty()){
            conpasswdtxt.setStyle("-fx-background-radius: 16px;");
        }else{
            conpasswdtxt.setStyle("-fx-background-radius:16px; -fx-background-color: red;");

        }

    }

    public void hidden (){
        strongPass.setVisible(false);
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }
}
