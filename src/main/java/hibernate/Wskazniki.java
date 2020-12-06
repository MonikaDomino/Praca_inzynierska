package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wskazniki {
    private double roe;
    private double roa;
    private double ros;
    private int idWskazniki;
    private double marzaOperacyjna;
    private double roi;
    private int marzaZb;
    private int idDane;

    @Basic
    @Column(name = "ROE")
    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    @Basic
    @Column(name = "ROA")
    public double getRoa() {
        return roa;
    }

    public void setRoa(double roa) {
        this.roa = roa;
    }

    @Basic
    @Column(name = "ROS")
    public double getRos() {
        return ros;
    }

    public void setRos(double ros) {
        this.ros = ros;
    }

    @Id
    @Column(name = "id_wskazniki")
    public int getIdWskazniki() {
        return idWskazniki;
    }

    public void setIdWskazniki(int idWskazniki) {
        this.idWskazniki = idWskazniki;
    }

    @Basic
    @Column(name = "marza_operacyjna")
    public double getMarzaOperacyjna() {
        return marzaOperacyjna;
    }

    public void setMarzaOperacyjna(double marzaOperacyjna) {
        this.marzaOperacyjna = marzaOperacyjna;
    }

    @Basic
    @Column(name = "ROI")
    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    @Basic
    @Column(name = "marza_ZB")
    public int getMarzaZb() {
        return marzaZb;
    }

    public void setMarzaZb(int marzaZb) {
        this.marzaZb = marzaZb;
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
        Wskazniki wskazniki = (Wskazniki) o;
        return Double.compare(wskazniki.roe, roe) == 0 &&
                Double.compare(wskazniki.roa, roa) == 0 &&
                Double.compare(wskazniki.ros, ros) == 0 &&
                idWskazniki == wskazniki.idWskazniki &&
                Double.compare(wskazniki.marzaOperacyjna, marzaOperacyjna) == 0 &&
                Double.compare(wskazniki.roi, roi) == 0 &&
                marzaZb == wskazniki.marzaZb &&
                idDane == wskazniki.idDane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roe, roa, ros, idWskazniki, marzaOperacyjna, roi, marzaZb, idDane);
    }
}
