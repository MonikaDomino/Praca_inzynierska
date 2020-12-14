package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Quicktest {
    private Integer idTestu;
    private Double x1;
    private Double x2;
    private Double x3;
    private Double x4;
    private Double wynikTestu;
    private Integer idDane;

    @Id
    @Column(name = "id_testu")
    public Integer getIdTestu() {
        return idTestu;
    }

    public void setIdTestu(Integer idTestu) {
        this.idTestu = idTestu;
    }

    @Basic
    @Column(name = "x1")
    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    @Basic
    @Column(name = "x2")
    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    @Basic
    @Column(name = "x3")
    public Double getX3() {
        return x3;
    }

    public void setX3(Double x3) {
        this.x3 = x3;
    }

    @Basic
    @Column(name = "x4")
    public Double getX4() {
        return x4;
    }

    public void setX4(Double x4) {
        this.x4 = x4;
    }

    @Basic
    @Column(name = "wynik_testu")
    public Double getWynikTestu() {
        return wynikTestu;
    }

    public void setWynikTestu(Double wynikTestu) {
        this.wynikTestu = wynikTestu;
    }

    @Basic
    @Column(name = "id_dane")
    public Integer getIdDane() {
        return idDane;
    }

    public void setIdDane(Integer idDane) {
        this.idDane = idDane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quicktest quicktest = (Quicktest) o;
        return Objects.equals(idTestu, quicktest.idTestu) &&
                Objects.equals(x1, quicktest.x1) &&
                Objects.equals(x2, quicktest.x2) &&
                Objects.equals(x3, quicktest.x3) &&
                Objects.equals(x4, quicktest.x4) &&
                Objects.equals(wynikTestu, quicktest.wynikTestu) &&
                Objects.equals(idDane, quicktest.idDane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTestu, x1, x2, x3, x4, wynikTestu, idDane);
    }
}
