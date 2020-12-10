package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FirmaQuery {

    Session session;

    public void addCompany(String nameCompany, String street, String city, String postCode, int numberB, int numberF,
                           int idUser) {

        session = HibernateUtill.getSessionFactory().openSession();
        String query;
        if (numberF != 0) {
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`, `id_uzytkownika`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode + "', '" + numberF + "', '"
                    + idUser + "')";
        }else{
                query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`, `id_uzytkownika`) " +
                        "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode + "', 0 , '"
                        + idUser + "')";

            }
            try {
                session.getTransaction().begin();
                session.createSQLQuery(query).executeUpdate();
                session.getTransaction().commit();
                session.close();
            } catch (HibernateException error) {
                session.getTransaction().rollback();
                session.close();
            }
        }


    }

