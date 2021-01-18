package hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalizaQueryTest {


    @Test
    void addNewAnalysis() {
        int idData = 53;
        double result = 20.0;
        AnalizaQuery instance = new AnalizaQuery();
        instance.addNewAnalysis(idData, result);
    }

    @Test
    void showResult() {
        int idData = 53;
        AnalizaQuery instance2 = new AnalizaQuery();
        instance2.showResult(idData);
    }
}