package controllery.panelUsers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_ShowAnalysis {


    @FXML
    private Label condition;

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


    public void readResultAnalysis(double result) {
            recordAnalysis.setText(Double.toString(result));
            recordAnalysis.setVisible(false);
        }

        public void readPointers(double ROE, double ROA, double ROS, double ROI,
                                 double OM, double MG) {
            resultROE.setText(Double.toString(ROE));
            resultROA.setText(Double.toString(ROA));
            resultROS.setText(Double.toString(ROS));
            resultROI.setText(Double.toString(ROI));
            resultOM.setText(Double.toString(OM));
            resultMG.setText(Double.toString(MG));
        }

        public void compare(double ROA, double ROE){
            if(ROE > ROA) {
                compare.setText("Kapita� w�asny jest efektywnie wykorzystywany.");
            } else if (ROE < ROA){
                compare.setText("Koszty  s� wy�sze ni� uzyskiwane przychody.");
            } else{
                compare.setText(" ");
            }
        }

        public void readCondition(double result) {
            double record = Double.parseDouble(recordAnalysis.getText());

            if (record < 0) {
                condition.setText("Bardzo wysoka mo�liwo�� bankructwa!");
            } else if (record > 0 && record < 1) {
                condition.setText("S�aba kondycja finansowa.");
            } else if (record > 1 && record < 2) {
                condition.setText("Dobra kondycja finansowa");
            } else {
                condition.setText("Bardzo dobra kondycja finansowa!");
            }
        }

        public void readSales(double ROS){
            if(ROS > 0){

                sales.setText("Na ka�dej z�ot�wce sprzeda�y zarabia si� " + ROS + " z�.");
            }else{
                sales.setText("Poniesione koszty przewy�szaj� przychody.");
            }
        }

        public void readProfitA (double ROA){
            if(ROA > 0){
                assest.setText("Na z�ot�wce zainwestowanego kapita�u osi�ga si� " +ROA+ " z� zysku.");

            }else {
                assest.setText("Na z�ot�wce zainwestowanego kapita�u traci si� " +(-ROA)+ " z� zysku.");
            }
        }

        public void readAdvantage(double ROE) {

            if (ROE < 0) {
                advantage.setText("Przedsi�biorstwo generuje straty.");
            } else {
                advantage.setText("Przedsiebiorstwo generuje zysk.");
            }
        }

        public void readProfit (double MZB){
                MZB *=100;
            if(MZB > 0){
                marginGross.setText(MZB + "% zysku brutto generuj� przychody ze sprzeda�y.");

            } else {
                marginGross.setText(" ");
            }
        }


    public void readMO (double MO) {
        if (MO < 0.083) {
            marginOp.setText("Koszty wytworzenia s� na zbyt wysokim poziomie.");
        } else if (MO >= 0.083) {
            marginOp.setText("Firma jest w stanie op�aci� swoje koszty sta�e.");

        }

    }

    public void readROI (double ROI){
        if(ROI < 0){
            invest.setText("Koszty z inwestycji wynios�y wi�cej ni� zyski.");
        }else{
            invest.setText("Uzyskano " +ROI+ "z� zysku na ka�dej zainwestowanej z�ot�wce.");
        }
    }

    }

