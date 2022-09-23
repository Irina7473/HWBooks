package org.example.Controllers;

import org.example.HibernateSessionGet;
import org.example.Models.Catalog;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ControllerCatalog {
    public ControllerCatalog(){}

    public Catalog getCatalogById (int id) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Catalog catalog= session.get(Catalog.class, id);
        tx.commit();
        return catalog;
    }

    public boolean addCatalog (Catalog catalog ){
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.persist(catalog);
        tx.commit();
        return true;
    }

    public boolean addCatalog (String bookName, String authorName, int yearIssue, String style, int pages, String description ){
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.persist(new Catalog(bookName, authorName, yearIssue, style, pages, description));
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
        if (!authorName.isEmpty() || authorName!=null) catalog.setAuthorName(authorName);
        if (yearIssue > 0) catalog.setYearIssue(yearIssue);
        if (!style.isEmpty() || style!=null) catalog.setStyle(style);
        if (pages > 0) catalog.setPages(pages);
        if (!description.isEmpty() || description!=null) catalog.setDescription(description);

        tx.commit();
        return true;
    }

    public List<Catalog> getCatalogByBookName (String bookName) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        List<Catalog> results = session.createQuery("FROM Catalog WHERE bookName='" + bookName + "'").list();
        tx.commit();
        if (results.size() >0 ) return results;
        else return null;
    }
    //Аналогично поиск по автору, году выпуска, стилю, количеству страниц

    public List<Catalog> getCatalogBySearchWord (String word) {
        Session session = HibernateSessionGet.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();
        List <Catalog> results = session.createQuery("FROM Catalog WHERE description LIKE '%" + word + "%'").list();
        tx.commit();
        if (results != null) return results;
        else return null;
    }

}
