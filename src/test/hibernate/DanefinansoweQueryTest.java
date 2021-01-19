package hibernate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DanefinansoweQueryTest {

    @Test
    void showID() {
        int year = 2020;
        double zyskB = 1.00;
        double zapasy = 2.00;
        double aktywa = 3.00;
        double sales =  4.00;
        double credits = 5.00;
        double zyskO = 6.00;
        double amort = 7.00;
        double kW = 8.00;
        double zysk = 9.00;
        int idCo = 1;

        DanefinansoweQuery instance = new DanefinansoweQuery();
        DaneFinansowe daneFinansowe = instance.showID(year, zyskB, zapasy, aktywa, sales, credits, zyskO, amort, kW, zysk, idCo);
        int id = daneFinansowe.getIdDane();
        System.out.println(id);

    }

}