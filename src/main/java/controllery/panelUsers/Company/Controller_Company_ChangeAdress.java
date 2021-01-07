package controllery.panelUsers.Company;

import com.jfoenix.controls.JFXTextField;
import hibernate.FirmaQuery;
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

        String nameC = nameCchange.getText();
        String streetC = streetCchange.getText();
        String nBuild = numerBCch.getText();
        String nLocal = numberFCch.getText();
        String city = cityChc.getText();
        String postcode = postCodeCh.getText();

        int idCom = Integer.parseInt(idCompany.getText());

        try{
            FirmaQuery company = new FirmaQuery();
            company.changeAddress(idCom, nameC, city, streetC,nBuild, nLocal,postcode);
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
