package controllery.panelUsers;


import controllery.Controller_User;
import controllery.panelUsers.Company.Controller_Company;
import hibernate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

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

  Controller_Start conS;
  Controller_Analysis_Data2 analysisData2;

    @FXML
    private Label idUserAT;

    Controller_Company comPan;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        ButtonType buttonYES = new ButtonType("Tak, chce", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Nie, zosta�", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.NONE, " ", buttonYES, buttonNO);
        String s = "Czy na pewno chcesz przerwa� analiz�?";
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
    void goToNextPage(ActionEvent event) throws Exception {

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

        DaneFinansowe danF = data.readYear(year_economy);

        if(danF == null) {

            data.addNewFinancialDataAnalysis(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                    operation_profit, amort, capitalOwn, net_profit, id_company);

            DaneFinansowe dataF = data.showID(year_economy, gross_profit, economy_stock, total_assest, total_Sales, credit,
                    operation_profit, amort, capitalOwn, net_profit, id_company);

            int idD = dataF.getIdDane();


            idDataFinancial.setText(Integer.toString(idD));
            idDataFinancial.setVisible(false);

            double x1 = (gross_profit + amort) / credit;
            double x2 = total_assest / credit;
            double x3 = operation_profit / total_assest;
            double x4 = operation_profit / total_Sales;
            double x5 = economy_stock / total_Sales;
            double x6 = total_Sales / total_assest;

            double analysis = ((3 * x1) / 2) + ((8 * x2) / 100) + 10 * x3 + 5 * x4 + ((3 * x5) / 10) + (x6 / 10);

            try {
                AnalizaQuery analyse = new AnalizaQuery();
                analyse.addNewAnalysis(idD, analysis);

            } catch (Exception e) {
                e.getLocalizedMessage();
            }

            double ROE;                             // rentowno�� kapita�u w�asnego
            double ROA;                            // rentowno�� aktyw�w
            double ROS;                           // rentowno�� sprzeda�y
            double ROI;                          // rentowno�� inwestycji
            double operating_profit_margin;     // mar�a operacyjna
            double expected_gross_margin;      // mar�a zysku brutto


            operating_profit_margin = operation_profit / total_Sales;
            expected_gross_margin = gross_profit / total_Sales;
            ROI = net_profit / total_assest;
            ROS = net_profit / total_Sales;
            ROA = operation_profit / total_assest;
            ROE = net_profit / capitalOwn;


            try {
                WskaznikiQuery pointer = new WskaznikiQuery();
                pointer.addNewPointers(ROE, ROA, ROS, operating_profit_margin, ROI, expected_gross_margin, idD);

            } catch (Exception e) {
                e.getLocalizedMessage();
            }

            String link = "/fxml/panelUser_type/panelAnalysis_Data2.fxml";
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller_Analysis_Data.class.getResource(link));
            Pane newPane = loader.load();
            paneData.getChildren().add(newPane);

            Controller_Analysis_Data2 data2 = loader.getController();
            analysisData2 = data2;
            int idCp = Integer.parseInt(CompanyID.getText());
            data2.readIdCompany(idCp);
            int year = Integer.parseInt(idDataFinancial.getText());
            data2.readIdFData(year);

        }else{
            Alert alertC = new Alert(Alert.AlertType.ERROR);
            String s = "Analiza rentowno�ci za " + year_economy+ "r. zosta�a ju� wykonana";
            alertC.setHeaderText(s);
            alertC.setContentText(null);
            alertC.setTitle(null);
            DialogPane dialogPane = alertC.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/fxml/alert.css").toExternalForm());
            dialogPane.getStyleClass().add("myAlerts");
            dialogPane.setMaxSize(500,0);;
            alertC.showAndWait();

        }

    }





    @FXML
    void checkIsCorrectNumber(KeyEvent event) {


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
        ButtonType buttonYES = new ButtonType("Dodaj firm�", ButtonBar.ButtonData.YES);
        ButtonType buttonNO = new ButtonType("Anuluj", ButtonBar.ButtonData.NO);
        Alert alertC = new Alert(Alert.AlertType.INFORMATION, " ", buttonYES, buttonNO);
        String s = "Przed wykonaniem analizy dodaj firm�!";
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
