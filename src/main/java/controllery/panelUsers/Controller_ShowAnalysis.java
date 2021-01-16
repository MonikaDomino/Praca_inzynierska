package controllery.panelUsers;

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
        double pointer = Math.round(poi * 100.0) / 100.0;

        return pointer;
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
    }

