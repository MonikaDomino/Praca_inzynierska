package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FirmaQuery {
    Session session;
    Query query;

    public void addCompany(String nameCompany, String street, String city, String postCode, String numberB,
                           String numberF) {

        session = HibernateUtill.getSessionFactory().openSession();
        String query;
        if (!numberF.equals(" ")) {
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`, `numer_lokalu`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" +postCode  + "', '"
                    + numberF + "')";
        }else{
            query = "INSERT INTO `firma` (`id_firmy`, `nazwa_firmy`, `ulica`, `numer_budynku`, `miasto`, `kod_pocztowy`) " +
                    "VALUES (NULL , '" + nameCompany + "', '" + street + "', '" + numberB + "', '" + city + "', '" + postCode +  "', '"
                   + "')";
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

    public Firma showIdCompany(String nameCompany, String street, String city, String postCode, String numberB,
                               String numberF){

        Firma f;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql;
        hql = "from Firma as company where company.nazwaFirmy ='" +nameCompany+ "' and company.ulica= '" +street+ "' " +
                "and  company.numerBudynku ='" +numberB+ "' and company.numerLokalu= '" +numberF+ "' " +
                " AND company.miasto = '" +city+ "' " +
                "AND company.kodPocztowy = '" +postCode+ "'";


        query = session.createQuery(hql);
        f = (Firma) query.setMaxResults(1).uniqueResult();
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

            query = query + " WHERE  `firma`.`id_firmy` = " + idCom;
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
