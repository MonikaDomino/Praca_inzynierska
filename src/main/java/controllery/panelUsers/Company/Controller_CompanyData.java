package controllery.panelUsers.Company;

import hibernate.Firma;
import hibernate.FirmaQuery;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_CompanyData {


    @FXML
    private Label nameCompanyR;

    @FXML
    private Label streetCompanyR;

    @FXML
    private Label cityCompany;

    public void readCompanyData(int idComp) {

        FirmaQuery comData = new FirmaQuery();
        Firma compa = comData.showCompanyData(idComp);

        String local = compa.getNumerLokalu();

            nameCompanyR.setText(compa.getNazwaFirmy());
            if (!local.isEmpty()) {
                streetCompanyR.setText("ul. " + compa.getUlica() + " " + compa.getNumerBudynku() + "/" + compa.getNumerLokalu());
            } else {
                streetCompanyR.setText("ul. " + compa.getUlica() + " " + compa.getNumerBudynku());
            }
            cityCompany.setText(compa.getKodPocztowy()+ " " + compa.getMiasto());


    }



}
