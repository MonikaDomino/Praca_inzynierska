package controllery.panelUsers.Company;

import hibernate.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;
;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class Controller_CompanyAnalysis {


    @FXML
    private Pane paneCA;

    @FXML
    private ComboBox<Danefinansowe> yearCombo;

    @FXML
    private Label readROE;

    @FXML
    private Label readROA;

    @FXML
    private Label readROS;

    @FXML
    private Label readMO;

    @FXML
    private Label readROI;

    @FXML
    private Label readMZB;

    @FXML
    private Label condition;

    @FXML
    private BarChart<String, Double> barPointers;

    @FXML
    private Label resultAnalysis;

    @FXML
    private Label idCompany;

    @FXML
    private Pane chartPane;


    public void comboBox(int idCom) {
        DanefinansoweQuery dq = new DanefinansoweQuery();

        yearCombo.getItems().addAll(dq.DaneFinansoweSelectForYear(idCom));
        yearCombo.setConverter(new DanefinansoweConverter());

        yearCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValue(yearCombo);
            }
        });


    }

    public void comboValue(ComboBox<Danefinansowe> yearCombo) {

        Danefinansowe df = yearCombo.getValue();
        if (df != null) {
            int year = df.getRokBilansowy();
            int idC = Integer.parseInt(idCompany.getText());
            DanefinansoweQuery dqr = new DanefinansoweQuery();
            Danefinansowe dr = dqr.readDatafromYearComp(year, idC);

            int idData = dr.getIdDane();

            loadBarChart(idData);

            AnalizaQuery aq = new AnalizaQuery();
            Analiza aw = aq.showResult(idData);

            double result = aw.getWynikAnalizy();

            showCondition(result);
            showPointers(idData);

        }
    }

    public void showPointers (int idData){
        WskaznikiQuery wsq = new WskaznikiQuery();
        Wskazniki w = wsq.showPointers(idData);

        readROS.setText(Double.toString(w.getRos()));
        readMZB.setText(Double.toString(w.getMarzaZb()));
        readMO.setText(Double.toString(w.getMarzaOperacyjna()));
        readROI.setText(Double.toString(w.getRoi()));
        readROA.setText(Double.toString(w.getRoa()));
        readROE.setText(Double.toString(w.getRoe()));
    }

    public void showCondition(double result) {
        if (result < 0) {
            condition.setText("Bardzo wysoka mo¿liwoœæ bankructwa!");
            condition.setStyle("-fx-text-fill: #9D1414");
        } else if (result > 0 && result < 1) {
            condition.setText("S³aba kondycja finansowa.");
            condition.setStyle("-fx-text-fill: #B04F07");
        } else if (result > 1 && result < 2) {
            condition.setText("Dobra kondycja finansowa");
            condition.setStyle("-fx-text-fill: #0807B0");
        } else {
            condition.setText("Bardzo dobra kondycja finansowa!");
            condition.setStyle("-fx-text-fill: #116914");
        }
    }

    public void readIdCompany(int id) {
        idCompany.setText(Integer.toString(id));
        idCompany.setVisible(false);
    }


public void loadBarChart(int idData){

            XYChart.Series dataSeries1 = new XYChart.Series<String, Double>();
            WskaznikiQuery wsq = new WskaznikiQuery();

            Wskazniki w = wsq.showPointers(idData);

            final String ROE = "ROE";
            final String ROA = "ROA";
            final String ROS = "ROS";
            final String OPM = "OPM";
            final String ROI = "ROI";
            final String GM = "GM";



            dataSeries1.getData().addAll(new XYChart.Data<String, Double>(ROE, w.getRoe()));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROA, w.getRoa()));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROS, w.getRoe()));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(OPM, w.getMarzaOperacyjna()));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROI, w.getRoi()));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(GM, w.getMarzaZb()));

            barPointers.getData().setAll(dataSeries1);
            barPointers.setPrefSize(240, 200);
            barPointers.setLegendVisible(false);



        }

        
}





