package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wskazniki {
    private int idWskazniki;
    private double roe;
    private double roa;
    private double ros;
    private double marzaOperacyjna;
    private double roi;
    private int marzaZb;
    private int idDane;

    @Id
    public int getIdWskazniki() {
        return idWskazniki;
    }

    public void setIdWskazniki(int idWskazniki) {
        this.idWskazniki = idWskazniki;
    }

    @Basic
    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    @Basic
    public double getRoa() {
        return roa;
    }

    public void setRoa(double roa) {
        this.roa = roa;
    }

    @Basic
    public double getRos() {
        return ros;
    }

    public void setRos(double ros) {
        this.ros = ros;
    }

    @Basic
    public double getMarzaOperacyjna() {
        return marzaOperacyjna;
    }

    public void setMarzaOperacyjna(double marzaOperacyjna) {
        this.marzaOperacyjna = marzaOperacyjna;
    }

    @Basic

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    @Basic
    public int getMarzaZb() {
        return marzaZb;
    }

    public void setMarzaZb(int marzaZb) {
        this.marzaZb = marzaZb;
    }

    @Basic
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
        Wskazniki wskazniki = (Wskazniki) o;
        return idWskazniki == wskazniki.idWskazniki &&
                Double.compare(wskazniki.roe, roe) == 0 &&
                Double.compare(wskazniki.roa, roa) == 0 &&
                Double.compare(wskazniki.ros, ros) == 0 &&
                Double.compare(wskazniki.marzaOperacyjna, marzaOperacyjna) == 0 &&
                Double.compare(wskazniki.roi, roi) == 0 &&
                marzaZb == wskazniki.marzaZb &&
                idDane == wskazniki.idDane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWskazniki, roe, roa, ros, marzaOperacyjna, roi, marzaZb, idDane);
    }
}
