
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.IOException;
import java.util.Optional;


public class begin extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        try{
           Parent root= FXMLLoader.load(getClass().getResource("/fxml/firstWindow.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            primaryStage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {

                ButtonType buttonYES = new ButtonType("Zakoñcz");
                ButtonType buttonNO = new ButtonType("Anuluj");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", buttonYES, buttonNO);
                alert.setHeaderText("Chcesz zakoñczyæ pracê z aplikacj¹? ");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/fxml/alert.css").toExternalForm());
                dialogPane.getStyleClass().add("myAlerts");
                dialogPane.setMaxSize(400, 0);
                alert.setTitle("");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonYES) {
                    Platform.exit();

                } else {
                    e.consume();
                }

            }
        });



    }
}
