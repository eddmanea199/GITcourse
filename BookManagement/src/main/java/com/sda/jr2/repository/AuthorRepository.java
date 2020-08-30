package com.sda.jr2.repository;

import com.sda.jr2.model.Author;
import com.sda.jr2.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {
    public Author findById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Author author = session.get(Author.class, id);
            return author;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void save(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    public void update(Author author) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void delete(Author author) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            String fromAuthors = "from Author";
            Query query = session.createQuery(fromAuthors);
            authorList = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }
    public Optional<Author>findByAuthor(Author author){
        List<Author> authorList = new ArrayList<>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            String fromAuthors = "from Author a where a.firstName =: firstName and a.lastName =: lastName and a.country =: country and a.dateOfBirth =: dateOfBirth";
            Query query = session.createQuery(fromAuthors).setParameter("firstName",author.getFirstName())
                    .setParameter("lastName",author.getLastName())
                    .setParameter("country",author)
                    .setParameter("dateOfBirth",author.getDateOfBirth());
            authorList = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
