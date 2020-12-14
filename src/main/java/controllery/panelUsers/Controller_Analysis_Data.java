package controllery.panelUsers;


import hibernate.AnalizaQuery;
import hibernate.Danefinansowe;
import hibernate.DanefinansoweQuery;
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

    @FXML
    private Label idDataFinancial;

    @FXML
    private TextField capital;


    private Danefinansowe dataFinancial;

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
        capital.setText(null);
    }

    @FXML
    void doAnalysis(ActionEvent event) {

        int year_economy = Integer.parseInt(yeartxt.getText());    // rok bilansowy
        double gross_profit = Double.parseDouble(grossprofit.getText());   // zysk brutto
        double economy_stock = Double.parseDouble(economyStock.getText()); // zapasy
        double total_assest = Double.parseDouble(totalAssest.getText());  // aktywa ogółem
        double net_profit = Double.parseDouble(profit_net.getText());      // zysk netto
            double amort = Double.parseDouble(amortization.getText());      // amortyzacja
            double total_Sales = Double.parseDouble(totalSales.getText());  // przychody ze sprzedaży
            double operation_profit = Double.parseDouble(operationProfit.getText()); // zysk operacyjny
            double capitalOwn = Double.parseDouble(capital.getText());  // kapitał własny
            double credit = Double.parseDouble(credits.getText());     // zobowiązania ogółem

        int id_company = Integer.parseInt(CompanyID.getText());


        try{
                DanefinansoweQuery data = new DanefinansoweQuery();

                    data.addNewFinancialDataAnalysis(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                            operation_profit, amort, capitalOwn, net_profit, id_company);

                    Danefinansowe dataFinancial = data.showID(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                            operation_profit, amort, capitalOwn, net_profit, id_company);

            int id = dataFinancial.getIdDane();
            idDataFinancial.setText(Integer.toString(id));
            idDataFinancial.setVisible(false);


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


        if(analysis < 0) System.out.println("Bardzo wysoka możliwość bankructwa!");
        if(analysis>0 && analysis <1) System.out.println("Słaba kondycja finansowa, ale niezagrożona bankructwem!");
        if(analysis > 1 && analysis<2) System.out.println("Dobra kondycja finansowa!");
        if (analysis >= 2) System.out.println("Bardzo dobra kondycja finansowa!");

      int idData = Integer.parseInt(idDataFinancial.getText());

            try{
                AnalizaQuery analyse = new AnalizaQuery();
                analyse.addNewAnalysis(idData, analysis);

            }catch (Exception e){
                e.getLocalizedMessage();
            }

            double ROE;
            double ROA;
            double ROS;
            double ROI;
            double operating_profit_margin;     // marża operacyjna
            double expected_gross_margin;       // marża zysku brutto

           operating_profit_margin = operation_profit/total_Sales;
           expected_gross_margin = gross_profit/total_Sales;
           ROI = net_profit/capitalOwn;         // rentowność inwestycji
           ROS = net_profit/total_Sales;

           

    }

    public void readIDCompany (int id){
        CompanyID.setText(Integer.toString(id));
        CompanyID.setVisible(false);

    }


}
