package controllery.panelUsers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_ShowAnalysis {

    @FXML
    private Label condition;

    @FXML
    private Label recordAnalysis;

    @FXML
    private Label resultROE;

    @FXML
    private Label advantage;

    @FXML
    private Label resultROA;


    public void readResultAnalysis(double result) {
        recordAnalysis.setText(Double.toString(result));
        recordAnalysis.setVisible(false);
    }

    public void readPointers(double ROE, double ROA) {
        resultROE.setText(Double.toString(ROE));
        resultROA.setText(Double.toString(ROA));

    }

    public void readCondition(double result) {
        double record = Double.parseDouble(recordAnalysis.getText());

        if (record < 0) {
            condition.setText("Bardzo wysoka możliwość bankructwa!");
        } else if (record > 0 && record < 1) {
            condition.setText("Słaba kondycja kondycja ");
        } else if (record > 1 && record < 2) {
            condition.setText("Dobra kondycja finansowa");
        } else {
            condition.setText("Bardzo dobra kondycja finansowa!");
        }
    }


    public void readAdvantage(double ROE) {

        if (ROE < 0) {
            advantage.setText("Przedsiebiorstwo generuje straty.");
        } else {
            advantage.setText("Przedsiebiorstwo generuje zysk.");
        }
    }


}