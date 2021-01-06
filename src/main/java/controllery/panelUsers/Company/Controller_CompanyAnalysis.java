package controllery.panelUsers.Company;

import hibernate.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

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


    public void comboBox(){
        DanefinansoweQuery dq = new DanefinansoweQuery();
        yearCombo.getItems().addAll(dq.DaneFinansoweSelectAll());
        yearCombo.setConverter(new DanefinansoweConverter());

        yearCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValue(yearCombo);
            }
        });


    }

    public void comboValue (ComboBox<Danefinansowe> yearCombo){

        Danefinansowe df = yearCombo.getValue();
        if(df!= null){
            int year = df.getRokBilansowy();
            DanefinansoweQuery dqr = new DanefinansoweQuery();
            Danefinansowe dr = dqr.readDatafromYear(year);

            int idData = dr.getIdDane();

            WskaznikiQuery point = new WskaznikiQuery();
            Wskazniki pointers = point.showCompany(idData);

            double ROE = pointers.getRoe();
            double ROA = pointers.getRoa();
            double ROI = pointers.getRoi();
            double MO = pointers.getMarzaOperacyjna();
            double MZB = pointers.getMarzaZb();
            double ROS = pointers.getRos();

            readROE.setText(Double.toString(ROE));
            readROA.setText(Double.toString(ROA));
            readROI.setText(Double.toString(ROI));
            readMO.setText(Double.toString(MO));
            readMZB.setText(Double.toString(MZB));
            readROS.setText(Double.toString(ROS));


            if(ROE < 0)  readROE.setStyle("-fx-text-fill: red");
            if(ROA < 0)  readROA.setStyle("-fx-text-fill: red");
            if(ROI < 0)  readROI.setStyle("-fx-text-fill: red");
            if(MO < 0)   readMO.setStyle("-fx-text-fill: red");
            if(MZB <0)   readMZB.setStyle("-fx-text-fill: red");
            if(ROS <0)   readROS.setStyle("-fx-text-fill: red");


        }
    }
}
