package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FirmaQuery {
    Session session;
    Query query;

    public void addCompany(String nameCompany, String street, String city, String postCode, String numberB, String numberF,
                           int idUser) {

        session = HibernateUtill.getSessionFactory().openSession();
        String query;
        if (!numberF.equals("")) {
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`, `id_uzytkownika`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode + "', '" + numberF + "', '"
                    + idUser + "')";
        }else{
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`, `id_uzytkownika`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode +  "', "
                    + "NULL, '" + idUser + "')";

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

    public Firma showCompany(int id_user){
        Firma f = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Firma where idUzytkownika= '" + id_user +" '";
        query = session.createQuery(hql);
        f = (Firma) query.uniqueResult();
        session.close();
        return f;
    }

}
