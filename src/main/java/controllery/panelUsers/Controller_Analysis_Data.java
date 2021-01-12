package controllery.panelUsers;


import controllery.Controller_User;
import controllery.panelUsers.Company.Controller_Company;
import controllery.panelUsers.Company.Controller_CompanyForm;
import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Pattern;
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

   Controller_ShowAnalysis show;

  Controller_Start conS;

    @FXML
    private Label idUserAT;

    Controller_Company comPan;

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

            conS = CNstart;
            int id = Integer.parseInt(idUserAT.getText());
            UzytkownikQuery userP = new UzytkownikQuery();
            Uzytkownik userCP = userP.showData(id);
            CNstart.readLabel(userCP.getImie(), userCP.getNazwisko());


        }
    }


    @FXML
    void clearForm(ActionEvent event) {

        cleanColor();           // delete background color textfield

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

        int year_economy = Integer.parseInt(yeartxt.getText());

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

        int id_company = Integer.parseInt(CompanyID.getText());



        DanefinansoweQuery data = new DanefinansoweQuery();

        Danefinansowe dft = data.checkYear(id_company, year_economy);

     if (dft == null) {
         data.addNewFinancialDataAnalysis(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                 operation_profit, amort, capitalOwn, net_profit, id_company);

         Danefinansowe dataFinancial = data.showID(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                   operation_profit, amort, capitalOwn, net_profit, id_company);

         int id = dataFinancial.getIdDane();

         double x1 = (gross_profit + amort) / credit;
         double x2 = total_assest / credit;
         double x3 = operation_profit / total_assest;
         double x4 = operation_profit / total_Sales;
         double x5 = economy_stock / total_Sales;
         double x6 = total_Sales / total_assest;

         double analysis = ((3 * x1) / 2) + ((8 * x2) / 100) + 10 * x3 + 5 * x4 + ((3 * x5) / 10) + (x6 / 10);

         try {
             AnalizaQuery analyse = new AnalizaQuery();
             analyse.addNewAnalysis(id, analysis);

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
             pointer.addNewPointers(ROE, ROA, ROS, operating_profit_margin, ROI, expected_gross_margin, id);

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

     } else{
             Alert error = new Alert(Alert.AlertType.ERROR);
             error.setTitle("");
             error.setContentText("SprawdŸ zak³adkê FIRMA -> ANALIZA RENTOWNOŒCI");
             error.setHeaderText("Analiza rentownoœci dla " + year_economy + "r. zosta³a ju¿ wykonana.");
             DialogPane dialogPane = error.getDialogPane();
             dialogPane.getStylesheets().add(
                     getClass().getResource("/fxml/alert.css").toExternalForm());
             dialogPane.getStyleClass().add("myAlerts");
             dialogPane.setMaxSize(500, 200);
             error.showAndWait();

         }
     }




    @FXML
    void checkIsCorrectNumber(KeyEvent event) {
        Pattern intNumber = Pattern.compile("^-?\\d+$");


        String grossP = grossprofit.getText();
        String stockEconomy = economyStock.getText();
        String assesTotal = totalAssest.getText();
        String profitNet = profit_net.getText();
        String amortT = amortization.getText();
        String salesTotal = totalSales.getText();
        String operPofit = operationProfit.getText();
        String capitalAD = capital.getText();
        String credit = credits.getText();
        String year = yeartxt.getText();


        if (intNumber.matcher(year).matches()) {
            yeartxt.setStyle("");

        } else if (year.trim().isEmpty()) {
            yeartxt.setStyle("");

        } else {
            yeartxt.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPatterns(operPofit)) {
            operationProfit.setStyle("");

        }else if(operPofit.trim().isEmpty()){
            operationProfit.setStyle("");

        }else {
            operationProfit.setStyle("-fx-background-color: #FF8080");
        }

        if (checkPatterns(credit)) {
            credits.setStyle("");

        }else if(credit.trim().isEmpty()){
            credits.setStyle("");

        } else {


            credits.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPatterns(capitalAD)) {
            capital.setStyle(" ");

        } else if(capitalAD.trim().isEmpty()){
                capital.setStyle("");

        } else {

            capital.setStyle("-fx-background-color: #FF8080");
        }

        if (checkPatterns(salesTotal)) {
            totalSales.setStyle(" ");

        }else if(salesTotal.trim().isEmpty()){
                totalSales.setStyle("");
        } else {

            totalSales.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPatterns(amortT)) {
            amortization.setStyle(" ");

        } else if(amortT.trim().isEmpty()){
                amortization.setStyle("");
        } else {
            amortization.setStyle("-fx-background-color: #FF8080");

        }

        if (checkPatterns(profitNet) ) {
            profit_net.setStyle("");
        }else if(profitNet.trim().isEmpty()){
                profit_net.setStyle("");
        } else {
            profit_net.setStyle("-fx-background-color: #FF8080");

        }
        if (checkPatterns(assesTotal)) {
            totalAssest.setStyle("");
        }else if(assesTotal.trim().isEmpty()){
                totalAssest.setStyle("");
        } else {
            totalAssest.setStyle("-fx-background-color: #FF8080");

        }
        if (checkPatterns(stockEconomy)) {
            economyStock.setStyle("");
        }else if(stockEconomy.trim().isEmpty()){
                economyStock.setStyle("");
        } else {
             economyStock.setStyle("-fx-background-color: #ff8080");


        }
        if (checkPatterns(grossP)) {
            grossprofit.setStyle("");
        }  else if(grossP.trim().isEmpty()){
                grossprofit.setStyle("");

        } else {
            grossprofit.setStyle("-fx-background-color: #FF8080");


        }

    }




    public void readIDCompany(int id) {
        CompanyID.setText(Integer.toString(id));
        CompanyID.setVisible(false);

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
        char[] chars = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if(!Character.isWhitespace(chars[i])) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
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

    public void cleanColor(){
        totalSales.setStyle(" ");
        totalAssest.setStyle(" ");
        economyStock.setStyle(" ");
        grossprofit.setStyle(" ");
        amortization.setStyle(" ");
        credits.setStyle("");
        operationProfit.setStyle("");
        yeartxt.setStyle("");
        capital.setStyle("");
        profit_net.setStyle("");

    }

    // method to check to number is double
    public boolean checkPatterns(String text){
        Pattern nDecimal = Pattern.compile("[+-]?\\d*\\d+");
        boolean decimalCheck = nDecimal.matcher(text).find();

        return decimalCheck;


    }
    public void showAlert() throws IOException {
        ButtonType buttonYES = new ButtonType("Dodaj firmê", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Anuluj", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.INFORMATION, " ", buttonYES, buttonNO);
        String s = "Przed wykonaniem analizy dodaj firmê!";
        alertC.setHeaderText(s);
        alertC.setContentText(null);
        DialogPane dialogPane = alertC.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/alert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlerts");
        dialogPane.setMaxSize(450,0);;
        alertC.showAndWait();

        if(alertC.getResult() == buttonYES){
            String link = "/fxml/panelUser_type/Company/Company.fxml";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller_User.class.getResource(link));
            Pane newPane = loader.load();
            paneData.getChildren().add(newPane);

            Controller_Company Ccom = loader.getController();
            comPan = Ccom;
            int id = Integer.parseInt(idUserAT.getText());
            comPan.readIdUser(id);
        }



    }

}
