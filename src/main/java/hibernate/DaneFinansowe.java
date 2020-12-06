package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dane_finansowe", schema = "inzynierka")
public class DaneFinansowe {
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
    private int idDane;
    private int idFirmy;

    @Basic
    @Column(name = "rok_bilansowy")
    public int getRokBilansowy() {
        return rokBilansowy;
    }

    public void setRokBilansowy(int rokBilansowy) {
        this.rokBilansowy = rokBilansowy;
    }

    @Basic
    @Column(name = "zysk_brutto")
    public double getZyskBrutto() {
        return zyskBrutto;
    }

    public void setZyskBrutto(double zyskBrutto) {
        this.zyskBrutto = zyskBrutto;
    }

    @Basic
    @Column(name = "zapasy")
    public double getZapasy() {
        return zapasy;
    }

    public void setZapasy(double zapasy) {
        this.zapasy = zapasy;
    }

    @Basic
    @Column(name = "aktywa_ogolem")
    public double getAktywaOgolem() {
        return aktywaOgolem;
    }

    public void setAktywaOgolem(double aktywaOgolem) {
        this.aktywaOgolem = aktywaOgolem;
    }

    @Basic
    @Column(name = "przychodyS")
    public double getPrzychodyS() {
        return przychodyS;
    }

    public void setPrzychodyS(double przychodyS) {
        this.przychodyS = przychodyS;
    }

    @Basic
    @Column(name = "zobowiazania")
    public double getZobowiazania() {
        return zobowiazania;
    }

    public void setZobowiazania(double zobowiazania) {
        this.zobowiazania = zobowiazania;
    }

    @Basic
    @Column(name = "zysk_operacyjny")
    public double getZyskOperacyjny() {
        return zyskOperacyjny;
    }

    public void setZyskOperacyjny(double zyskOperacyjny) {
        this.zyskOperacyjny = zyskOperacyjny;
    }

    @Basic
    @Column(name = "amortyzacja")
    public double getAmortyzacja() {
        return amortyzacja;
    }

    public void setAmortyzacja(double amortyzacja) {
        this.amortyzacja = amortyzacja;
    }

    @Basic
    @Column(name = "kapital_wlasny")
    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    @Basic
    @Column(name = "zysk_netto")
    public double getZyskNetto() {
        return zyskNetto;
    }

    public void setZyskNetto(double zyskNetto) {
        this.zyskNetto = zyskNetto;
    }

    @Id
    @Column(name = "id_dane")
    public int getIdDane() {
        return idDane;
    }

    public void setIdDane(int idDane) {
        this.idDane = idDane;
    }

    @Basic
    @Column(name = "id_firmy")
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
        return rokBilansowy == that.rokBilansowy &&
                Double.compare(that.zyskBrutto, zyskBrutto) == 0 &&
                Double.compare(that.zapasy, zapasy) == 0 &&
                Double.compare(that.aktywaOgolem, aktywaOgolem) == 0 &&
                Double.compare(that.przychodyS, przychodyS) == 0 &&
                Double.compare(that.zobowiazania, zobowiazania) == 0 &&
                Double.compare(that.zyskOperacyjny, zyskOperacyjny) == 0 &&
                Double.compare(that.amortyzacja, amortyzacja) == 0 &&
                Double.compare(that.kapitalWlasny, kapitalWlasny) == 0 &&
                Double.compare(that.zyskNetto, zyskNetto) == 0 &&
                idDane == that.idDane &&
                idFirmy == that.idFirmy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rokBilansowy, zyskBrutto, zapasy, aktywaOgolem, przychodyS, zobowiazania, zyskOperacyjny, amortyzacja, kapitalWlasny, zyskNetto, idDane, idFirmy);
    }
}
