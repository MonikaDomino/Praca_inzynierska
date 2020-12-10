package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class DaneFinansoweQuery {
    Session session;
    Query query;

    public void addNewFinancialDataAnalysis(int year, float profitB, float economic_stocks, float profit_net,
                              float assest , float totalSales, float operationProfit, float amort, float credit,
                                    int id_company)  throws Exception {

        DaneFinansowe dataF = null;

        session = HibernateUtill.getSessionFactory().openSession();

        String query = "INSERT INTO `dane_finansowe`(`id_dane`, `rok_bilansowy`, "
                + "`zysk_brutto`, `zapasy`, `aktywa_ogolem`, `przychodyS`, `zobowiazania`, `zysk_operacyjny`,`amortyzacja` , `kapital_wlasny` , `zysk_netto`, `id_firmy`)" +
                " VALUES (NULL, '" + year + "', '" + profitB +  "', '" + economic_stocks +  "', '" + assest +  "', '" +
                + totalSales +  "', '" + operationProfit +  "', '" +credit + "', '"+ amort +  "', 0 , '" +profit_net +  "', '" + id_company + "')";


        try {
            session.getTransaction().begin();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException error){
            session.getTransaction().rollback();
            session.close();
        }
    }





}

