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
    private PasswordField newPassword;


    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label checkSame;

    @FXML
    private Label errorPassLen;

    @FXML
    private Label errorPassLet;

    @FXML
    private Label errorPassNum;

    @FXML
    private Label errorSpecCh;

    @FXML
    void changePassword(ActionEvent event) {
        String emal = mail.getText();
        String nPass = newPassword.getText();

        UzytkownikQuery userQr = new UzytkownikQuery();
        try {
            userQr.changePassword(emal, nPass);
            Alert alert_exit = new Alert(Alert.AlertType.INFORMATION);
            alert_exit.setHeaderText("Has³o zosta³o zmienione");
            alert_exit.setTitle(null);
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
            checkSame.setStyle("-fx-text-fill:#0E7B19 ");
        }else{
            checkSame.setText("Has³a sie ró¿ni¹!");
            checkSame.setStyle("-fx-text-fill: #871414");
        }

    }

    @FXML
    void exit(ActionEvent event) {

        ButtonType buttonYES = new ButtonType("Tak, chce", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Nie, zostañ", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.NONE, " ", buttonYES, buttonNO);
        String s = "Czy na pewno chcesz przerwaæ zmianê has³a?";
        alertC.setHeaderText(s);
        alertC.setTitle(null);

        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(400, 5);


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

        Pattern lenght = Pattern.compile(".{8,}");


        if (!lenght.matcher(passwr).matches()) {
            errorPassLen.setText("Has³o musi zawieraæ min 8 znaków!");
            newPassword.setStyle("-fx-background-radius:16px; -fx-background-color:#FF4747 ");

            if (!hasLowercase.matcher(passwr).matches() || !hasUpper.matcher(passwr).matches())
                errorPassLet.setText("Musi posiadaæ jedn¹ wielk¹ i ma³¹ literê,");


            if (!hasNumber.matcher(passwr).matches())
                errorPassNum.setText("jedn¹ cyfrê oraz");

            if (!hasSpecialChar.matcher(passwr).matches())
                errorSpecCh.setText("jeden symbol specjalny.");

        }else{
            errorPassNum.setText(null);
            errorSpecCh.setText(null);
            errorPassLet.setText(null);
            errorPassLen.setText(null);
            newPassword.setStyle("-fx-background-radius: 16px");
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






    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
