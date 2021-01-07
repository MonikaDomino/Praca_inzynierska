package controllery.panelUsers;

import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

public class Controller_ChangeCPass {

    @FXML
    private Pane changePpane;

    @FXML
    private PasswordField currentPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label correctStatus;

    @FXML
    private Label checkSecurity;

    @FXML
    private ProgressBar progressPassword;


    @FXML
    private Label idCP;

    @FXML
    private ProgressIndicator progresSearch;

    public Controller_Start startCCP;

    @FXML
    void cancel(ActionEvent event) throws IOException {

        ButtonType buttonYES = new ButtonType("Tak, chce", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Nie, zostañ", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.NONE, " ", buttonYES,buttonNO);
        String s = "Czy na pewno chcesz przerwaæ?";
        alertC.setHeaderText(s);


        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(350, 5);


        alertC.setTitle(" ");
        Optional<ButtonType> result = alertC.showAndWait();

    if(result.orElse(buttonNO) == buttonYES) {

        String linkC = "/fxml/panelUser_type/panelStart.fxml";
        FXMLLoader loaderCancel = new FXMLLoader();
        loaderCancel.setLocation(Controller_ChangeCPass.class.getResource(linkC));
        Pane newLoadPane = loaderCancel.load();
        changePpane.getChildren().add(newLoadPane);

        Controller_Start CNstart = loaderCancel.getController();

        startCCP= CNstart;
        int id = Integer.parseInt(idCP.getText());
        UzytkownikQuery userP = new UzytkownikQuery();
        Uzytkownik userCP = userP.showData(id);
        CNstart.readLabel(userCP.getImie(), userCP.getNazwisko());


    }

    }

    // method to check how strong is password
    @FXML
    void howStrong(KeyEvent event) {

        progressPassword.setVisible(true);
        String nPass = newPassword.getText();

        final Pattern hasUppercase = Pattern.compile(".*[A-Z].*");
        final Pattern hasLowercase = Pattern.compile(".*[a-z].*");
        final Pattern hasNumber = Pattern.compile(".*[0-9].*");
        final Pattern hasSpecialChar = Pattern.compile(".*[@#$%!].*");


        if(nPass.length() < 6){
            checkSecurity.setText("Bardzo s³abe");
            progressPassword.setProgress(0.05);
            progressPassword.setStyle("-fx-accent: red;");
            progressPassword.setProgress(0);


        }
        if (nPass.length() >= 6 || hasLowercase.matcher(nPass).find()) {
            checkSecurity.setText("Bardzo s³abe");
            progressPassword.setProgress(0.05);
            progressPassword.setStyle("-fx-accent: red;");

          //  tipsPassword.setText("Minimum jedna wielka litera");
           // tipsPassword.setTextFill(Color.GREEN);

            if (hasUppercase.matcher(nPass).find()) {
                checkSecurity.setText("S³abo");
                progressPassword.setProgress(0.5);
                progressPassword.setStyle("-fx-accent: #0027c1");
               // tipsPassword.setText("Minimum jedna cyfra");

            }

            if (hasNumber.matcher(nPass).find()) {
                checkSecurity.setText("Dobre");
                progressPassword.setProgress(0.75);
                progressPassword.setStyle("-fx-accent: #24d160");


            }


            if (hasSpecialChar.matcher(nPass).find()) {
                checkSecurity.setText("Silne");
                progressPassword.setStyle("-fx-accent: #098534");
                progressPassword.setProgress(1);
            }
        }

    }

    @FXML
    void checkIsTheSame(KeyEvent event) {
        String nPassword = newPassword.getText();
        String repeatPassword = confirmPassword.getText();

        if(nPassword.equals(repeatPassword)){
            correctStatus.setText("Has³a s¹ takie same");
            correctStatus.setTextFill(Color.GREEN);
        }else{
            correctStatus.setText("Has³a siê ró¿ni¹!");
            correctStatus.setTextFill(Color.RED);
        }

    }

    public void readId (int id){

        idCP.setText(Integer.toString(id));
        idCP.setVisible(false);

    }

    private static UzytkownikQuery user = new UzytkownikQuery();

    @FXML
    void changePassword(ActionEvent event) {

        String currentPass= currentPassword.getText();
        String nPassword = newPassword.getText();

        int idUser = Integer.parseInt(idCP.getText());

        try{
            user.changePasswordUser(currentPass,nPassword,idUser);
            Alert alert_exit = new Alert(Alert.AlertType.INFORMATION);
            alert_exit.setHeaderText("Has³o zosta³o zmienione");
            DialogPane dialogPane = alert_exit.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(280,0);
            alert_exit.showAndWait();

            String linkS = "/fxml/panelUser_type/panelStart.fxml";
            FXMLLoader loaderCp= new FXMLLoader();
            loaderCp.setLocation(Controller_ChangeCPass.class.getResource(linkS));
            Pane newPane = loaderCp.load();
            changePpane.getChildren().add(newPane);
            Controller_Start CPstart = loaderCp.getController();

            startCCP= CPstart;
            int id = Integer.parseInt(idCP.getText());
            UzytkownikQuery userP = new UzytkownikQuery();
            Uzytkownik userCP = userP.showData(id);
            CPstart.readLabel(userCP.getImie(), userCP.getNazwisko());





        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void hidden () {
        progressPassword.setVisible(false);
    }




    @FXML
    void searchInDatabase(KeyEvent event) {

        int idUser = Integer.parseInt(idCP.getText());

        String currentPword = currentPassword.getText();



        try {
            Uzytkownik us;
            us = user.searchPassword(currentPword,idUser);
            final Text text = (Text) progresSearch.lookup(".percentage");
            if(us != null) {

                progresSearch.progressProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number t, Number newValue) {
                        // If progress is 100% then show Text
                        if (newValue.doubleValue() >= 1) {
                            // This text replaces "Done"
                            text.setText(" ");
                        }
                    }
                });
                progresSearch.setProgress(1);
                progresSearch.setStyle("-fx-progress-color: green");

            }

        } catch (Exception e) {
                e.getLocalizedMessage();
        }

    }}







