package controllery.panelUsers.Company;

import hibernate.DaneFinansowe;
import hibernate.DaneFinansoweConverter;
import hibernate.DanefinansoweQuery;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class Controller_CompanyFinancial {

    @FXML
    private ComboBox<DaneFinansowe> comboYear;


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
        comboYear.setConverter(new DaneFinansoweConverter());

        comboYear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValue(comboYear);
            }
        });


    }

    public void comboValue (ComboBox<DaneFinansowe> comboYear){

        DaneFinansowe df = comboYear.getValue();
        if(df!= null){
            int year = df.getRokBilansowy();
            int idCmp = Integer.parseInt(companyId.getText());
            DanefinansoweQuery dqr = new DanefinansoweQuery();
            DaneFinansowe dr = dqr.readDatafromYearComp(year, idCmp);

            String profitG = getDoubleFormat(dr.getZyskBrutto());
            readProfitGross.setText(profitG);

            String stockEco = getDoubleFormat(dr.getZapasy());
            readEcoStock.setText(stockEco);

            String totalAssest = getDoubleFormat(dr.getAktywaOgolem());
            readAssestTotal.setText(totalAssest);

            String totalSale = getDoubleFormat(dr.getPrzychodyS());
            readSales.setText(totalSale);

            String profitOp = getDoubleFormat(dr.getZyskOperacyjny());
            readOpProfit.setText(profitOp);

            String amort = getDoubleFormat(dr.getAmortyzacja());
            readAmort.setText(amort);

            String netP = getDoubleFormat(dr.getZyskNetto());
            readNetProfit.setText(netP);

            String capital = getDoubleFormat(dr.getKapitalWlasny());
            readCapital.setText(capital);

            String credits = getDoubleFormat(dr.getZobowiazania());
            readCredit.setText(credits);


        }
    }

    public String getDoubleFormat(double number){

       if(number > 0.0) {
            DecimalFormat dt = new DecimalFormat("#,###.00");
            String formatted = dt.format(number);
            return formatted;
       }
       int value = (int) number;
       String doubleS = Integer.toString(value);
       return doubleS;
    }

    public void readIdCompany (int idComp){
        companyId.setText(Integer.toString(idComp));
        companyId.setVisible(false);
    }









}
