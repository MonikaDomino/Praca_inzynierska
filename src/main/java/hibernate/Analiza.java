package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "analiza__", schema = "inzynierka")
public class Analiza {
    private int idAnalizy;
    private double wynikAnalizy;
    private int idDane;

    @Id
    @Column(name = "id_analizy")
    public int getIdAnalizy() {
        return idAnalizy;
    }

    public void setIdAnalizy(int idAnalizy) {
        this.idAnalizy = idAnalizy;
    }

    @Basic
    @Column(name = "wynik_analizy")
    public double getWynikAnalizy() {
        return wynikAnalizy;
    }

    public void setWynikAnalizy(double wynikAnalizy) {
        this.wynikAnalizy = wynikAnalizy;
    }

    @Basic
    @Column(name = "id_dane")
    public int getIdDane() {
        return idDane;
    }

    public void setIdDane(int idDane) {
        this.idDane = idDane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analiza analiza = (Analiza) o;
        return idAnalizy == analiza.idAnalizy &&
                Double.compare(analiza.wynikAnalizy, wynikAnalizy) == 0 &&
                idDane == analiza.idDane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnalizy, wynikAnalizy, idDane);
    }
}
