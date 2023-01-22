package org.repository;

import org.entity.Actor;
import org.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActorDao {
    SessionFactory sessionFactory;
    Transaction transaction=null;
    Session session;

    public void saveActor(Actor actor){
    try(Session session= HibernateUtil.getSessionFactory().openSession()){
       session.beginTransaction();
       session.save(actor);
       session.getTransaction().commit();
        System.out.println("actor eklendi");
        session.close();
    }catch (Exception ex){
        System.out.println(ex.getStackTrace());
        ex.printStackTrace();
    }

}
    public void updateActor(Actor actor){
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            session.update(actor);
            session.getTransaction().commit();
            System.out.println("actor guncellendi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }
    }

    public void deleteActor(Long id) {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Actor actor = session.get(Actor.class, id);
            session.delete(actor);

            session.getTransaction().commit();
            System.out.println("film silindi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }


    }

    public void getAll() {
        List<Object[]> list = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select act.name as actorname, f.name as filmname, aw.name from actors as act\n" +
                    "inner join actors_films as af\n" +
                    "on af.actor_id=act.id\n" +
                    "inner join films as f\n" +
                    "on f.id=act.id\n" +
                    "inner join awards as aw\n" +
                    "on aw.id= act.id";
            list=entityManager.createNativeQuery(sql).getResultList();
            for(Object[] item:list){
                System.out.println("actorname: "+ item[0]+
                        " filmname: "+ item[1]+
                        " awardname: "+ item[2]






                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }
    }

    public void ozelSorqu(Film film){
        List<Object[]> list=null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            String sql="select f.name as filmname, d.name as directorname, aw.name as awardname,ac.name as actorname, fc.name as categoryname from films as f \n" +
                    "inner join films_actors as fa\n" +
                    "on fa.Film_id=f.id\n" +
                    "inner join actors as ac\n" +
                    "on fa.actors_id= ac.id\n" +
                    "inner join films_awards as faw\n" +
                    "on faw.Film_id=f.id\n" +
                    "inner join awards as aw\n" +
                    "on faw.award_id=aw.id\n" +
                    "inner join filmcatagory as fc\n" +
                    "on fc.id=f.id\n" +
                    "inner join directors as d\n" +
                    "on d.id= f.director_id\n" +
                    "WHERE f.name = :sql1";
            Query query = session.createNativeQuery(sql);
            query.setParameter("sql1", film.getName());
            list= query.getResultList();


            for(Object[] item:list){
                System.out.println( "filmname: "+ item[0]);
            }

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }

    }
}
