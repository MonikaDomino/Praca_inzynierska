package controllery.panelUsers;

import controllery.panelUsers.Company.Controller_CompanyData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller_AnalysisType {
    @FXML
    private Pane pane_Analysis;

    @FXML
    private Label idCompany;

    Controller_Analysis_Data analysis;


    @FXML
    void goToAnalysisMaczynskiej(ActionEvent event) throws IOException {
        String link = "/fxml/panelUser_type/panelAnalysis_Data.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_AnalysisType.class.getResource(link));
        Pane newLoadPane = loader.load();
        pane_Analysis.getChildren().add(newLoadPane);

        Controller_Analysis_Data analyType = loader.getController();
        analysis = analyType;
        int id = Integer.parseInt(idCompany.getText());
        analyType.readIDCompany(id);



    }

    @FXML
    void goToQuickTest(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelTest_Data.fxml"));
        pane_Analysis.getChildren().add(newLoadPane);


    }

    public void readIdCompany(int id){
        idCompany.setText(Integer.toString(id));
        idCompany.setVisible(false);

    }



}
