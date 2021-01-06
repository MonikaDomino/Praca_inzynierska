package controllery.panelUsers.Company;

import controllery.panelUsers.Controller_Analysis_Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller_Company {

    @FXML
    private Pane changePaneC;

    @FXML
    private Pane paneChange;

    Controller_CompanyFinancial financial;
    Controller_CompanyAnalysis analysis;

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



}
