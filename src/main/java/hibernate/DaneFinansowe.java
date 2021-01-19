package hibernate;

import java.util.Objects;

public class DaneFinansowe {
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

    public Integer getIdDane() {
        return idDane;
    }

    public void setIdDane(Integer idDane) {
        this.idDane = idDane;
    }

    public Integer getRokBilansowy() {
        return rokBilansowy;
    }

    public void setRokBilansowy(Integer rokBilansowy) {
        this.rokBilansowy = rokBilansowy;
    }

    public Double getZyskBrutto() {
        return zyskBrutto;
    }

    public void setZyskBrutto(Double zyskBrutto) {
        this.zyskBrutto = zyskBrutto;
    }

    public Double getZapasy() {
        return zapasy;
    }

    public void setZapasy(Double zapasy) {
        this.zapasy = zapasy;
    }

    public Double getAktywaOgolem() {
        return aktywaOgolem;
    }

    public void setAktywaOgolem(Double aktywaOgolem) {
        this.aktywaOgolem = aktywaOgolem;
    }

    public Double getPrzychodyS() {
        return przychodyS;
    }

    public void setPrzychodyS(Double przychodyS) {
        this.przychodyS = przychodyS;
    }

    public Double getZobowiazania() {
        return zobowiazania;
    }

    public void setZobowiazania(Double zobowiazania) {
        this.zobowiazania = zobowiazania;
    }

    public Double getZyskOperacyjny() {
        return zyskOperacyjny;
    }

    public void setZyskOperacyjny(Double zyskOperacyjny) {
        this.zyskOperacyjny = zyskOperacyjny;
    }

    public Double getAmortyzacja() {
        return amortyzacja;
    }

    public void setAmortyzacja(Double amortyzacja) {
        this.amortyzacja = amortyzacja;
    }

    public Double getKapitalWlasny() {
        return kapitalWlasny;
    }

    public void setKapitalWlasny(Double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    public Double getZyskNetto() {
        return zyskNetto;
    }

    public void setZyskNetto(Double zyskNetto) {
        this.zyskNetto = zyskNetto;
    }

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
        DaneFinansowe that = (DaneFinansowe) o;
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
