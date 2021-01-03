package controllery.panelUsers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller_Contact {

    @FXML
    private Pane contactPane;

    @FXML
    private JFXButton sendButton;

    @FXML
    private Label nameError;

    @FXML
    private Label messageError;

    @FXML
    private Label emailError;

    @FXML
    private Label topicError;

    @FXML
    private TextField nameF;

    @FXML
    private TextField mailF;

    @FXML
    private TextField topicF;

    @FXML
    private TextArea messageF;


    @FXML
    void sendEmail(ActionEvent event) throws IOException {

        String mailForm = mailF.getText();
        String topicForm = topicF.getText();
        String nameForm = nameF.getText();
        String messageForm = messageF.getText();

        if (mailForm.trim().isEmpty() || nameForm.trim().isEmpty()) {
            mailF.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 12px; " +
                    "-fx-background-radius: 12px;");
            emailError.setText("Uzupe³nij adres e-mail");
            emailError.setStyle("-fx-text-fill: #971414; -fx-font-weight: bold; -fx-alignment: center;");

        } else {
            emailError.setText(" ");
            mailF.setStyle("-fx-border-color: black; -fx-border-radius: 12px; -fx-background-radius: 12px;");
        }
        if(nameForm.trim().isEmpty()){
            nameF.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 12px; " +
                    "-fx-background-radius: 12px;");
            nameError.setText("Uzupe³nij imiê i nazwisko");
            nameError.setStyle("-fx-text-fill: #971414; -fx-font-weight: bold; -fx-alignment: center;");
        }else{
             nameError.setText(" ");
             nameF.setStyle("-fx-border-color: black; -fx-border-radius: 12px; -fx-background-radius: 12px;");
         }
        if(topicForm.trim().isEmpty()){
            topicF.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 12px; " +
                    "-fx-background-radius: 12px;");
            topicError.setText("Uzupe³nij temat wiadomoœci");
            topicError.setStyle("-fx-text-fill: #971414; -fx-font-weight: bold; -fx-alignment: center;");


        }else{
            topicError.setText(" ");
            topicF.setStyle("-fx-border-color: black; -fx-border-radius: 12px; -fx-background-radius: 12px;");
         }
        if(messageForm.trim().isEmpty()){
            messageF.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 12px; " +
                    "-fx-background-radius: 12px;");
            messageError.setText("Uzupe³nij treœæ wiadomoœci");
            messageError.setStyle("-fx-text-fill: #971414; -fx-font-weight: bold; -fx-alignment: center;");
        }else{
        messageError.setText(" ");
        messageF.setStyle("-fx-border-color: black; -fx-border-radius: 12px; -fx-background-radius: 12px;");
    }
        if(!messageForm.trim().isEmpty() && !topicForm.trim().isEmpty() &&
                !nameForm.trim().isEmpty() && !mailForm.trim().isEmpty()) {


            Alert alert_send = new Alert(Alert.AlertType.INFORMATION);
            alert_send.setContentText("Twoja wiadomoœc zosta³a wys³ana");
            alert_send.setHeaderText("");
            DialogPane dialogPane = alert_send.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            Image lettterI = new Image("@../../img/check-1-icon.png");
            ImageView imageView = new ImageView(lettterI);
            dialogPane.setGraphic(imageView);
            imageView.setFitWidth(100);
            imageView.setFitHeight(80);

            dialogPane.setMaxSize(400, 0);
            alert_send.showAndWait();

            String link = "/fxml/panelUser_type/panelContact.fxml";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller_Contact.class.getResource(link));
            Pane newPane = loader.load();
            contactPane.getChildren().add(newPane);


        }

    }



}
