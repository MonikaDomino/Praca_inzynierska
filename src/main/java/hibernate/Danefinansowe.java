package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Danefinansowe {
    private Integer idDane;
    private Integer rokBilansowy;
    private Double zyskBrutto;
    private Double zapasy;
    private Double aktywaOgolem;
    private Double przychodyS;
    private Double zobowiazania;
    private Double zyskOperacyjny;
    private Double amortyzacja;
    private Double kapitalWlasny;
    private Double zyskNetto;
    private Integer idFirmy;

    @Id
    @Column(name = "id_dane")
    public Integer getIdDane() {
        return idDane;
    }

    public void setIdDane(Integer idDane) {
        this.idDane = idDane;
    }

    @Basic
    @Column(name = "rok_bilansowy")
    public Integer getRokBilansowy() {
        return rokBilansowy;
    }

    public void setRokBilansowy(Integer rokBilansowy) {
        this.rokBilansowy = rokBilansowy;
    }

    @Basic
    @Column(name = "zysk_brutto")
    public Double getZyskBrutto() {
        return zyskBrutto;
    }

    public void setZyskBrutto(Double zyskBrutto) {
        this.zyskBrutto = zyskBrutto;
    }

    @Basic
    @Column(name = "zapasy")
    public Double getZapasy() {
        return zapasy;
    }

    public void setZapasy(Double zapasy) {
        this.zapasy = zapasy;
    }

    @Basic
    @Column(name = "aktywa_ogolem")
    public Double getAktywaOgolem() {
        return aktywaOgolem;
    }

    public void setAktywaOgolem(Double aktywaOgolem) {
        this.aktywaOgolem = aktywaOgolem;
    }

    @Basic
    @Column(name = "przychodyS")
    public Double getPrzychodyS() {
        return przychodyS;
    }

    public void setPrzychodyS(Double przychodyS) {
        this.przychodyS = przychodyS;
    }

    @Basic
    @Column(name = "zobowiazania")
    public Double getZobowiazania() {
        return zobowiazania;
    }

    public void setZobowiazania(Double zobowiazania) {
        this.zobowiazania = zobowiazania;
    }

    @Basic
    @Column(name = "zysk_operacyjny")
    public Double getZyskOperacyjny() {
        return zyskOperacyjny;
    }

    public void setZyskOperacyjny(Double zyskOperacyjny) {
        this.zyskOperacyjny = zyskOperacyjny;
    }

    @Basic
    @Column(name = "amortyzacja")
    public Double getAmortyzacja() {
        return amortyzacja;
    }

    public void setAmortyzacja(Double amortyzacja) {
        this.amortyzacja = amortyzacja;
    }

    @Basic
    @Column(name = "kapital_wlasny")
    public Double getKapitalWlasny() {
        return kapitalWlasny;
    }

    public void setKapitalWlasny(Double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    @Basic
    @Column(name = "zysk_netto")
    public Double getZyskNetto() {
        return zyskNetto;
    }

    public void setZyskNetto(Double zyskNetto) {
        this.zyskNetto = zyskNetto;
    }

    @Basic
    @Column(name = "id_firmy")
    public Integer getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(Integer idFirmy) {
        this.idFirmy = idFirmy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Danefinansowe that = (Danefinansowe) o;
        return Objects.equals(idDane, that.idDane) &&
                Objects.equals(rokBilansowy, that.rokBilansowy) &&
                Objects.equals(zyskBrutto, that.zyskBrutto) &&
                Objects.equals(zapasy, that.zapasy) &&
                Objects.equals(aktywaOgolem, that.aktywaOgolem) &&
                Objects.equals(przychodyS, that.przychodyS) &&
                Objects.equals(zobowiazania, that.zobowiazania) &&
                Objects.equals(zyskOperacyjny, that.zyskOperacyjny) &&
                Objects.equals(amortyzacja, that.amortyzacja) &&
                Objects.equals(kapitalWlasny, that.kapitalWlasny) &&
                Objects.equals(zyskNetto, that.zyskNetto) &&
                Objects.equals(idFirmy, that.idFirmy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDane, rokBilansowy, zyskBrutto, zapasy, aktywaOgolem, przychodyS, zobowiazania, zyskOperacyjny, amortyzacja, kapitalWlasny, zyskNetto, idFirmy);
    }
}
