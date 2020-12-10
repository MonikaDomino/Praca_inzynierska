package controllery.panelUsers;


import hibernate.DaneFinansowe;
import hibernate.DaneFinansoweQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller_Analysis_Data {

    @FXML
    private Pane paneData;


    @FXML
    private TextField totalAssest;

    @FXML
    private TextField economyStock;

    @FXML
    private TextField grossprofit;

    @FXML
    private TextField amortization;

    @FXML
    private TextField totalSales;

    @FXML
    private TextField operationProfit;

    @FXML
    private TextField credits;

    @FXML
    private TextField profit_net;

    @FXML
    private TextField yeartxt;

    @FXML
    private Label CompanyID;

    private DaneFinansowe dataFinancial;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void clearForm(ActionEvent event) {
        totalAssest.setText(null);
        economyStock.setText(null);
        grossprofit.setText(null);
        amortization.setText(null);
        totalSales.setText(null);
        operationProfit.setText(null);
        credits.setText(null);
        yeartxt.setText(null);

    }

    @FXML
    void doAnalysis(ActionEvent event) {

            float total_assest = Float.parseFloat(totalAssest.getText());  // aktywa ogółem
            float economy_stock = Float.parseFloat(economyStock.getText()); // zapasy
            float gross_profit = Float.parseFloat(grossprofit.getText());   // zysk brutto
            float net_profit = Float.parseFloat(profit_net.getText());      // zysk netto
            float amort = Float.parseFloat(amortization.getText());      // amortyzacja
            float total_Sales = Float.parseFloat(totalSales.getText());  // przychody ze sprzedaży
            float operation_profit = Float.parseFloat(operationProfit.getText()); // zysk operacyjny
            float credit = Float.parseFloat(credits.getText());     // zobowiązania ogółem
            int year_economy = Integer.parseInt(yeartxt.getText());    // rok bilansowy

        int id_company = Integer.parseInt(CompanyID.getText());


        try{
            DaneFinansoweQuery data = new DaneFinansoweQuery();
             data.addNewFinancialDataAnalysis(year_economy, gross_profit,net_profit, total_assest, total_Sales,
                    operation_profit, credit, amort, net_profit, id_company);


        } catch (Exception e) {
            e.printStackTrace();
        }




            double x1 = (gross_profit + amort)/credit;
            double x2 = total_assest/credit;
            double x3 = operation_profit/total_assest;
            double x4 = operation_profit/total_Sales;
            double x5 = economy_stock/total_Sales;
            double x6 = total_Sales/total_assest;

            double analysis = ((3*x1)/2) + ((8*x2)/100) + 10*x3 + 5*x4 + ((3*x5)/10) + (x6/10);
        System.out.println(analysis);


        if(analysis < 0) System.out.println("Bardzo wysoka możliwość bankructwa!");
        if(analysis>0 && analysis <1) System.out.println("Słaba kondycja finansowa, ale niezagrożona bankructwem!");
        if(analysis > 1 && analysis<2) System.out.println("Dobra kondycja finansowa!");
        if (analysis >= 2) System.out.println("Bardzo dobra kondycja finansowa!");

            double ROE;
            double ROA;
            double ROS;
            double ROI;
            double operating_profit_margin;     // marża operacyjna
            double expected_gross_margin;       // marża zysku brutto

           operating_profit_margin = operation_profit/total_Sales;













    }



}
