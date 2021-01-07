package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class AnalizaQuery {

    Session session;
    Query query;

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

    public Analiza showResult(int idData){
        Analiza a = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Analiza where idDane= '" + idData +" '";
        query = session.createQuery(hql);
        a = (Analiza) query.uniqueResult();
        session.close();
        return a;
    }
}
