package controllery.panelUsers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField yeartxt;

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

            double total_assest = Double.parseDouble(totalAssest.getText());
            double economy_stock = Double.parseDouble(economyStock.getText());
            double gross_profit = Double.parseDouble(grossprofit.getText());
            double amort = Double.parseDouble(amortization.getText());
            double total_Sales = Double.parseDouble(totalSales.getText());
            double operation_profit = Double.parseDouble(operationProfit.getText());
            double credit = Double.parseDouble(credits.getText());
            double year_economy = Double.parseDouble(yeartxt.getText());





    }


}
