package controllery.panelUsers.Company;

import com.jfoenix.controls.JFXComboBox;
import hibernate.Danefinansowe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_CompanyFinancial {


    @FXML
    private JFXComboBox<Danefinansowe> yearCombo;

    @FXML
    private Label assestCF;

    @FXML
    private Label economyCF;

    @FXML
    private Label grossCF;

    @FXML
    private Label amortCF;

    @FXML
    private Label salesCF;

    @FXML
    private Label capitalCF;


    @FXML
    private Label profitCF;


    @FXML
    private Label creditCF;

    @FXML
    private Label selectedYear;


    public void getData (double assest, double economyS, double gross,
            double amort, double profitNet, double sales, double capital, double credit) {

        assestCF.setText(Double.toString(assest));
        economyCF.setText(Double.toString(economyS));
        grossCF.setText(Double.toString(gross));
        amortCF.setText(Double.toString(amort));
        profitCF.setText(Double.toString(profitNet));
        salesCF.setText(Double.toString(sales));
        capitalCF.setText(Double.toString(capital));
        creditCF.setText(Double.toString(credit));


    }

    public void comboYear(){
        selectedYear.setText(" ");
        yearCombo.getItems().clear();


    }


}