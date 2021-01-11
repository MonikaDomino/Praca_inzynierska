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
        if (numberF != " ") {
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`, `id_uzytkownika`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode + "', '" + numberF + "', '"
                    + idUser + "')";
        }else{
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`,  `id_uzytkownika`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode +  "', '"
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

    public Firma showIdCompany (String nameCompany, String street, String numberB, String numberF, String postcode,
                               String city, int idUser){

        Firma cp;
       session = HibernateUtill.getSessionFactory().openSession();
        String hql;
        hql = "from Firma as company where company.nazwaFirmy ='" +nameCompany+ "' and company.ulica= '" +street+ "' " +
                "and  company.numerBudynku ='" +numberB+ "' and  company.numerLokalu= '" +numberF+ "' " +
                "and company.kodPocztowy = '" +postcode+ "' AND company.miasto = '" +city+ "'" +
                "AND company.idUzytkownika = '" +idUser+ "'";
        query = session.createQuery(hql);
        cp = (Firma) query.uniqueResult();
        session.close();
        return cp;



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

    public Firma showCompanyData(int idCompany){
        Firma f = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Firma where idFirmy= '" + idCompany +" '";
        query = session.createQuery(hql);
        f = (Firma) query.uniqueResult();
        session.close();
        return f;
    }

    public void changeAddress(String name, String street,
                               String buildingNr, String city, String postcode, String localNumber, int idCom)
            throws Exception {

        session = HibernateUtill.getSessionFactory().openSession();

        String query = "UPDATE `firma` SET";


        if (!query.equals("UPDATE `firma` SET"))
            query += ",";

        if (name.length() > 0) {
            query = query + " `nazwa_firmy` = '" + name + "'";
        }

        if (street.length() > 0) {
            if (!query.equals("UPDATE `firma` SET"))
                query += ",";
            query = query + " `ulica` = '" + street + "'";
        }

        if (buildingNr.length() > 0) {
            if (!query.equals("UPDATE `firma` SET"))
                query += ",";
            query = query + " `numer_budynku` = '" + buildingNr + "'";
        }

        if (city.length() > 0) {
            if (!query.equals("UPDATE `firma` SET"))
                query += ",";
            query = query + " `miasto` = '" + city + "'";
        }

        if (postcode.length() > 0) {
            if (!query.equals("UPDATE `firma` SET"))
                query += ",";
            query = query + " `kod_pocztowy`= '" + postcode + "'";
        }

        if (localNumber.length() > 0) {
            if (!query.equals("UPDATE `firma` SET"))
                query += ",";
            query = query + " `numer_lokalu` = '" + localNumber + "'";
        }

        query = query + " WHERE " + " `id_firmy` = " + idCom;

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
