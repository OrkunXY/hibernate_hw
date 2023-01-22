package org.repository;

import org.entity.Director;
import org.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DirectorDao {
    SessionFactory sessionFactory;
    public void saveDirector(Director director){
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(director);
            session.getTransaction().commit();
            System.out.println("director eklendi");
            session.close();

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }

    }
    public void updateDirector(Director director) {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            session.update(director);
            session.getTransaction().commit();
            System.out.println("director guncellendi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }

    }
    public void deleteDirector(Long id) {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Director director = session.get(Director.class, id);
            session.delete(director);

            session.getTransaction().commit();
            System.out.println("director silindi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }


    }

    public void getAll(){
        List<Object[]> list=null;
        try{
            EntityManager entityManager=HibernateUtil.getSessionFactory().createEntityManager();
            String sql="select d.name as directorname, aw.name as awardname from directors as d\n" +
                    "inner join directors_films as df\n" +
                    "on df.Director_id=d.id\n" +
                    "inner join awards as aw\n" +
                    "on d.award_id=aw.id";
            list=entityManager.createNativeQuery(sql).getResultList();
            for(Object[] item:list){
                System.out.println(
                        " directors: "+ item[0]+
                        " awardname: "+ item[1]






                );
            }

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }











    }


}
