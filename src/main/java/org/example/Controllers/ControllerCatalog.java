package org.example.Controllers;

import org.example.HibernateSessionGet;
import org.example.Models.Catalog;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControllerCatalog {
    public ControllerCatalog(){}

    public Catalog getCatalogById (int id) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Catalog catalog= session.get(Catalog.class, id);
        tx.commit();
        return catalog;
    }

    public boolean addCatalog (String bookName, String authorName, int yearIssue, String style, int pages, String description ){
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.save(new Catalog(bookName, authorName, yearIssue, style, pages, description));
        tx.commit();
        return true;
    }

    public boolean removeCatalogById (int id){
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        boolean test=false;
        Catalog catalog= session.get(Catalog.class, id);
        if (catalog != null) {
            session.remove(catalog);
            test = true;
        }
        tx.commit();
        return test;
    }

    public boolean updateCatalogById (int id, String bookName, String authorName, int yearIssue, String style, int pages, String description ) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();

        Catalog catalog= session.get(Catalog.class, id);
        if (!bookName.isEmpty() || bookName!=null) catalog.setBookName(bookName);
        if (!authorName.isEmpty() || authorName!=null) catalog.setBookName(authorName);
        if (yearIssue > 0) catalog.setBookName(bookName);
        if (!style.isEmpty() || style!=null) catalog.setBookName(style);
        if (pages > 0) catalog.setBookName(bookName);
        if (!description.isEmpty() || description!=null) catalog.setBookName(description);

        tx.commit();
        return true;
    }

    public Catalog getCatalogByBookName (String bookName) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        Catalog catalog= session.get(Catalog.class, bookName);
        tx.commit();
        if (catalog != null) return catalog;
        else return null;
    }

    /*public Catalog getCatalogBySearchWord (String word) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        Catalog catalog= session.get(Catalog.class, bookName);
        tx.commit();
        if (catalog != null) return catalog;
        else return null;
    }*/

}
