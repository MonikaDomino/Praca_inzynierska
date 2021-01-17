package controllery.panelUsers.Company;


import controllery.panelUsers.Controller_Start;
import hibernate.Firma;
import hibernate.FirmaQuery;

import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


public class Controller_CompanyForm {
    @FXML
    private TextField street;

    @FXML
    private Pane allPane;

    @FXML
    private TextField nameCompanytxt;

    @FXML
    private TextField numberB;

    @FXML
    private TextField postCode;

    @FXML
    private TextField city;

    @FXML
    private Pane changeCF;

    @FXML
    private TextField numberF;

    @FXML
    private Label idUserForm;

    Controller_Start compData;
    @FXML
    void addCompany(ActionEvent event) {

        String nameCompany = nameCompanytxt.getText();
        String streetCompany = street.getText();
        String numberBuilding = numberB.getText();
        String numberLocal = numberF.getText();
        String postC = postCode.getText();
        String cityC = city.getText();
        int idUser = Integer.parseInt(idUserForm.getText());


        try{
            FirmaQuery company = new FirmaQuery();
            company.addCompany(nameCompany,streetCompany,cityC, postC,numberBuilding,numberLocal,idUser);
            Firma comF = company.showIdCompany(nameCompany, streetCompany, numberBuilding, numberLocal,postC, cityC, idUser);

            int id = comF.getIdFirmy();



            Alert alert_correct = new Alert(Alert.AlertType.INFORMATION);
            alert_correct.setHeaderText("Firma zosta³a dodana ");
            DialogPane dialogPane = alert_correct.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(400,0);

            alert_correct.showAndWait();

            String link = "/fxml/panelUser_type/panelStart.fxml";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller_CompanyForm.class.getResource(link));
            Pane newPane = loader.load();
            allPane.getChildren().add(newPane);

            Controller_Start start = loader.getController();

            compData = start;
            UzytkownikQuery usq = new UzytkownikQuery();
            Uzytkownik u = usq.showData(idUser);
            start.readLabel(u.getImie(), u.getNazwisko());



        }catch (Exception e){
            e.getLocalizedMessage();
        }



    }

    public void readIdUser(int id){
        idUserForm.setText(Integer.toString(id));
        idUserForm.setVisible(false);
    }

    public void readPane(Pane pt){
        allPane = pt;
    }



}
