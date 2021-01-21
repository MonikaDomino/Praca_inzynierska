package hibernate;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class FirmaQueryTest {

    @Test
    void showIdCompany() {
        String name = "Pinokio";
        String street = "Kolejowa";
        String numberB = "13";
        String numberL = "";
        String city = "Rzeszów";
        String postcode = "23-090";

        FirmaQuery compa = new FirmaQuery();
        Firma co = compa.showIdCompany(name, street, city, postcode, numberB, numberL);
        int id = co.getIdFirmy();
        System.out.println(id);
    }

    @Test
    void changeAddress() throws Exception {
        String name = "Zeto Rzeszów";
        String street = "Rejtana";
        String numberB = "19";
        String city = "Rzeszów";
        String postcode = "35-090";
        String numberl = "";
        int idCompany = 3;

        FirmaQuery comp = new FirmaQuery();
        comp.changeAddress(name, street, numberB, city, postcode, numberl, idCompany);
    }
}