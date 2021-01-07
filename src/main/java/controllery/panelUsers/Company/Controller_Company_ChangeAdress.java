package controllery.panelUsers.Company;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_Company_ChangeAdress {

    @FXML
    private Label idCompany;

    @FXML
    private JFXTextField nameCchange;

    @FXML
    private JFXTextField streetCchange;

    @FXML
    private JFXTextField numerBCch;

    @FXML
    private JFXTextField numberFCch;

    @FXML
    private JFXTextField postCodeCh;

    @FXML
    private JFXTextField cityChc;

    @FXML
    void changeDataCompany(ActionEvent event) {

    }

    public void readDataCompany(String name, String street, String nB, String nF, String postCode, String city){
        nameCchange.setText(name);
        streetCchange.setText(street);
        numerBCch.setText(nB);
        numberFCch.setText(nF);
        postCodeCh.setText(postCode);
        cityChc.setText(city);
    }
}
