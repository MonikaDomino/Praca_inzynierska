package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quick_test", schema = "inzynierka")
public class QuickTest {
    private int idTestu;
    private double x1;
    private double x2;
    private double x3;
    private double x4;
    private double wynikTestu;
    private int idDane;

    @Id
    @Column(name = "id_testu")
    public int getIdTestu() {
        return idTestu;
    }

    public void setIdTestu(int idTestu) {
        this.idTestu = idTestu;
    }

    @Basic
    @Column(name = "x1")
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    @Basic
    @Column(name = "x2")
    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    @Basic
    @Column(name = "x3")
    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    @Basic
    @Column(name = "x4")
    public double getX4() {
        return x4;
    }

    public void setX4(double x4) {
        this.x4 = x4;
    }

    @Basic
    @Column(name = "wynik_testu")
    public double getWynikTestu() {
        return wynikTestu;
    }

    public void setWynikTestu(double wynikTestu) {
        this.wynikTestu = wynikTestu;
    }

    @Basic
    @Column(name = "id_dane")
    public int getIdDane() {
        return idDane;
    }

    public void setIdDane(int idDane) {
        this.idDane = idDane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuickTest quickTest = (QuickTest) o;
        return idTestu == quickTest.idTestu &&
                Double.compare(quickTest.x1, x1) == 0 &&
                Double.compare(quickTest.x2, x2) == 0 &&
                Double.compare(quickTest.x3, x3) == 0 &&
                Double.compare(quickTest.x4, x4) == 0 &&
                Double.compare(quickTest.wynikTestu, wynikTestu) == 0 &&
                idDane == quickTest.idDane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTestu, x1, x2, x3, x4, wynikTestu, idDane);
    }
}
