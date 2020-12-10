package controllery.panelUsers.Company;

import hibernate.FirmaQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller_CompanyForm {
    @FXML
    private TextField street;

    @FXML
    private TextField nameCompanytxt;

    @FXML
    private TextField numberB;

    @FXML
    private TextField postCode;

    @FXML
    private TextField city;

    @FXML
    private TextField numberF;

    @FXML
    private Label idUserC;

    @FXML
    void addCompany(ActionEvent event) {

        String nameCompany = nameCompanytxt.getText();
        String streetCompany = street.getText();
        int numberBuilding = Integer.parseInt(numberB.getText());
        int numberLocal = Integer.parseInt(numberF.getText());
        String postC = postCode.getText();
        String cityC = city.getText();
        int idUser = Integer.parseInt(idUserC.getText());


        try{
            FirmaQuery company = new FirmaQuery();
            company.addCompany(nameCompany,streetCompany,cityC, postC,numberBuilding,numberLocal,idUser);

        }catch (Exception e){
            e.getLocalizedMessage();
        }



    }

    public void readIdUser(int id){
        idUserC.setText(Integer.toString(id));
        idUserC.setVisible(false);
    }


}
