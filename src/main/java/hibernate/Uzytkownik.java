package hibernate;

import java.util.Objects;

public class Uzytkownik {
    private Integer idUzytkownika;
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private String email;
    private Integer idFirmy;

    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Uzytkownik that = (Uzytkownik) o;
        return Objects.equals(idUzytkownika, that.idUzytkownika) &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(login, that.login) &&
                Objects.equals(haslo, that.haslo) &&
                Objects.equals(email, that.email) &&
                Objects.equals(idFirmy, that.idFirmy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUzytkownika, imie, nazwisko, login, haslo, email, idFirmy);
    }
}
