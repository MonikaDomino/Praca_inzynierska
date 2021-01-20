package controllery.panelUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller_ShowAnalysis {

    @FXML
    private Label condition;

    @FXML
    private Label recordAnalysis;

    @FXML
    private Label advantage;

    @FXML
    private Label compare;

    @FXML
    private Label sales;

    @FXML
    private Label assest;

    @FXML
    private Label marginGross;

    @FXML
    private Label marginOp;

    @FXML
    private Label invest;

    @FXML
    private Label resultROE;

    @FXML
    private Label resultROA;

    @FXML
    private Label resultROS;

    @FXML
    private Label resultROI;

    @FXML
    private Label resultOM;

    @FXML
    private Label resultMG;

    @FXML
    private Label resultROEn;

    @FXML
    private Label resultROAn;

    @FXML
    private Label resultROSn;

    @FXML
    private Label resultROIn;

    @FXML
    private Label resultMOn;

    @FXML
    private Label resultMGn;

    @FXML
    private Label compareROE;

    @FXML
    private Label compareROA;

    @FXML
    private Label compareROS;

    @FXML
    private Label compareROI;

    @FXML
    private Label compareMO;

    @FXML
    private Label compareMG;

    @FXML
    private Label previewYear;

    @FXML
    private Pane year;

    @FXML
    private Label nowYear;


    public void readYear (int nYear, int prewYear){
        nowYear.setText(Integer.toString(nYear));
        previewYear.setText(Integer.toString(prewYear));
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

    public void readPointersNow (double ROE, double ROA, double ROS, double ROI, double MO,
                                 double MG){

        String ROEs = readPointers(ROE);
        resultROEn.setText(ROEs + "%");

        String ROAs = readPointers(ROA);
        resultROAn.setText(ROAs + "%");

        String ROSs = readPointers(ROS);
        resultROSn.setText(ROSs + "%");

        String ROIs = readPointers(ROI);
        resultROIn.setText(ROIs + "%");

        String MOs = readPointers(MO);
        resultMOn.setText(MOs + "%");

        String MGs = readPointers(MG);
        resultMGn.setText(MGs + "%");


    }

    public void readDev (double ROE, double ROA, double ROS, double ROI, double MO,
                         double MG){

        String ROEdev = readPointers(ROE);
        compareROE.setText(ROEdev +"%");

        String ROAdev = readPointers(ROA);
        compareROA.setText(ROAdev + "%");

        String ROSdev = readPointers(ROS);
        compareROS.setText(ROSdev + "%");

        String ROIdev = readPointers(ROI);
        compareROI.setText(ROIdev+ "%");

        String MOdev = readPointers(MO);
        compareMO.setText(MOdev +"%");

        String MGdev = readPointers(MG);
        compareMG.setText(MGdev+"%");

        if(MG > 0){
            compareMG.setStyle(null);
        }else{
            compareMG.setStyle("-fx-text-fill: #690C00");
        }

        if(MO < 0){
            compareMO.setStyle("-fx-text-fill: #690C00");
        }else{
            compareMO.setStyle(null);
        }

        if(ROI < 0){
            compareROI.setStyle("-fx-text-fill: #690C00");
        }else{
            compareROI.setStyle(null);
        }

        if(ROA < 0){
            compareROA.setStyle("-fx-text-fill: #690C00");
        }else{
            compareROA.setStyle(null);
        }

        if(ROE < 0){
            compareROE.setStyle("-fx-text-fill: #690C00");
        }else{
            compareROE.setStyle(null);
        }

        if(ROS < 0){
            compareROS.setStyle("-fx-text-fill: #690C00");
        }else{
            compareROS.setStyle(null);
        }
    }

    public void readPointersPreview(double ROE, double ROA, double ROS, double ROI, double MO,
                                    double MG){

        String ROEs = readPointers(ROE);
        resultROE.setText(ROEs + "%");

        String ROAs = readPointers(ROA);
        resultROA.setText(ROAs + "%");

        String ROSs = readPointers(ROS);
        resultROS.setText(ROSs + "%");

        String ROIs = readPointers(ROI);
        resultROI.setText(ROIs + "%");

        String MOs = readPointers(MO);
        resultOM.setText(MOs + "%");

        String MGs = readPointers(MG);
        resultMG.setText(MGs + "%");


    }

    public double readDeviation(double pointN, double pointP){
        double dev = pointN - pointP;
       return dev;

    }



    public void readValueN (double ROE, double ROA, double ROS, double ROI, double MO,
                        double MG){

        if(ROE > 0){
            resultROEn.setStyle(null);
        }else{
            resultROEn.setStyle("-fx-text-fill: #690C00");
        }

        if(ROA < 0){
            resultROAn.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROAn.setStyle(null);
        }

        if(ROS < 0){
            resultROSn.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROSn.setStyle(null);
        }
        if(ROI < 0){
            resultROIn.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROIn.setStyle(null);
        }

        if(MO < 0){
            resultMOn.setStyle("-fx-text-fill: #690C00");
        }else{
            resultMOn.setStyle(null);
        }

        if(MG < 0){
            resultMGn.setStyle("-fx-text-fill: #690C00");
        }else{
            resultMGn.setStyle(null);
        }

    }

    public void readValue (double ROE, double ROA, double ROS, double ROI, double MO,
                            double MG){

        if(ROE < 0){
            resultROE.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROE.setStyle(null);
        }

        if(ROA < 0){
            resultROA.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROA.setStyle(null);
        }

        if(ROS < 0){
            resultROS.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROS.setStyle(null);
        }
        if(ROI < 0){
            resultROI.setStyle("-fx-text-fill: #690C00");
        }else{
            resultROI.setStyle(null);
        }

        if(MO < 0){
            resultOM.setStyle("-fx-text-fill: #690C00");
        }else{
            resultOM.setStyle(null);
        }

        if(MG < 0){
            resultMG.setStyle("-fx-text-fill: #690C00");
        }else{
            resultMG.setStyle(null);
        }

    }

    public void readCondition(double result) {

        if (result < 0) {
            condition.setText("Bardzo wysoka mo¿liwoœæ bankructwa!");
        } else if (result > 0 && result < 1) {
            condition.setText("S³aba kondycja finansowa.");
        } else if (result > 1 && result < 2) {
            condition.setText("Dobra kondycja finansowa");
        } else {
            condition.setText("Bardzo dobra kondycja finansowa!");
        }
    }

    public void compare (double ROA, double ROE){
        if(ROE >= ROA){
            advantage.setText("Przedsiêbiorstwo odnosi sukces finansowy");
        }else {
            advantage.setText("Przedsiêbiorstwo poniesie pora¿kê finansow¹");
        }
    }

    public void readRoi (double ROI){
        if(ROI > 0){
            invest.setText("Posiadane aktywa generuja zysk netto");
        }else{
            invest.setText("Posiadane aktywa nie s¹ w stanie generowaæ zysku!");
        }
    }

    public void readRoA (double ROA){
        if(ROA > 0){
            compare.setText("Maj¹tek przedsiêbiorstwa generuje zysk");
        }else{
            compare.setText("Maj¹tek przedsiêbiorstwa generuje stratê.");
        }
    }

    public void readRos(double ROS){
        if(ROS < 0){
            sales.setText("Sprzeda¿ musi byæ wiêksza, aby generowaæ zysk!  ");
        }else{
            sales.setText("Przedsiêbiorstwo generuje zysk na sprzeda¿y.");
        }
    }



}

