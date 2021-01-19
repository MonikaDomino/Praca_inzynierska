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
}