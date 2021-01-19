package hibernate;

import java.util.Objects;

public class Firma {
    private Integer idFirmy;
    private String nazwaFirmy;
    private String ulica;
    private String numerBudynku;
    private String numerLokalu;
    private String miasto;
    private String kodPocztowy;

    public Integer getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(Integer idFirmy) {
        this.idFirmy = idFirmy;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerBudynku() {
        return numerBudynku;
    }

    public void setNumerBudynku(String numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    public String getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firma firma = (Firma) o;
        return Objects.equals(idFirmy, firma.idFirmy) &&
                Objects.equals(nazwaFirmy, firma.nazwaFirmy) &&
                Objects.equals(ulica, firma.ulica) &&
                Objects.equals(numerBudynku, firma.numerBudynku) &&
                Objects.equals(numerLokalu, firma.numerLokalu) &&
                Objects.equals(miasto, firma.miasto) &&
                Objects.equals(kodPocztowy, firma.kodPocztowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFirmy, nazwaFirmy, ulica, numerBudynku, numerLokalu, miasto, kodPocztowy);
    }
}
