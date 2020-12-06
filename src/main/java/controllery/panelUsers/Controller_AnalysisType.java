package controllery.panelUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller_AnalysisType {
    @FXML
    private Pane pane_Analysis;

    @FXML
    void goToAnalysisMaczynskiej(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelAnalysis_Data.fxml"));
        pane_Analysis.getChildren().add(newLoadPane);


    }

    @FXML
    void goToQuickTest(ActionEvent event) throws IOException {
        Pane newLoadPane = FXMLLoader.load(getClass().getResource("/fxml/panelUser_type/panelTest_Data.fxml"));
        pane_Analysis.getChildren().add(newLoadPane);


    }

}
