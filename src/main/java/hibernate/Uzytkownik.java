package hibernate;


import java.io.Serializable;
import java.util.Objects;

public class Uzytkownik implements Serializable {
    private Integer idUzytkownika;
    private String imie;
    private String nazwisko;
    private String login;
    private String password;
    private String email;



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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }


    @Override
    public int hashCode() {
        return Objects.hash(idUzytkownika, imie, nazwisko, login, password, email);
    }
}
