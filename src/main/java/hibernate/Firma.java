package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Firma {
    private int idFirmy;
    private String nazwaFirmy;
    private String ulica;
    private int numerBudynku;
    private String miasto;
    private String kodPocztowy;
    private int numerLokalu;
    private int idUzytkownika;

    @Id
    @Column(name = "id_firmy")
    public int getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(int idFirmy) {
        this.idFirmy = idFirmy;
    }

    @Basic
    @Column(name = "nazwa_firmy")
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    @Basic
    @Column(name = "ulica")
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "numer_budynku")
    public int getNumerBudynku() {
        return numerBudynku;
    }

    public void setNumerBudynku(int numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    @Basic
    @Column(name = "miasto")
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Basic
    @Column(name = "kod_pocztowy")
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Basic
    @Column(name = "numer_lokalu")
    public int getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(int numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    @Basic
    @Column(name = "id_uzytkownika")
    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firma firma = (Firma) o;
        return idFirmy == firma.idFirmy &&
                numerBudynku == firma.numerBudynku &&
                numerLokalu == firma.numerLokalu &&
                idUzytkownika == firma.idUzytkownika &&
                Objects.equals(nazwaFirmy, firma.nazwaFirmy) &&
                Objects.equals(ulica, firma.ulica) &&
                Objects.equals(miasto, firma.miasto) &&
                Objects.equals(kodPocztowy, firma.kodPocztowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFirmy, nazwaFirmy, ulica, numerBudynku, miasto, kodPocztowy, numerLokalu, idUzytkownika);
    }
}
