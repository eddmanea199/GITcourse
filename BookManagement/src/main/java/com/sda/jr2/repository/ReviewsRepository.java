package com.sda.jr2.repository;

import com.sda.jr2.model.Book;
import com.sda.jr2.model.Reviews;
import com.sda.jr2.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReviewsRepository {
    public Reviews findById(int Id){
        try{
            Session session= HibernateUtils.getSessionFactory().openSession();
            Reviews reviews=session.get(Reviews.class,Id);
            session.close();
            return reviews;
        }
        catch (Exception e)
        {e.printStackTrace();}
        return null;
    }
    public void save(Reviews reviews){
        Transaction transaction=null;
        try{
            Session session=HibernateUtils.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(reviews);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}}
    public void update(Reviews reviews){
        Transaction transaction=null;
        try{
            Session session=HibernateUtils.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.update(reviews);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}}
    public void delete(Reviews reviews){
        Transaction transaction=null;
        try{
            Session session=HibernateUtils.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.delete(reviews);
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {if (transaction!=null)
        {transaction.rollback();}
            e.printStackTrace();}}
    public List<Reviews>findAll(){
        List<Reviews>reviewsList=new ArrayList<>();
        try{
            Session session=HibernateUtils.getSessionFactory().openSession();
            String fromReviews="from Reviews";
            Query query= session.createQuery(fromReviews);
            reviewsList= query.list();
            session.close();
        }
        catch (Exception e)
        {e.printStackTrace();}
        return reviewsList;
    }
}
