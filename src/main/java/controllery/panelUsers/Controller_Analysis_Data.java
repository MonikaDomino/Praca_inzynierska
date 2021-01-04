package controllery.panelUsers;


import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;



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

    public Controller_ShowAnalysis show;

    public Controller_Start conS;

    @FXML
    private Label idUserAT;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        ButtonType buttonYES = new ButtonType("Tak, chce", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Nie, zostañ", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.NONE, " ", buttonYES, buttonNO);
        String s = "Czy na pewno chcesz przerwaæ analizê?";
        alertC.setHeaderText(s);


        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(350, 5);


        alertC.setTitle(" ");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.orElse(buttonNO) == buttonYES) {

            String linkC = "/fxml/panelUser_type/panelStart.fxml";
            FXMLLoader loaderCancel = new FXMLLoader();
            loaderCancel.setLocation(Controller_Analysis_Data.class.getResource(linkC));
            Pane newLoadPane = loaderCancel.load();
            paneData.getChildren().add(newLoadPane);

            Controller_Start CNstart = loaderCancel.getController();

            conS= CNstart;
            int id = Integer.parseInt(idUserAT.getText());
            UzytkownikQuery userP = new UzytkownikQuery();
            Uzytkownik userCP = userP.showData(id);
            CNstart.readLabel(userCP.getImie(), userCP.getNazwisko());



        }
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
        profit_net.setText(null);

    }

    @FXML
    void doAnalysis(ActionEvent event) throws Exception {

        int year_economy = Integer.parseInt(yeartxt.getText());    // rok bilansowy
        double gross_profit = Double.parseDouble(grossprofit.getText());   // zysk brutto
        double economy_stock = Double.parseDouble(economyStock.getText()); // zapasy
        double total_assest = Double.parseDouble(totalAssest.getText());  // aktywa ogó³em
        double net_profit = Double.parseDouble(profit_net.getText());      // zysk netto
        double amort = Double.parseDouble(amortization.getText());      // amortyzacja
        double total_Sales = Double.parseDouble(totalSales.getText());  // przychody ze sprzeda¿y
        double operation_profit = Double.parseDouble(operationProfit.getText()); // zysk operacyjny
        double capitalOwn = Double.parseDouble(capital.getText());  // kapita³ w³asny
        double credit = Double.parseDouble(credits.getText());     // zobowi¹zania ogó³em

        int id_company = Integer.parseInt(CompanyID.getText());


        DanefinansoweQuery data = new DanefinansoweQuery();

        int companyId = Integer.parseInt(CompanyID.getText());
        Danefinansowe dft = data.checkYear(companyId);

    if(dft.getRokBilansowy() != year_economy) {
        data.addNewFinancialDataAnalysis(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                operation_profit, amort, capitalOwn, net_profit, id_company);

        Danefinansowe dataFinancial = data.showID(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                operation_profit, amort, capitalOwn, net_profit, id_company);


        int id = dataFinancial.getIdDane();

        idDataFinancial.setText(Integer.toString(id));
        idDataFinancial.setVisible(false);


        double x1 = (gross_profit + amort) / credit;
        double x2 = total_assest / credit;
        double x3 = operation_profit / total_assest;
        double x4 = operation_profit / total_Sales;
        double x5 = economy_stock / total_Sales;
        double x6 = total_Sales / total_assest;

        double analysis = ((3 * x1) / 2) + ((8 * x2) / 100) + 10 * x3 + 5 * x4 + ((3 * x5) / 10) + (x6 / 10);


        int idData = Integer.parseInt(idDataFinancial.getText());

        try {
            AnalizaQuery analyse = new AnalizaQuery();
            analyse.addNewAnalysis(idData, analysis);

        } catch (Exception e) {
            e.getLocalizedMessage();
        }

        double ROE;                             // rentownoœæ kapita³u w³asnego
        double ROA;                            // rentownoœæ aktywów
        double ROS;                           // rentownoœæ sprzeda¿y
        double ROI;                          // rentownoœæ inwestycji
        double operating_profit_margin;     // mar¿a operacyjna
        double expected_gross_margin;      // mar¿a zysku brutto


        operating_profit_margin = operation_profit / total_Sales;
        expected_gross_margin = gross_profit / total_Sales;
        ROI = net_profit / total_assest;
        ROS = net_profit / total_Sales;
        ROA = operation_profit / total_assest;
        ROE = net_profit / capitalOwn;


        try {
            WskaznikiQuery pointer = new WskaznikiQuery();
            pointer.addNewPointers(ROE, ROA, ROS, operating_profit_margin, ROI, expected_gross_margin, idData);

        } catch (Exception e) {
            e.getLocalizedMessage();
        }

        String link = "/fxml/panelShowAnalysis.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller_Analysis_Data.class.getResource(link));
        Pane newPane = loader.load();
        paneData.getChildren().add(newPane);

        Controller_ShowAnalysis shown = loader.getController();
        show = shown;
        shown.readResultAnalysis(analysis);
        shown.readCondition(analysis);
        ROE = roundNumber(ROE);
        ROA = roundNumber(ROA);
        ROS = roundNumber(ROS);
        ROI = roundNumber(ROI);
        operating_profit_margin = roundNumber(operating_profit_margin);
        expected_gross_margin = roundNumber(expected_gross_margin);
        shown.readPointers(ROE, ROA, ROS, ROI, operating_profit_margin, expected_gross_margin);
        shown.readAdvantage(ROE);
        shown.compare(ROA, ROE);
        shown.readSales(ROS);
        shown.readProfitA(ROA);
        shown.readProfit(expected_gross_margin);
        shown.readMO(operating_profit_margin);
        shown.readROI(ROI);
    }else{
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setContentText("SprawdŸ zak³adkê ");
        error.setHeaderText("Analiza rentownoœci dla " + year_economy + "r. zosta³a ju¿ wykonana.");
        DialogPane dialogPane =error.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(500,200);
        error.showAndWait();

    }
    }



    public void readIDCompany(int id) {
        CompanyID.setText(Integer.toString(id));
        CompanyID.setVisible(false);

    }

    public void readIDUser (int id){
        idUserAT.setText(Integer.toString(id));
        idUserAT.setVisible(false);
    }


    public double roundNumber(double result) {         // zaokr¹glanie liczb do 2 miejsc po przecinku
        result *= 100;
        result = Math.round(result);
        result /= 100;

        return  result;
    }
}
