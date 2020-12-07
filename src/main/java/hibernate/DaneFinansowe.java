package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DaneFinansowe {
    private int idDane;
    private int rokBilansowy;
    private double zyskBrutto;
    private double zapasy;
    private double aktywaOgolem;
    private double przychodyS;
    private double zobowiazania;
    private double zyskOperacyjny;
    private double amortyzacja;
    private double kapitalWlasny;
    private double zyskNetto;
    private int idFirmy;

    @Id
    public int getIdDane() {
        return idDane;
    }

    public void setIdDane(int idDane) {
        this.idDane = idDane;
    }

    @Basic
    public int getRokBilansowy() {
        return rokBilansowy;
    }

    public void setRokBilansowy(int rokBilansowy) {
        this.rokBilansowy = rokBilansowy;
    }

    @Basic
    public double getZyskBrutto() {
        return zyskBrutto;
    }

    public void setZyskBrutto(double zyskBrutto) {
        this.zyskBrutto = zyskBrutto;
    }

    @Basic
    public double getZapasy() {
        return zapasy;
    }

    public void setZapasy(double zapasy) {
        this.zapasy = zapasy;
    }

    @Basic
    public double getAktywaOgolem() {
        return aktywaOgolem;
    }

    public void setAktywaOgolem(double aktywaOgolem) {
        this.aktywaOgolem = aktywaOgolem;
    }

    @Basic
    public double getPrzychodyS() {
        return przychodyS;
    }

    public void setPrzychodyS(double przychodyS) {
        this.przychodyS = przychodyS;
    }

    @Basic
    public double getZobowiazania() {
        return zobowiazania;
    }

    public void setZobowiazania(double zobowiazania) {
        this.zobowiazania = zobowiazania;
    }

    @Basic
    public double getZyskOperacyjny() {
        return zyskOperacyjny;
    }

    public void setZyskOperacyjny(double zyskOperacyjny) {
        this.zyskOperacyjny = zyskOperacyjny;
    }

    @Basic
    public double getAmortyzacja() {
        return amortyzacja;
    }

    public void setAmortyzacja(double amortyzacja) {
        this.amortyzacja = amortyzacja;
    }

    @Basic
    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    @Basic
    public double getZyskNetto() {
        return zyskNetto;
    }

    public void setZyskNetto(double zyskNetto) {
        this.zyskNetto = zyskNetto;
    }

    @Basic
    public int getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(int idFirmy) {
        this.idFirmy = idFirmy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaneFinansowe that = (DaneFinansowe) o;
        return idDane == that.idDane &&
                rokBilansowy == that.rokBilansowy &&
                Double.compare(that.zyskBrutto, zyskBrutto) == 0 &&
                Double.compare(that.zapasy, zapasy) == 0 &&
                Double.compare(that.aktywaOgolem, aktywaOgolem) == 0 &&
                Double.compare(that.przychodyS, przychodyS) == 0 &&
                Double.compare(that.zobowiazania, zobowiazania) == 0 &&
                Double.compare(that.zyskOperacyjny, zyskOperacyjny) == 0 &&
                Double.compare(that.amortyzacja, amortyzacja) == 0 &&
                Double.compare(that.kapitalWlasny, kapitalWlasny) == 0 &&
                Double.compare(that.zyskNetto, zyskNetto) == 0 &&
                idFirmy == that.idFirmy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDane, rokBilansowy, zyskBrutto, zapasy, aktywaOgolem, przychodyS, zobowiazania, zyskOperacyjny, amortyzacja, kapitalWlasny, zyskNetto, idFirmy);
    }
}
