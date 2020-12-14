package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Analiza {
    private Integer idAnalizy;
    private Double wynikAnalizy;
    private Integer idDane;

    @Id
    @Column(name = "id_analizy")
    public Integer getIdAnalizy() {
        return idAnalizy;
    }

    public void setIdAnalizy(Integer idAnalizy) {
        this.idAnalizy = idAnalizy;
    }

    @Basic
    @Column(name = "wynik_analizy")
    public Double getWynikAnalizy() {
        return wynikAnalizy;
    }

    public void setWynikAnalizy(Double wynikAnalizy) {
        this.wynikAnalizy = wynikAnalizy;
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
        Analiza analiza = (Analiza) o;
        return Objects.equals(idAnalizy, analiza.idAnalizy) &&
                Objects.equals(wynikAnalizy, analiza.wynikAnalizy) &&
                Objects.equals(idDane, analiza.idDane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnalizy, wynikAnalizy, idDane);
    }
}
