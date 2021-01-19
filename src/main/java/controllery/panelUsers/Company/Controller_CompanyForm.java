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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.regex.Pattern;


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
    private Label postCerror;

    @FXML
    private TextField numberF;

    @FXML
    private Label idUserForm;

    @FXML
    private Label cityError;

    @FXML
    private Label streetError;

    @FXML
    private Label buildingError;

    @FXML
    private Label localError;


    Controller_Start compData;

    @FXML
    void addCompany(ActionEvent event) throws IOException {

        String nameCompany = nameCompanytxt.getText();
        String streetCompany = street.getText();
        String numberBuilding = numberB.getText();
        String numberLocal = numberF.getText();
        String postC = postCode.getText();
        String cityC = city.getText();
       int idUser = Integer.parseInt(idUserForm.getText());


        try{
            FirmaQuery company = new FirmaQuery();

            Firma com =company.showIdCompany(nameCompany, streetCompany, cityC, postC, numberBuilding, numberLocal);

            if(com == null){
                company.addCompany(nameCompany, streetCompany, cityC, postC, numberBuilding, numberLocal);
            }
            int idComa = com.getIdFirmy();
                UzytkownikQuery usq = new UzytkownikQuery();
                //usq.addCompany(,idComa);




                Alert alert_correct = new Alert(Alert.AlertType.INFORMATION);
                alert_correct.setHeaderText("Przedsiêbiorstwo zosta³o dodane do bazy! ");
                DialogPane dialogPane = alert_correct.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/fxml/alert.css").toExternalForm());
                dialogPane.getStyleClass().add("myAlerts");
                dialogPane.setMaxSize(400, 0);

                alert_correct.showAndWait();

                String link = "/fxml/panelUser_type/panelStart.fxml";
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Controller_CompanyForm.class.getResource(link));
                Pane newPane = loader.load();
                allPane.getChildren().add(newPane);

                Controller_Start start = loader.getController();

                compData = start;
                //UzytkownikQuery usq = new UzytkownikQuery();
               // Uzytkownik u = usq.showData(idUser);
                //start.readLabel(u.getImie(), u.getNazwisko());



        }catch (Exception e){
            e.getLocalizedMessage();
        }

    }

    @FXML
    void validate(KeyEvent event) {

        Pattern postcodeP = Pattern.compile("^\\d{2}(?:-\\d{3}$)");
        Pattern citySP = Pattern.compile("[^\\W\\d_]$");
        Pattern numberBP = Pattern.compile("^[A-Za-z0-9 ]+$");

        Pattern numberLP = Pattern.compile("^[0-9]*$");

        String post = postCode.getText();
        String cities = city.getText();
        String stree = street.getText();
        String numberBuld = numberB.getText();
        String numberLocal = numberF.getText();

        if(postcodeP.matcher(post).matches()){
            postCode.setStyle("-fx-background-radius: 16px");
            postCerror.setText(null);
        }else if(post.trim().isEmpty()){
            postCode.setStyle("-fx-background-radius: 16px");
            postCerror.setText(null);
        }else{
            postCode.setStyle("-fx-background-radius: 16px; -fx-background-color: #E15656");
            postCerror.setText("Niepoprawny kod pocztowy");
            postCerror.setStyle("-fx-text-fill:  #9C0E0E; -fx-font-weight: bold");
        }

        if(citySP.matcher(cities).find()){
            city.setStyle("-fx-background-radius: 16px");
            cityError.setText(null);
        }else if(cities.trim().isEmpty()){
            city.setStyle("-fx-background-radius: 16px");
            cityError.setText(null);
        }else {
            city.setStyle("-fx-background-radius: 16px; -fx-background-color: #E15656");
            cityError.setText("Miasto nie mo¿e zawieraæ cyfr ani znaków specjalnych");
            cityError.setStyle("-fx-text-fill:  #9C0E0E; -fx-font-weight: bold");

        }

        if(numberLP.matcher(numberLocal).matches()){
            numberF.setStyle("-fx-background-radius: 16px");
            localError.setText(null);
        }else if(numberLocal.trim().isEmpty()){
            numberF.setStyle("-fx-background-radius: 16px");
            localError.setText(null);
        }else {
            numberF.setStyle("-fx-background-radius: 16px; -fx-background-color: #E15656");
            localError.setText("Tylko cyfry");
            localError.setStyle("-fx-text-fill:  #9C0E0E; -fx-font-weight: bold");
        }

        if(numberBP.matcher(numberBuld).matches()){
            numberB.setStyle("-fx-background-radius: 16px");
            buildingError.setText(null);
        }else if(numberBuld.trim().isEmpty()){
            numberB.setStyle("-fx-background-radius: 16px");
            buildingError.setText(null);
        }else {
            numberB.setStyle("-fx-background-radius: 16px; -fx-background-color: #E15656");
            buildingError.setText("Bez znaków specjalnych");
            buildingError.setStyle("-fx-text-fill:  #9C0E0E; -fx-font-weight: bold");
        }

        if(citySP.matcher(stree).find()){
            street.setStyle("-fx-background-radius: 16px");
            streetError.setText(null);
        }else if(stree.trim().isEmpty()){
            street.setStyle("-fx-background-radius: 16px");
            streetError.setText(null);
        }else {
            street.setStyle("-fx-background-radius: 16px; -fx-background-color: #E15656");
            streetError.setText("Bez znaków specjalnych");
            streetError.setStyle("-fx-text-fill:  #9C0E0E; -fx-font-weight: bold");
        }


    }

    public void readIdUser(int id){
        idUserForm.setText(Integer.toString(id));
      //  idUserForm.setVisible(false);
    }

    public void readPane(Pane pt){
        allPane = pt;
    }



}
