package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AnalizaQuery {

    Session session;

    public void addNewAnalysis(int id_data, double result) {
        session = HibernateUtill.getSessionFactory().openSession();
        String query = "INSERT INTO `analiza` (`id_analizy`, wynik_analizy, id_dane) " +
                "VALUES (NULL , '" + result + "', '" + id_data + "')";

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
