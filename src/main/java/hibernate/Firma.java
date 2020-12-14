package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Firma {
    private Integer idFirmy;
    private String nazwaFirmy;
    private String ulica;
    private String numerBudynku;
    private String miasto;
    private String kodPocztowy;
    private String numerLokalu;
    private Integer idUzytkownika;

    @Id
    public Integer getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(Integer idFirmy) {
        this.idFirmy = idFirmy;
    }

    @Basic
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    @Basic
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    public String getNumerBudynku() {
        return numerBudynku;
    }

    public void setNumerBudynku(String numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    @Basic
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Basic
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Basic
    public String getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    @Basic
    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
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
                Objects.equals(miasto, firma.miasto) &&
                Objects.equals(kodPocztowy, firma.kodPocztowy) &&
                Objects.equals(numerLokalu, firma.numerLokalu) &&
                Objects.equals(idUzytkownika, firma.idUzytkownika);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFirmy, nazwaFirmy, ulica, numerBudynku, miasto, kodPocztowy, numerLokalu, idUzytkownika);
    }
}
