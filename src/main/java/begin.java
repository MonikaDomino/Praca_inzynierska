
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;



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



    }
}
