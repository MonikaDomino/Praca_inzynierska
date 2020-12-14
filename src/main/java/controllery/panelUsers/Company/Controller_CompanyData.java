package controllery.panelUsers.Company;

import controllery.Controller_User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Controller_CompanyData   {

    @FXML
    private Pane paneCompany;

    @FXML
    private Label companyName;

    @FXML
    private Label companyStreet;

    @FXML
    private Label companyNumberB;

    @FXML
    private Label companyNumberL;

    @FXML
    private Label companyPostCod;

    @FXML
    private Label companyCity;

    @FXML
    private Label idComap;

    @FXML
    private Label idCompanyData;

    public Controller_CompanyForm formCompany;

    public  Controller_CompanyForm getController() { return  this.formCompany; }

    @FXML
    void goToCompanyForm(ActionEvent event) throws IOException {
        String companyForm = "/fxml/panelUser_type/Company/CompanyForm.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_CompanyData.class.getResource(companyForm));
        Pane newLoadPane = loader.load();
        paneCompany.getChildren().add(newLoadPane);

        Controller_CompanyForm form = loader.getController();
        formCompany = form;
        int id = Integer.parseInt(idComap.getText());
        form.readIdUser(id);

    }

    @FXML
    void goToDataAnalysis(ActionEvent event) {

    }

    @FXML
    void goToDataFinicial(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/Company/panelCompany_Financial.fxml"));
        paneCompany.getChildren().add(newLoadPane);

    }

    public void readIdUser(int id){
        idComap.setText(Integer.toString(id));
        idComap.setVisible(false);
    }

    public void readIdCompany(int id){
        idCompanyData.setText(Integer.toString(id));

    }

    public void readDataCompany(String nameC, String streetC, String numberLocal, String numberBuilding,
                                String city, String postCode){

            companyName.setText(nameC);
            companyStreet.setText("ul. " + streetC);
            companyNumberB.setText(numberBuilding);
            companyNumberL.setText(numberLocal);
            companyCity.setText(city);
            companyPostCod.setText(postCode);

    }


}
