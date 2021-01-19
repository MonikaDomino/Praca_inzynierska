package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DanefinansoweQuery {
    Session session;
    Query query;


    public void addNewFinancialDataAnalysis(int year, double profitB, double economic_stocks, double assest,
                                            double totalSales, double operationProfit, double credit,
                                            double amort, double capital, double profit_net, int id_company)
             {


        session = HibernateUtill.getSessionFactory().openSession();

        String query = "INSERT INTO `dane_finansowe`(`id_dane`, `rok_bilansowy`, "
                + "`zysk_brutto`, `zapasy`, `aktywa_ogolem`, `przychodyS`, `zobowiazania`, `zysk_operacyjny`," +
                "`amortyzacja` , `kapital_wlasny` , `zysk_netto`, `id_firmy`)" +
                " SELECT NULL, '" + year + "', '" + profitB + "', '" + economic_stocks + "', '" + assest + "', '" +
                +totalSales + "', '" + operationProfit + "', '" + credit + "', '" + amort + "', '" + capital + "', '"
                + profit_net + "', '" + id_company + "'FROM DUAL WHERE NOT EXISTS (SELECT " +
                "inzynierka.dane_finansowe.id_dane FROM dane_finansowe " +
                "WHERE inzynierka.dane_finansowe.rok_bilansowy = '" +year+  "' and  inzynierka.dane_finansowe.id_firmy = '" +id_company+ "')";

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

    public DaneFinansowe showID(int year, double profitB, double economic_stocks, double assest,
                                double totalSales, double credit, double operationProfit,
                                double amort, double capital, double profit_net, int id_company) {

        DaneFinansowe d;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql;
        hql = "from DaneFinansowe as dane where dane.rokBilansowy ='" +year+ "' and dane.zyskBrutto= '" +profitB+ "' " +
                "and  dane.zapasy ='" +economic_stocks+ "' and dane.aktywaOgolem= '" +assest+ "' " +
                "and dane.przychodyS = '" +totalSales+ "' AND dane.zobowiazania = '" +credit+ "'" +
                " AND dane.zyskOperacyjny = '" +operationProfit+ "' AND dane.amortyzacja = '" +amort+ "'" +
                " AND dane.kapitalWlasny = '" + capital+ "' AND dane.zyskNetto = '" +profit_net+ "' " +
                "AND dane.idFirmy = '" +id_company+ "'";


        query = session.createQuery(hql);
        d = (DaneFinansowe)query.uniqueResult();
        session.close();
        return d;

    }

    public  DaneFinansowe checkYear(int idCompany, int idData){
        DaneFinansowe dc;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from DaneFinansowe where idFirmy = '" + idCompany + "'and idDane = '" + idData + "'";
        query = session.createQuery(hql);
        dc = (DaneFinansowe)query.setMaxResults(1).uniqueResult();
        session.close();
        return dc;
    }

    public DaneFinansowe readDatafromYear (int id){
        DaneFinansowe df;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from DaneFinansowe where idDane = '" + id + "'";
        query = session.createQuery(hql);
        df = (DaneFinansowe)query.uniqueResult();
        session.close();
        return df;
    }

    public DaneFinansowe readYear (int year){
        DaneFinansowe df;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from DaneFinansowe where rokBilansowy = '" + year + "'";
        query = session.createQuery(hql);
        df = (DaneFinansowe)query.uniqueResult();
        session.close();
        return df;
    }

    public DaneFinansowe readDatafromYearComp (int year, int idCompany){
        DaneFinansowe df;
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from DaneFinansowe where idFirmy = '" + idCompany + "'and rokBilansowy = '" + year + "'";
        query = session.createQuery(hql);
        df = (DaneFinansowe)query.uniqueResult();
        session.close();
        return df;
    }



    public List<DaneFinansowe> DaneFinansoweSelectForYear(int idCompany) {
        session = HibernateUtill.getSessionFactory().openSession();
        String hql = "from DaneFinansowe where idFirmy = '" + idCompany + "'";
        Query query = session.createQuery(hql);
        List <DaneFinansowe> df = query.list();
        session.close();
        int i = 0;
        for(DaneFinansowe d : df){
            if(d.getIdFirmy() != idCompany){
                df.remove(i);
            }
            i++;
        }
        return df;

    }



}
