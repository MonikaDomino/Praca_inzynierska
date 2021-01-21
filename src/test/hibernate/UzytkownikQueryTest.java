package hibernate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UzytkownikQueryTest {

    @Test
    void addCompany() {
        int idU = 2;
        UzytkownikQuery instance = new UzytkownikQuery();
        int idC = 3;
        int id = instance.showData(idU).getIdUzytkownika();
        instance.addCompany(id, idC);

    }


    @Test
    void showData() {
        int idU = 3;
        UzytkownikQuery instance = new UzytkownikQuery();
        int id = instance.showData(idU).getIdFirmy();
        System.out.println(id);
    }
}