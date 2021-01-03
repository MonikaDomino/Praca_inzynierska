package controllery.panelUsers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_Start {

    @FXML
    private Label welcome;

    public void readLabel(String imie, String nazwisko){
        welcome.setText("Witaj, " +imie+ " " + nazwisko + "!" );
    }


}
