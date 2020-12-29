package controllery.panelUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        }
        if (nPass.length() >= 6 || hasLowercase.matcher(nPass).find()) {
            checkSecurity.setText("Bardzo s³abe");
            progressPassword.setProgress(0);
            tipsPassword.setText("Minimum jedna wielka litera");

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
    void changePassword(ActionEvent event) {

        String nPassword = newPassword.getText();
        String repeatPassword = confirmPassword.getText();


        // check passwords is the same

        if (!repeatPassword.equals(nPassword)) {
            correctStatus.setTextFill(Color.rgb(164, 18, 18));
            correctStatus.setText("Has³a nie s¹ takie same!");
        } else if (repeatPassword.equals("")) {
            correctStatus.setText("");

        } else {
            correctStatus.setTextFill(Color.rgb(60, 153, 22));
            correctStatus.setText("Has³a s¹ zgodne!");
        }

    }
}








