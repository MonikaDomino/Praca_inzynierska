package controllery.panelUsers.Company;

import com.jfoenix.controls.JFXButton;
import controllery.panelUsers.Controller_Analysis_Data;
import hibernate.Firma;
import hibernate.FirmaQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller_Company {

    @FXML
    private Pane changePaneC;

    @FXML
    private Pane paneChange;

    @FXML
    private Label nameCompany;

    @FXML
    private Label streetCompany;

    @FXML
    private Label cityCompany;

    @FXML
    private Label idCompany;

    @FXML
    private Label idUCom;

    @FXML
    private JFXButton changeDataA;


    @FXML
    private JFXButton addCompanyBtn;

    Controller_CompanyFinancial financial;
    Controller_CompanyAnalysis analysis;
    Controller_CompanyForm comForm;
    Controller_Company_ChangeAdress adresCom;

    @FXML
    void goToDataFinancial(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/Company/CompanyDataFinancial.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_Company.class.getResource(link));
        Pane newPane = loader.load();
        paneChange.getChildren().add(newPane);

        Controller_CompanyFinancial cf = loader.getController();
        financial = cf;
        cf.comboBox();

    }

    @FXML
    void goToForm(ActionEvent event) throws IOException {
        String linkF = "/fxml/panelUser_type/Company/CompanyForm.fxml";
        FXMLLoader load = new FXMLLoader();
        load.setLocation(Controller_Company.class.getResource(linkF));
        Pane loadP = load.load();
        paneChange.getChildren().add(loadP);

        Controller_CompanyForm fCom = load.getController();
        comForm = fCom;
        int idUs = Integer.parseInt(idUCom.getText());
        fCom.readIdUser(idUs);




    }

    @FXML
    void goToChangeData(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/Company/CompanyChangeAdress.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_Company.class.getResource(link));
        Pane newPane = loader.load();
        paneChange.getChildren().add(newPane);

        Controller_Company_ChangeAdress changeA = loader.getController();
        adresCom = changeA;
        int id = Integer.parseInt(idCompany.getText());
        FirmaQuery fq = new FirmaQuery();
        Firma f = fq.showCompanyData(id);
        changeA.readDataCompany(f.getNazwaFirmy(), f.getUlica(), f.getNumerBudynku(), f.getNumerLokalu(),
                f.getKodPocztowy(), f.getMiasto());
        changeA.readIdCompany(id);
    }

    @FXML
    void goToDataAnalysis(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/Company/CompanyAnalysis.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_Company.class.getResource(link));
        Pane newPane = loader.load();
        paneChange.getChildren().add(newPane);

        Controller_CompanyAnalysis analsis = loader.getController();
        analysis = analsis;
        analsis.comboBox();

    }

    public void readCompanyData(String nameC, String street, String numberBuilding, String local, String postC,
                                String city, int idUser) {

        FirmaQuery comData = new FirmaQuery();
        Firma compa = comData.showCompany(idUser);

        if (compa != null) {
            addCompanyBtn.setVisible(false);
            changeDataA.setText("ZMIEÑ DANE ADRESOWE");
            nameCompany.setText(nameC);
            if (local != " ") {
                streetCompany.setText("ul. " + street + " " + numberBuilding + "/" + local);
            } else {
                streetCompany.setText("ul. " + street + " " + numberBuilding);
            }
            cityCompany.setText(postC + " " + city);
        }
    }



    public void readIdCompany(int id){
        idCompany.setText(Integer.toString(id));
        idCompany.setVisible(false);
    }

    public void readIdUser (int idU){
        idUCom.setText(Integer.toString(idU));
        idUCom.setVisible(false);
    }

}
