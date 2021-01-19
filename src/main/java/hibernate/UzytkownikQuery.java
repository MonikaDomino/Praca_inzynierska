package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UzytkownikQuery {
    Session session;
    Query query;

    /**
     * @param login    - user login
     * @param password - user password
     *                 return all users with login and password equals to params.
     **/

    public boolean selectByLoginandPassword(String login, String password) {
        Uzytkownik u;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Uzytkownik where login = '" + login + "'"
                + " and haslo = '" + password + "'";
        query = session.createQuery(hql);
        u = (Uzytkownik) query.uniqueResult();
        session.close();
        if (u != null) {
            return true;
        }
        return false;
    }

    public Uzytkownik selecyByLoginandPassword(String login, String password) {
        Uzytkownik u;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Uzytkownik where login = '" + login + "'"
                + " and haslo = '" + password + "'";
        query = session.createQuery(hql);
        u = (Uzytkownik) query.uniqueResult();
        session.close();
        return u;
    }

    public Uzytkownik searchPassword(String currentPassword, int idUser) {
        Uzytkownik uk = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "From Uzytkownik WHERE haslo = '" + currentPassword + "'"
                + " and idUzytkownika = '" + idUser + "'";
        query = session.createQuery(hql);
        uk = (Uzytkownik) query.uniqueResult();
        session.close();

        return uk;
    }
    public void addCompany (int idUser, int idCompany) {
        session = HibernateUtill.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Uzytkownik user = new UzytkownikQuery().showData(idUser);
                user.setIdFirmy(idCompany);
                session.update(user);
                tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }




    public Uzytkownik showData(int id_user){
        Uzytkownik u = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from Uzytkownik where idUzytkownika= '" + id_user +" '";
        query = session.createQuery(hql);
        u = (Uzytkownik) query.uniqueResult();
        session.close();
        return u;
    }

    public void register(String imie, String nazwisko, String login, String haslo, String email) {

        session = HibernateUtill.getSessionFactory().openSession();
        String query = "INSERT INTO `uzytkownik` (`id_uzytkownika`, `Imie`, `nazwisko`, `login`, `haslo`, `email`," +
                " `id_firmy`) " +
                "VALUES (NULL , '" + imie + "', '" + nazwisko + "', '" + login + "', '" + haslo + "', '"+ email+ "', NULL) ";

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

    public Uzytkownik searchEmail(String mail) {
        Uzytkownik uk = null;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "From Uzytkownik WHERE email = '" + mail + "'";
        query = session.createQuery(hql);
        uk = (Uzytkownik) query.uniqueResult();
        session.close();

        return uk;
    }



    public void changePassword(String mail, String newPasswor) {
        session = HibernateUtill.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Uzytkownik user = new UzytkownikQuery().searchEmail(mail);
            user.setHaslo(newPasswor);
            session.update(user);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}
