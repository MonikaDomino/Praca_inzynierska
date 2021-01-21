package hibernate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DanefinansoweQueryTest {

    @Test
    void showID() {
        int year = 2022;
        double zyskB = 1.00;
        double zapasy = 2.00;
        double aktywa = 2.00;
        double sales =  2.00;
        double credits = 2.00;
        double zyskO = 2.00;
        double amort = 2.00;
        double kW = 2.00;
        double zysk = 2.00;
        int idCo = 2;

        DanefinansoweQuery instance = new DanefinansoweQuery();
        DaneFinansowe daneFinansowe = instance.showID(year, zyskB, zapasy, aktywa, sales, credits, zyskO, amort, kW, zysk, idCo);
        int id = daneFinansowe.getIdDane();
        System.out.println(id);

    }

    @Test
    void readYear() {
        int year = 2019;
        int idCompany =4;

        int year2 = 2019;
        int idCopany = 1;

        DanefinansoweQuery instance = new DanefinansoweQuery();
        DaneFinansowe df = instance.readYear(year, idCompany);
        DaneFinansowe dt = instance.readYear(year2, idCopany);
        int id = df.getIdDane();
        int idA = dt.getIdDane();
        System.out.println(id);
        System.out.println(idA);


    }
}