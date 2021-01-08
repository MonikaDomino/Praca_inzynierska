package controllery.panelUsers.Company;

import com.jfoenix.controls.JFXTextField;
import hibernate.FirmaQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
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

        String nameC = nameCchange.getText();
        String streetC = streetCchange.getText();
        String nBuild = numerBCch.getText();
        String nLocal = numberFCch.getText();
        String city = cityChc.getText();
        String postcode = postCodeCh.getText();

        int idCom = Integer.parseInt(idCompany.getText());

        try{
            FirmaQuery company = new FirmaQuery();
            company.changeAddress(nameC, streetC, nBuild, city, postcode, nLocal, idCom);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dane firmy zosta³y zaktualizowane");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(400,0);

            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readDataCompany(String name, String street, String nB, String nF, String postCode, String city){
        nameCchange.setText(name);
        streetCchange.setText(street);
        numerBCch.setText(nB);
        numberFCch.setText(nF);
        postCodeCh.setText(postCode);
        cityChc.setText(city);
    }

    public void readIdCompany (int id){
        idCompany.setText(Integer.toString(id));
        idCompany.setVisible(false);
    }
}
