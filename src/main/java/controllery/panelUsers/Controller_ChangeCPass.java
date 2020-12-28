package controllery.panelUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

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
    void cancel(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_ChangeCPass.class.getResource(link));
        Pane newLoadPane = loader.load();
        changePpane.getChildren().add(newLoadPane);


    }

    @FXML
    void changePassword(ActionEvent event) {

        String nPassword = newPassword.getText();
        String repeatPassword = confirmPassword.getText();


        if (nPassword.length() < 4) {
            progressPassword.setProgress(0);
            checkSecurity.setText("Zbyt krótkie has³o");
            checkSecurity.setTextFill(Color.rgb(164, 18, 18));
        } else if (nPassword.length() >= 4 && nPassword.length() < 6) {
            progressPassword.setProgress(0.2);
            checkSecurity.setText("Bardzo s³abe has³o");
            checkSecurity.setTextFill(Color.valueOf("#162499"));

        } else if (nPassword.length() >= 6 && nPassword.length() < 8) {
            progressPassword.setProgress(0.4);
            checkSecurity.setText("S³abe has³o");
        } else if (nPassword.length() >= 8 && nPassword.length() < 9){
            progressPassword.setProgress(0.7);
            checkSecurity.setText("Dobre has³o");
    } else if (nPassword.length() >= 9 && nPassword.length() < 10){
            progressPassword.setProgress(0.9);
            checkSecurity.setText("Silne has³o");
        }else{
            progressPassword.setProgress(1);
            checkSecurity.setText("Bardzo silne has³o");
        }


    // check passwords is the same

        if(!repeatPassword.equals(nPassword))

    {
        correctStatus.setTextFill(Color.rgb(164, 18, 18));
        correctStatus.setText("Has³a nie s¹ takie same!");
    }
            else if(repeatPassword.equals(""))

    {
        correctStatus.setText("");

    }else

    {
        correctStatus.setTextFill(Color.rgb(60, 153, 22));
        correctStatus.setText("Has³a s¹ zgodne!");
    }










    }
}
