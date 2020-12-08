package controllery.panelUsers.Company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Controller_CompanyData   {

    @FXML
    private Pane paneCompany;

    @FXML
    void goToDataAdress(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/Company/panelCompanyAdress.fxml"));
        paneCompany.getChildren().add(newLoadPane);
    }

    @FXML
    void goToDataAnalysis(ActionEvent event) {

    }

    @FXML
    void goToDataFinicial(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/Company/panelCompany_Financial.fxml"));
        paneCompany.getChildren().add(newLoadPane);

    }


}
