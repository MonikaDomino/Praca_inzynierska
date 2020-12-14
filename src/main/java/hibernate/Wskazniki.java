package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wskazniki {
    private Integer idWskazniki;
    private Double roe;
    private Double roa;
    private Double ros;
    private Double marzaOperacyjna;
    private Double roi;
    private Double marzaZb;
    private Integer idDane;

    @Id
    @Column(name = "id_wskazniki")
    public Integer getIdWskazniki() {
        return idWskazniki;
    }

    public void setIdWskazniki(Integer idWskazniki) {
        this.idWskazniki = idWskazniki;
    }

    @Basic
    @Column(name = "ROE")
    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    @Basic
    @Column(name = "ROA")
    public Double getRoa() {
        return roa;
    }

    public void setRoa(Double roa) {
        this.roa = roa;
    }

    @Basic
    @Column(name = "ROS")
    public Double getRos() {
        return ros;
    }

    public void setRos(Double ros) {
        this.ros = ros;
    }

    @Basic
    @Column(name = "marza_operacyjna")
    public Double getMarzaOperacyjna() {
        return marzaOperacyjna;
    }

    public void setMarzaOperacyjna(Double marzaOperacyjna) {
        this.marzaOperacyjna = marzaOperacyjna;
    }

    @Basic
    @Column(name = "ROI")
    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    @Basic
    @Column(name = "marza_ZB")
    public Double getMarzaZb() {
        return marzaZb;
    }

    public void setMarzaZb(Double marzaZb) {
        this.marzaZb = marzaZb;
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
        Wskazniki wskazniki = (Wskazniki) o;
        return Objects.equals(idWskazniki, wskazniki.idWskazniki) &&
                Objects.equals(roe, wskazniki.roe) &&
                Objects.equals(roa, wskazniki.roa) &&
                Objects.equals(ros, wskazniki.ros) &&
                Objects.equals(marzaOperacyjna, wskazniki.marzaOperacyjna) &&
                Objects.equals(roi, wskazniki.roi) &&
                Objects.equals(marzaZb, wskazniki.marzaZb) &&
                Objects.equals(idDane, wskazniki.idDane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWskazniki, roe, roa, ros, marzaOperacyjna, roi, marzaZb, idDane);
    }
}
