package hibernate;

import java.util.Objects;

public class Wskazniki {
    private Integer idWskazniki;
    private Double roe;
    private Double roa;
    private Double ros;
    private Double marzaOperacyjna;
    private Double roi;
    private Double marzaZb;
    private Integer idDane;

    public Integer getIdWskazniki() {
        return idWskazniki;
    }

    public void setIdWskazniki(Integer idWskazniki) {
        this.idWskazniki = idWskazniki;
    }

    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    public Double getRoa() {
        return roa;
    }

    public void setRoa(Double roa) {
        this.roa = roa;
    }

    public Double getRos() {
        return ros;
    }

    public void setRos(Double ros) {
        this.ros = ros;
    }

    public Double getMarzaOperacyjna() {
        return marzaOperacyjna;
    }

    public void setMarzaOperacyjna(Double marzaOperacyjna) {
        this.marzaOperacyjna = marzaOperacyjna;
    }

    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    public Double getMarzaZb() {
        return marzaZb;
    }

    public void setMarzaZb(Double marzaZb) {
        this.marzaZb = marzaZb;
    }

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
