package controllery;

import com.github.cage.Cage;
import com.github.cage.GCage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class openFXMl {

    Parent home;
    FXMLLoader read;
    Stage app;
    Cage cage;

    public String generate() {
        cage = new GCage();
        String token = null;
        token = cage.getTokenGenerator().next();
        return token;
    }

    String kod = generate();

    public  void obrazek() throws IOException {

        OutputStream os = new FileOutputStream("captcha.jpg", false);

        try {
            cage.draw(kod, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

    // method to open FXML

    public void readFXML (ActionEvent event, String link){

        try{
            read = new FXMLLoader(getClass().getResource(link));
            home = read.load();

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // method to create Scene

    public void frame (ActionEvent event){

        try{
            Scene homeScene = new Scene(home);
            app = (Stage) ((Node)event.getSource()).getScene().getWindow();
            app.hide();
            app.setScene(homeScene);
            app.show();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }

    public abstract void initialize(URL url, ResourceBundle rb);

}
