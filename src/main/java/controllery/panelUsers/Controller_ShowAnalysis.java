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
                compare.setText("Kapita³ w³asny jest efektywnie wykorzystywany.");
            } else if (ROE < ROA){
                compare.setText("Koszty  s¹ wy¿sze ni¿ uzyskiwane przychody.");
            } else{
                compare.setText(" ");
            }
        }

        public void readCondition(double result) {
            double record = Double.parseDouble(recordAnalysis.getText());

            if (record < 0) {
                condition.setText("Bardzo wysoka mo¿liwoœæ bankructwa!");
            } else if (record > 0 && record < 1) {
                condition.setText("S³aba kondycja finansowa.");
            } else if (record > 1 && record < 2) {
                condition.setText("Dobra kondycja finansowa");
            } else {
                condition.setText("Bardzo dobra kondycja finansowa!");
            }
        }

        public void readSales(double ROS){
            if(ROS > 0){

                sales.setText("Na ka¿dej z³otówce sprzeda¿y zarabia siê " + ROS + " z³.");
            }else{
                sales.setText("Poniesione koszty przewy¿szaj¹ przychody.");
            }
        }

        public void readProfitA (double ROA){
            if(ROA > 0){
                assest.setText("Na z³otówce zainwestowanego kapita³u osi¹ga siê " +ROA+ " z³ zysku.");

            }else {
                assest.setText("Na z³otówce zainwestowanego kapita³u traci siê " +(-ROA)+ " z³ zysku.");
            }
        }

        public void readAdvantage(double ROE) {

            if (ROE < 0) {
                advantage.setText("Przedsiêbiorstwo generuje straty.");
            } else {
                advantage.setText("Przedsiebiorstwo generuje zysk.");
            }
        }

        public void readProfit (double MZB){
                MZB *=100;
            if(MZB > 0){
                marginGross.setText(MZB + "% zysku brutto generuj¹ przychody ze sprzeda¿y.");

            } else {
                marginGross.setText(" ");
            }
        }


    public void readMO (double MO) {
        if (MO < 0.083) {
            marginOp.setText("Koszty wytworzenia s¹ na zbyt wysokim poziomie.");
        } else if (MO >= 0.083) {
            marginOp.setText("Firma jest w stanie op³aciæ swoje koszty sta³e.");

        }

    }

    public void readROI (double ROI){
        if(ROI < 0){
            invest.setText("Koszty z inwestycji wynios³y wiêcej ni¿ zyski.");
        }else{
            invest.setText("Uzyskano " +ROI+ "z³ zysku na ka¿dej zainwestowanej z³otówce.");
        }
    }

    }

