package controllery.panelUsers;

import controllery.Controller_User;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
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
    private Label tipsPassword;

    @FXML
    private Label idCP;




    @FXML
    void cancel(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_ChangeCPass.class.getResource(link));
        Pane newLoadPane = loader.load();
        changePpane.getChildren().add(newLoadPane);

    }

    // method to check how strong is password
    @FXML
    void howStrong(KeyEvent event) {
        String nPass = newPassword.getText();

        final Pattern hasUppercase = Pattern.compile(".*[A-Z].*");
        final Pattern hasLowercase = Pattern.compile(".*[a-z].*");
        final Pattern hasNumber = Pattern.compile(".*[0-9].*");
        final Pattern hasSpecialChar = Pattern.compile(".*[@#$%!].*");

        if(nPass.length() < 6){
            checkSecurity.setText("Bardzo s³abe");
            progressPassword.setProgress(0);
            tipsPassword.setText("Minimum 6 znaków");
            tipsPassword.setTextFill(Color.RED);
            progressPassword.setProgress(0);


        }
        if (nPass.length() >= 6 || hasLowercase.matcher(nPass).find()) {
            checkSecurity.setText("Bardzo s³abe");
            progressPassword.setProgress(0);
            tipsPassword.setText("Minimum jedna wielka litera");
            tipsPassword.setTextFill(Color.GREEN);

            if (hasUppercase.matcher(nPass).find()) {
                checkSecurity.setText("S³abo");
                progressPassword.setProgress(0.5);
                tipsPassword.setText("Minimum jedna cyfra");

            }

            if (hasNumber.matcher(nPass).find()) {
                checkSecurity.setText("Dobre");
                progressPassword.setProgress(0.75);
                tipsPassword.setText("Minimum jeden znak specjalny ");

            }


            if (hasSpecialChar.matcher(nPass).find()) {
                checkSecurity.setText("Silne");
                progressPassword.setProgress(1);
                tipsPassword.setText(" ");

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
            correctStatus.setText("Has³a nie s¹ takie same!");
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
            alert_exit.showAndWait();

            String link = "/fxml/panelUser_type/panelStart.fxml";
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(Controller_ChangeCPass.class.getResource(link));
            Pane newPane = loader.load();
            changePpane.getChildren().add(newPane);



        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }




    }
}








