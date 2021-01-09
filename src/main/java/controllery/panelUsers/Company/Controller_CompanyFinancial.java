package controllery.panelUsers.Company;

import hibernate.Danefinansowe;
import hibernate.DanefinansoweConverter;
import hibernate.DanefinansoweQuery;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller_CompanyFinancial {

    @FXML
    private ComboBox<Danefinansowe> comboYear;


    @FXML
    private Label readProfitGross;

    @FXML
    private Label readEcoStock;

    @FXML
    private Label readAssestTotal;

    @FXML
    private Label readSales;

    @FXML
    private Label readOpProfit;

    @FXML
    private Label readAmort;

    @FXML
    private Label readNetProfit;

    @FXML
    private Label readCapital;

    @FXML
    private Label readCredit;

    @FXML
    private Label selectedYear;

    @FXML
    private Label companyId;


    public void comboBox(int idComp){
        selectedYear.setText("");
        DanefinansoweQuery dq = new DanefinansoweQuery();
        comboYear.getItems().addAll(dq.DaneFinansoweSelectForYear(idComp));
        comboYear.setConverter(new DanefinansoweConverter());

        comboYear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValue(comboYear);
            }
        });


    }

    public void comboValue (ComboBox<Danefinansowe> comboYear){

        Danefinansowe df = comboYear.getValue();
        if(df!= null){
            int year = df.getRokBilansowy();
            int idCmp = Integer.parseInt(companyId.getText());
            DanefinansoweQuery dqr = new DanefinansoweQuery();
            Danefinansowe dr = dqr.readDatafromYearComp(year, idCmp);

            readProfitGross.setText(Double.toString(dr.getZyskBrutto()));
            readEcoStock.setText(Double.toString(dr.getZapasy()));
            readAssestTotal.setText(Double.toString(dr.getAktywaOgolem()));
            readSales.setText(Double.toString(dr.getPrzychodyS()));
            readOpProfit.setText(Double.toString(dr.getZyskOperacyjny()));
            readAmort.setText(Double.toString(dr.getAmortyzacja()));
            readNetProfit.setText(Double.toString(dr.getZyskNetto()));
            readCapital.setText(Double.toString(dr.getKapitalWlasny()));
            readCredit.setText(Double.toString(dr.getZobowiazania()));


        }
    }

    public void readIdCompany (int idComp){
        companyId.setText(Integer.toString(idComp));
        companyId.setVisible(false);
    }









}
