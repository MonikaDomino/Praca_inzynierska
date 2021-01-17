package controllery.panelUsers.Company;

import hibernate.*;

import javafx.collections.FXCollections;

import javafx.fxml.FXML;

import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class Controller_CompanyAnalysis {


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
    private CategoryAxis categoryAxis;

    @FXML
    private Pane chartPane;


    public void comboBox(int idCom) {
        DanefinansoweQuery dq = new DanefinansoweQuery();

        yearCombo.getItems().addAll(dq.DaneFinansoweSelectForYear(idCom));
        yearCombo.setConverter(new DanefinansoweConverter());

        yearCombo.setOnAction(event -> comboValue(yearCombo));


    }

    public void comboValue(ComboBox<Danefinansowe> yearCombo) {

        Danefinansowe df = yearCombo.getValue();
        if (df != null) {
            int year = df.getRokBilansowy();
            int idC = Integer.parseInt(idCompany.getText());
            DanefinansoweQuery dqr = new DanefinansoweQuery();
            Danefinansowe dr = dqr.readDatafromYearComp(year, idC);

            int idData = dr.getIdDane();

            AnalizaQuery aq = new AnalizaQuery();
            Analiza aw = aq.showResult(idData);

            double result = aw.getWynikAnalizy();

            loadBarChart(idData);
            showCondition(result);
            showPointers(idData);

        }
    }

    public void showPointers (int idData){
        WskaznikiQuery wsq = new WskaznikiQuery();
        Wskazniki w = wsq.showPointers(idData);

        String ROEs = readPointers(w.getRoe());
        String ROAs = readPointers(w.getRoa());
        String ROIs = readPointers(w.getRoi());
        String MOs = readPointers(w.getMarzaOperacyjna());
        String MGs = readPointers(w.getMarzaZb());
        String ROSs = readPointers(w.getRos());

        readROS.setText(ROSs +"%");
        readMZB.setText(MGs+"%");
        readMO.setText(MOs+"%");
        readROI.setText(ROIs+"%");
        readROA.setText(ROAs+"%");
        readROE.setText(ROEs+"%");
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

            double ROEd = w.getRoe();
            double ROEp = roundPointer(ROEd);

            double ROAd = w.getRoa();
            double ROAp = roundPointer(ROAd);

            double ROSd = w.getRos();
            double ROSp = roundPointer(ROSd);

            double MOd = w.getMarzaOperacyjna();
            double MOp = roundPointer(MOd);

            double ROId = w.getRoi();
            double ROIp = roundPointer(ROId);

            double MGd = w.getMarzaZb();
            double MGp = roundPointer(MGd);

            dataSeries1.getData().addAll(new XYChart.Data<String, Double>(ROE, ROEp));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROA, ROAp));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROS, ROSp));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(OPM, MOp));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(ROI, ROIp));
                dataSeries1.getData().add(new XYChart.Data<String, Double>(GM, MGp));

                categoryAxis.setCategories(FXCollections.observableArrayList("ROE", "ROA", "ROS",
                       "OPM", "ROI", "GM"));

            barPointers.getData().setAll(dataSeries1);
            barPointers.setPrefSize(240, 200);
            barPointers.setLegendVisible(false);




        }

    public double roundPointer(double point){
        double poi = point * 100.0;
        return  Math.round(poi * 100.0) / 100.0;
    }

    public String readPointers(double point) {

        double pointD = roundPointer(point);
        String pointS = Double.toString(pointD);

        return pointS;
    }



}





