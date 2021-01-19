package hibernate;

import java.util.Objects;

public class Analiza {
    private Integer idAnalizy;
    private Double wynikAnalizy;
    private Integer idDane;

    public Integer getIdAnalizy() {
        return idAnalizy;
    }

    public void setIdAnalizy(Integer idAnalizy) {
        this.idAnalizy = idAnalizy;
    }

    public Double getWynikAnalizy() {
        return wynikAnalizy;
    }

    public void setWynikAnalizy(Double wynikAnalizy) {
        this.wynikAnalizy = wynikAnalizy;
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
