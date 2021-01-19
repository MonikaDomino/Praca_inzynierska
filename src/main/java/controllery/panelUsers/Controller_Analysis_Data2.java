package controllery.panelUsers;

import controllery.Controller_User;
import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

public class Controller_Analysis_Data2 {

    @FXML
    private Pane paneData;

    @FXML
    private TextField grossprofit;

    @FXML
    private TextField economyStock;

    @FXML
    private TextField totalAssest;

    @FXML
    private TextField totalSales;

    @FXML
    private TextField credits;

    @FXML
    private TextField operationProfit;

    @FXML
    private Label idCompa;

    @FXML
    private TextField amortization;

    @FXML
    private TextField capital;

    @FXML
    private TextField profit_net;

    @FXML
    private TextField yeartxt;

    @FXML
    private Label idYear;

    Controller_ShowAnalysis shown;

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

           // conS = CNstart;
            //int id = Integer.parseInt(idUserAT.getText());
            UzytkownikQuery userP = new UzytkownikQuery();
            //Uzytkownik userCP = userP.showData(id);
            // CNstart.readLabel(userCP.getImie(), userCP.getNazwisko());


        }
    }

    @FXML
    void checkIsCorrectNumber(KeyEvent event) {
        Pattern intNum = Pattern.compile("^-?\\d+$");


        String grossP = grossprofit.getText();
        String stockEconomy = economyStock.getText();
        String assesTotal = totalAssest.getText();
        String profitNet = profit_net.getText();
        String amortT = amortization.getText();
        String salesTotal = totalSales.getText();
        String operPofit = operationProfit.getText();
        String capitalAD = capital.getText();
        String credit = credits.getText();



        if (checkPattern(operPofit)) {
            operationProfit.setStyle("");

        } else if (operPofit.trim().isEmpty()) {
            operationProfit.setStyle("");

        } else {
            operationProfit.setStyle("-fx-background-color: #FF8080");
        }

        if (checkPattern(credit)) {
            credits.setStyle("");

        } else if (credit.trim().isEmpty()) {
            credits.setStyle("");

        } else {


            credits.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPattern(capitalAD)) {
            capital.setStyle(" ");

        } else if (capitalAD.trim().isEmpty()) {
            capital.setStyle("");

        } else {

            capital.setStyle("-fx-background-color: #FF8080");
        }

        if (checkPattern(salesTotal)) {
            totalSales.setStyle(" ");

        } else if (salesTotal.trim().isEmpty()) {
            totalSales.setStyle("");
        } else {

            totalSales.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPattern(amortT)) {
            amortization.setStyle(" ");

        } else if (amortT.trim().isEmpty()) {
            amortization.setStyle("");
        } else {
            amortization.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPattern(profitNet)) {
            profit_net.setStyle("");
        } else if (profitNet.trim().isEmpty()) {
            profit_net.setStyle("");
        } else {
            profit_net.setStyle("-fx-background-color: #FF8080");

        }
        if (checkPattern(assesTotal)) {
            totalAssest.setStyle("");
        } else if (assesTotal.trim().isEmpty()) {
            totalAssest.setStyle("");
        } else {
            totalAssest.setStyle("-fx-background-color: #FF8080");

        }
        if (checkPattern(stockEconomy)) {
            economyStock.setStyle("");
        } else if (stockEconomy.trim().isEmpty()) {
            economyStock.setStyle("");
        } else {
            economyStock.setStyle("-fx-background-color: #ff8080");


        }
        if (checkPattern(grossP)) {
            grossprofit.setStyle("");
        } else if (grossP.trim().isEmpty()) {
            grossprofit.setStyle("");

        } else {
            grossprofit.setStyle("-fx-background-color: #FF8080");


        }
    }

        // method to check to number is double
        public boolean checkPattern(String text){
            Pattern nDecimal = Pattern.compile("[+-]?\\d*\\d+");
            boolean decimalCheck = nDecimal.matcher(text).find();

            return decimalCheck;


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
    void doAnalysis(ActionEvent event) throws IOException {

        DanefinansoweQuery q = new DanefinansoweQuery();
        int nYear = Integer.parseInt(idYear.getText());
        DaneFinansowe dft = q.readDatafromYear(nYear);
        int year = (dft.getRokBilansowy()) - 1;

        String gP = grossprofit.getText();
        double gross_profit = formatInputDatatoDouble(gP);

        String eS = economyStock.getText();
        double economy_stock = formatInputDatatoDouble(eS);

        String tA = totalAssest.getText();
        double total_assest = formatInputDatatoDouble(tA);

        String pN = profit_net.getText();
        double net_profit = formatInputDatatoDouble(pN);

        String am = amortization.getText();
        double amort = formatInputDatatoDouble(am);

        String tS = totalSales.getText();
        double total_Sales = formatInputDatatoDouble(tS);

        String oP = operationProfit.getText();
        double operation_profit = formatInputDatatoDouble(oP);

        String cO = capital.getText();
        double capitalOwn = formatInputDatatoDouble(cO);

        String cR = credits.getText();
        double credit = formatInputDatatoDouble(cR);

        int id_company = Integer.parseInt(idCompa.getText());


        DanefinansoweQuery data = new DanefinansoweQuery();

        data.addNewFinancialDataAnalysis(year, gross_profit, economy_stock, total_assest, total_Sales, credit,
                operation_profit, amort, capitalOwn, net_profit, id_company);

        DaneFinansowe dataFinancial = data.showID(year, gross_profit, economy_stock, total_assest, total_Sales, credit,
                operation_profit, amort, capitalOwn, net_profit, id_company);

            int idDate = dataFinancial.getIdDane();

            double x1 = (gross_profit + amort) / credit;
            double x2 = total_assest / credit;
            double x3 = operation_profit / total_assest;
            double x4 = operation_profit / total_Sales;
            double x5 = economy_stock / total_Sales;
            double x6 = total_Sales / total_assest;

            double analysis = ((3 * x1) / 2) + ((8 * x2) / 100) + 10 * x3 + 5 * x4 + ((3 * x5) / 10) + (x6 / 10);

            try {
                AnalizaQuery analyse = new AnalizaQuery();
                analyse.addNewAnalysis(idDate, analysis);

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
                pointer.addNewPointers(ROE, ROA, ROS, operating_profit_margin, ROI, expected_gross_margin, idDate);

            } catch (Exception e) {
                e.getLocalizedMessage();
            }

            String link = "/fxml/panelShowAnalysis.fxml";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller_User.class.getResource(link));
            Pane newPane = loader.load();
            paneData.getChildren().add(newPane);

            Controller_ShowAnalysis showAnalysis = loader.getController();
            shown = showAnalysis;

            DanefinansoweQuery dataP = new DanefinansoweQuery();
            int idComa = Integer.parseInt(idCompa.getText());
            int nowYear = Integer.parseInt(idYear.getText());
            DaneFinansowe dftw = dataP.checkYear(idComa, nowYear);
            DaneFinansowe dftp = dataP.checkYear(idComa, idDate);
            showAnalysis.readYear(dftw.getRokBilansowy(), dftp.getRokBilansowy());

            WskaznikiQuery wsq = new WskaznikiQuery();
            Wskazniki ws = wsq.showPointers(nowYear);
            showAnalysis.readPointersNow(ws.getRoe(), ws.getRoa(), ws.getRos(), ws.getRoi(),
                    ws.getMarzaOperacyjna(), ws.getMarzaZb());
            Wskazniki w = wsq.showPointers(idDate);
            showAnalysis.readPointersPreview(w.getRoe(), w.getRoa(), w.getRos(), w.getRoi(),
                    w.getMarzaOperacyjna(), w.getMarzaZb());
            showAnalysis.readValueN(ws.getRoe(), ws.getRoa(), ws.getRos(), ws.getRoi(),
                    ws.getMarzaOperacyjna(), ws.getMarzaZb());
            showAnalysis.readValue(w.getRoe(), w.getRoa(), w.getRos(), w.getRoi(),
                    w.getMarzaOperacyjna(), w.getMarzaZb());

            double devRoe = showAnalysis.readDeviation(ws.getRoe(), w.getRoe());
            double devROA = showAnalysis.readDeviation(ws.getRoa(), w.getRoa());
            double devROS = showAnalysis.readDeviation(ws.getRos(), w.getRos());
            double devROI = showAnalysis.readDeviation(ws.getRoi(), w.getRoi());
            double devMO = showAnalysis.readDeviation(ws.getMarzaOperacyjna(), w.getMarzaOperacyjna());
            double devMG = showAnalysis.readDeviation(ws.getMarzaZb(), w.getMarzaZb());

            showAnalysis.readDev(devRoe, devROA, devROS, devROI, devMO, devMG);
            AnalizaQuery analise = new AnalizaQuery();
            Analiza analize = analise.showResult(nowYear);
            showAnalysis.readCondition(analize.getWynikAnalizy());
            showAnalysis.compare(ws.getRoa(), ws.getRoe());
            showAnalysis.readRoA(w.getRoa());
            showAnalysis.readRoi(w.getRoi());
            showAnalysis.readRos(w.getRos());



    }

    public Double formatInputDatatoDouble (String text)  {
        text = removeAllWhitespaces(text);
        text = text.replace(',', '.');
        int decimalSeperator = text.lastIndexOf('.');

        if (decimalSeperator > -1) {
            text = text.substring(0, decimalSeperator).replace(".", "") + text.substring(decimalSeperator);
        }

        return Double.valueOf(text);
    }

    private static String removeAllWhitespaces(String str2) {
        var chars = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (!Character.isWhitespace(aChar)) {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }


    public void cleanColor() {
        totalSales.setStyle(" ");
        totalAssest.setStyle(" ");
        economyStock.setStyle(" ");
        grossprofit.setStyle(" ");
        amortization.setStyle(" ");
        credits.setStyle("");
        operationProfit.setStyle("");
//        yeartxt.setStyle("");
        capital.setStyle("");
        profit_net.setStyle("");

    }

    public void readIdCompany(int idComp){
        idCompa.setText(Integer.toString(idComp));
        idCompa.setVisible(false);
    }

    public void readIdFData (int idData){
        idYear.setText(Integer.toString(idData));
        idYear.setVisible(false);
    }
}