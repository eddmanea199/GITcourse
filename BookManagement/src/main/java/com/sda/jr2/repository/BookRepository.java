package com.sda.jr2.repository;

import com.sda.jr2.model.Book;
import com.sda.jr2.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public Book findById(int id){
        try(Session session= HibernateUtils.getSessionFactory().openSession();){
            Book book=session.get(Book.class,id);
            session.close();
            return book;
        }
        catch (Exception e)
        {e.printStackTrace();}
        return null;

    }
    public void save(Book book){
        Transaction transaction=null;
        try(Session session=HibernateUtils.getSessionFactory().openSession();){

            transaction=session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}

    }
    public void update(Book book){
        Transaction transaction=null;
        try(Session session=HibernateUtils.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.update(book);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}}
    public void delete(Book book){
        Transaction transaction=null;
        try(Session session=HibernateUtils.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.delete(book);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}}
    public List<Book>findAll(){
        List<Book>bookList=new ArrayList<>();
        try{
            Session session=HibernateUtils.getSessionFactory().openSession();
            String fromBooks="from Book";
            Query query=session.createQuery(fromBooks);
            bookList= query.list();
            session.close();
        }
        catch (Exception e)
        {e.printStackTrace();}
        return bookList;
    }
}
