package controllery;

import controllery.panelUsers.Company.Controller_CompanyData;
import controllery.panelUsers.Controller_AnalysisType;
import controllery.panelUsers.Controller_PersonalData;
import hibernate.Firma;
import hibernate.FirmaQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_User extends openFXMl {



    @FXML
    private Pane pane;
    @FXML
    private BorderPane border;

    @FXML
    private Pane changePane;

    @FXML
    private Label dataId;

    @FXML
    private Label fnameU;

    @FXML
    private Label nameU;

    @FXML
    private Label mailU;

    @FXML
    private Label companyID;

    @FXML
    private Label idCompanyData;

    public  Controller_PersonalData date;

    public Controller_CompanyData formC;

    public Controller_AnalysisType analType;


    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }



    @FXML
    void goToContact(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelContact.fxml"));
        changePane.getChildren().add(newLoadPane);

    }


    @FXML
    void backToStart(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelStart.fxml"));
        changePane.getChildren().add(newLoadPane);
    }

    @FXML
    void goToCompanyData(ActionEvent event) throws  IOException {

        String link = "/fxml/panelUser_type/Company/panelCompany.fxml";
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);

        Controller_CompanyData companyData = loader.getController();
        formC = companyData;
        int id = Integer.parseInt(dataId.getText());
        companyData.readIdUser(id);

        FirmaQuery company = new FirmaQuery();
        Firma com = company.showCompany(id);
        companyData.readIdCompany(com.getIdFirmy());
        companyData.readDataCompany(com.getNazwaFirmy(), com.getUlica(), com.getNumerBudynku(), com.getNumerLokalu(), com.getMiasto(), com.getKodPocztowy());


    }


    @FXML
    void goToPersonalData(ActionEvent event) throws IOException {

        String link = "/fxml/panelUser_type/panelPersonalData.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newLoadPane = loader.load();

        changePane.getChildren().add(newLoadPane);

        Controller_PersonalData persona = loader.getController();
        date = persona;
        int id = Integer.parseInt(dataId.getText());
        persona.readId(id);
        String fnameUser = fnameU.getText();
        String nameUser = nameU.getText();
        String mailUser = mailU.getText();
        persona.readData(fnameUser, nameUser, mailUser);




    }



    @FXML
    void goToAnalysisType(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/panelAnalysis_Type.fxml";
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);

        Controller_AnalysisType analize = loader.getController();
        analType = analize;
        int id = Integer.parseInt(dataId.getText());


        FirmaQuery company = new FirmaQuery();
        Firma com = company.showCompany(id);
        analize.readIdCompany(com.getIdFirmy());


    }

    public void readIdUser(int id){
        dataId.setText(Integer.toString(id));
        dataId.setVisible(false);
    }



    public void readInfoUser (String fname, String name, String mail){
        fnameU.setText(fname);
        fnameU.setVisible(false);
        nameU.setText(name);
        nameU.setVisible(false);
        mailU.setText(mail);
        mailU.setVisible(false);

    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {




    }
}