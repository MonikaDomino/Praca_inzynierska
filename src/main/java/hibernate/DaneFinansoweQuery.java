package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;

public class DaneFinansoweQuery {
    Session session;
    Query query;

    public void addNewFinancialDataAnalysis(int year, float profitB, float economic_stocks, float profit_net,
                                            float assest, float totalSales, float operationProfit, float amort, float credit,
                                            int id_company) throws Exception {


        session = HibernateUtill.getSessionFactory().openSession();

        String query = "INSERT INTO `dane_finansowe`(`id_dane`, `rok_bilansowy`, "
                + "`zysk_brutto`, `zapasy`, `aktywa_ogolem`, `przychodyS`, `zobowiazania`, `zysk_operacyjny`,`amortyzacja` , `kapital_wlasny` , `zysk_netto`, `id_firmy`)" +
                " VALUES (NULL, '" + year + "', '" + profitB + "', '" + economic_stocks + "', '" + assest + "', '" +
                +totalSales + "', '" + operationProfit + "', '" + credit + "', '" + amort + "', 0 , '" + profit_net + "', '" + id_company + "')";


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

    public DaneFinansowe showID(int year, float profitB, float economic_stocks, float profit_net,
                       float assest, float totalSales, float operationProfit, float amort, float credit,
                       int id_company) {

        DaneFinansowe d = null;
        session = HibernateUtill.getSessionFactory().openSession();
            String hql;
            hql = "FROM DaneFinansowe as dane WHERE dane.rokBilansowy ='" +year+ "' AND dane.zyskBrutto = '" +profitB+ "' " +
                    "AND dane.zapasy = '" +economic_stocks+ "' AND dane.aktywaOgolem = '" +assest+ "' " +
                    "AND dane.przychodyS = '" +totalSales+ "' AND dane.zobowiazania = '" +credit+ "'" +
                    " AND dane.zyskOperacyjny = '" +operationProfit+ "' AND dane.amortyzacja = '" +amort+ "'" +
                    " AND dane.kapitalWlasny = '" +0+ "' AND dane.zyskNetto = '" +profit_net+ "' " +
                    "AND dane.idFirmy = '" +id_company+ "'";


            query = session.createQuery(hql);
            d = (DaneFinansowe)query.uniqueResult();
            session.close();
            return d;



        }
    }


