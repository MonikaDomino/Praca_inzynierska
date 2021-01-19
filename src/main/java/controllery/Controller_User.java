package controllery;

import controllery.panelUsers.Company.Controller_Company;
import controllery.panelUsers.Controller_Analysis_Data;
import controllery.panelUsers.Controller_PersonalData;
import controllery.panelUsers.Controller_Start;
import hibernate.Firma;
import hibernate.FirmaQuery;
import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
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

    @FXML
    private Label welcome;

    public Controller_PersonalData date;

    public Controller_Company formC;

    public Controller_Analysis_Data analType;

    public Controller_Start start;


    @FXML
    void logOut(ActionEvent event) {
        String link = "/fxml/panelLogIN.fxml";
        readFXML(event, link);
        frame(event);

    }


    @FXML
    void goToContact(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/panelContact.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);


    }


    @FXML
    void backToStart(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/panelStart.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);
        Controller_Start startB = loader.getController();
        start = startB;
        int id = Integer.parseInt(dataId.getText());
        UzytkownikQuery userQ = new UzytkownikQuery();
        Uzytkownik userBS = userQ.showData(id);
        startB.readLabel(userBS.getImie(), userBS.getNazwisko());


    }

    @FXML
    void goToCompanyData(ActionEvent event) throws IOException {

        String link = "/fxml/panelUser_type/Company/Company.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);

        Controller_Company companyData = loader.getController();
        formC = companyData;
        int id = Integer.parseInt(dataId.getText());

        UzytkownikQuery user = new UzytkownikQuery();
        Uzytkownik us = user.showData(id);

        companyData.getChangePaneC(this.changePane);

     if(us.getIdFirmy() != null){
        companyData.readIdCompany(us.getIdFirmy());
        int idF = us.getIdFirmy();
        FirmaQuery fq = new FirmaQuery();
        Firma f = fq.showCompanyData(idF);
        companyData.readCompanyData(f.getNazwaFirmy(), f.getUlica(), f.getNumerBudynku(), f.getNumerLokalu(),
                f.getMiasto(), f.getKodPocztowy(), idF);
        companyData.readIdCAR(idF);
        companyData.readIDu(idF);
        companyData.readIdUser(id);
    }
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

        int idU = Integer.parseInt(dataId.getText());
        FirmaQuery company = new FirmaQuery();


        String link = "/fxml/panelUser_type/panelAnalysis_Data.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_User.class.getResource(link));
        Pane newPane = loader.load();
        changePane.getChildren().add(newPane);

        Controller_Analysis_Data analize = loader.getController();
        analType = analize;
       // analize.readIDUser(idU);
        UzytkownikQuery usq = new UzytkownikQuery();
        Uzytkownik u = usq.showData(idU);

        int idCom = u.getIdFirmy();
        FirmaQuery fcom = new FirmaQuery();
        Firma com = fcom.showCompanyData(idCom);

        if(com == null) {
            analize.showAlert();
        }else {
            analize.readIDCompany(com.getIdFirmy());
        }

    }

    public void readIdUser(int id) {
        dataId.setText(Integer.toString(id));
        dataId.setVisible(false);
    }

    public void readInfoUser(String fname, String name, String mail) {
        fnameU.setText(fname);
        fnameU.setVisible(false);
        nameU.setText(name);
        nameU.setVisible(false);
        mailU.setText(mail);
        mailU.setVisible(false);

    }

    public void readLabel(String imie, String nazwisko) {
        welcome.setText("Witaj, " + imie + " " + nazwisko + "!");
    }

    public void showAlert (){

        Alert alertC = new Alert(Alert.AlertType.INFORMATION);
        String s = "Dodaj dane o firmie w zak³adce FIRMA!";
        alertC.setHeaderText(s);
        alertC.setContentText(null);
        alertC.setTitle(null);
        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(450,0);;
        alertC.showAndWait();


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }


}