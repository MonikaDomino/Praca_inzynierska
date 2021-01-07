package controllery;


import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Controller_Pass extends openFXMl{

    @FXML
    private TextField mail;


    @FXML
    private AnchorPane panePF;

    @FXML
    private ProgressIndicator checkEmail;

    @FXML
    private ProgressBar securityCheck;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Label strongPass;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label checkSame;

    @FXML
    void changePassword(ActionEvent event) {
        String emal = mail.getText();
        String nPass = newPassword.getText();

        UzytkownikQuery userQr = new UzytkownikQuery();
        try {
            userQr.changePassword(emal, nPass);
            Alert alert_exit = new Alert(Alert.AlertType.INFORMATION);
            alert_exit.setHeaderText("Has³o zosta³o zmienione");
            DialogPane dialogPane = alert_exit.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(280, 0);
            alert_exit.showAndWait();

            String link = "/fxml/panelLogIN.fxml";
            readFXML(event,link);
            frame(event);

        }catch (Exception e){
            e.getLocalizedMessage();
        }


    }

    @FXML
    void checkTheSame(KeyEvent event) {

        String nPass = newPassword.getText();
        String confimPass = confirmPassword.getText();

        if(nPass.equals(confimPass)){
            checkSame.setText("Has³a s¹ takie same!");
            checkSame.setTextFill(Color.GREEN);
        }else{
            checkSame.setText("Has³a sie ró¿ni¹!");
            checkSame.setTextFill(Color.RED);
        }

    }

    @FXML
    void exit(ActionEvent event) {

        ButtonType buttonYES = new ButtonType("Tak, chce", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Nie, zostañ", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.NONE, " ", buttonYES, buttonNO);
        String s = "Czy na pewno chcesz przerwaæ?";
        alertC.setHeaderText(s);


        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(350, 5);


        alertC.setTitle(" ");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.orElse(buttonNO) == buttonYES) {

            String linkC = "/fxml/panelLogIN.fxml";
            readFXML(event, linkC);
            frame(event);
        }
    }
    @FXML
    void howStrong(KeyEvent event) {

        securityCheck.setVisible(true);

        String passwr;
               passwr = newPassword.getText();

         Pattern hasUpper;
               hasUpper = Pattern.compile(".*[A-Z].*");
         Pattern hasLowercase ;
               hasLowercase = Pattern.compile(".*[a-z].*");
         Pattern hasNumber;
                hasNumber= Pattern.compile(".*[0-9].*");
         Pattern hasSpecialChar;
        hasSpecialChar= Pattern.compile(".*[@#$%!].*");

        int sizePass = passwr.length();

        if(sizePass < 6){
            strongPass.setText("Bardzo s³abe");
            securityCheck.setProgress(0.05);
            securityCheck.setStyle("-fx-accent: red;");
            securityCheck.setProgress(0);


        }
        if (passwr.length() >= 6 || hasLowercase.matcher(passwr).find()) {
            strongPass.setText("Bardzo s³abe");
            securityCheck.setProgress(0.05);
            securityCheck.setStyle("-fx-accent: red;");

            //  tipsPassword.setText("Minimum jedna wielka litera");
            // tipsPassword.setTextFill(Color.GREEN);

            if (hasUpper.matcher(passwr).find()) {
                strongPass.setText("S³abo");
                securityCheck.setProgress(0.5);
                securityCheck.setStyle("-fx-accent: #0027c1");
                // tipsPassword.setText("Minimum jedna cyfra");

            }

            if (hasNumber.matcher(passwr).find()) {
                strongPass.setText("Dobre");
                securityCheck.setProgress(0.75);
                securityCheck.setStyle("-fx-accent: #24d160");


            }


            if (hasSpecialChar.matcher(passwr).find()) {
                strongPass.setText("Silne");
                securityCheck.setStyle("-fx-accent: #098534");
                securityCheck.setProgress(1);
            }
        }


    }

    @FXML
    void searchInDatabase(KeyEvent event) {

        String sEmail = mail.getText();

        try {
            UzytkownikQuery uq = new UzytkownikQuery();
            Uzytkownik user = uq.searchEmail(sEmail);

            final Text text = (Text) checkEmail.lookup(".percentage");
            if (user != null) {

                checkEmail.progressProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number t, Number newValue) {
                        // If progress is 100% then show Text
                        if (newValue.doubleValue() >= 1) {
                            // This text replaces "Done"
                            text.setText(" ");
                        }
                    }
                });
                checkEmail.setProgress(1);
                checkEmail.setStyle("-fx-progress-color: green");

            }

        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }

    public void hidden(){
        securityCheck.setVisible(false);
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
