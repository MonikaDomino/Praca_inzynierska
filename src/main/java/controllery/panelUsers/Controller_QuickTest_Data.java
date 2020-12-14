package controllery.panelUsers;

import controllery.openFXMl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller_QuickTest_Data extends openFXMl {
    @FXML
    private Pane paneData;

    @FXML
    private TextField net_profit;

    @FXML
    private TextField total_assets;

    @FXML
    private TextField equity_capital;

    @FXML
    private TextField amortization;

    @FXML
    private TextField operation_profit;

    @FXML
    private TextField total_Sales;

    @FXML
    private TextField credits;

    @FXML
    private TextField yeartxt;

    @FXML
    private Label id_company;


    @FXML
    void cancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Czy na pewno chcesz przerwac?");
        ButtonType okButton = new ButtonType("Tak", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("Nie", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == ButtonType.YES) {
                String link = "/fxml/panelUser.fxml";
                readFXML(event, link);
                frame(event);

            } else if (type == ButtonType.NO) {

            }

        });
    }

    @FXML
    void clearForm(ActionEvent event) {

    }

    @FXML
    void doTest(ActionEvent event) {

        int companyID = Integer.parseInt(id_company.getText());
        int yearB = Integer.parseInt(yeartxt.getText());
        float total_credits = Float.parseFloat(credits.getText());
        float totalSales = Float.parseFloat(total_Sales.getText());
        float operationProfit = Float.parseFloat(operation_profit.getText());
        float amort = Float.parseFloat(amortization.getText());
        float equaCapital = Float.parseFloat(equity_capital.getText());
        float netProfit =  Float.parseFloat(net_profit.getText());
        float totalAssest = Float.parseFloat(total_assets.getText());

/*
            DaneFinansoweQuery dane = new DaneFinansoweQuery();
        try{
            dane.addQuickTest(yearB,totalAssest,equaCapital,amort,netProfit,operationProfit,totalSales,
                    total_credits,companyID);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dodane!");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {

                String adress = "/fxml/panelLogIN.fxml";
                readFXML(event, adress);
                frame(event);

            }else{
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText("Popraw dane");
                alert2.show();
            }

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

*/
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}





