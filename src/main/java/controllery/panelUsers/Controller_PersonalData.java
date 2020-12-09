package controllery.panelUsers;

import hibernate.Uzytkownik;
import hibernate.UzytkownikQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_PersonalData implements Initializable {


    @FXML
    private Pane panePData;

    @FXML
    private Label FnameInfo;

    @FXML
    private Label NameInfo;

    @FXML
    private Label Emaill_Info;

    @FXML
    private Label dataId;


    public void readId(int id){
        dataId.setText(Integer.toString(id));
        dataId.setVisible(false);
    }


    public void readData(String fname, String name, String mail){
        FnameInfo.setText(fname);
        NameInfo.setText(name);
        Emaill_Info.setText(mail);
    }



    @FXML
    void changePassword(ActionEvent event) {

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}


