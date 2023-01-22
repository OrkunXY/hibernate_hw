package org.repository;

import org.entity.Actor;
import org.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class FilmDao {
    SessionFactory sessionFactory;
    public void saveFilm(Film film) {
        Transaction transaction=null;
try (Session session= HibernateUtil.getSessionFactory().openSession()){
    transaction=session.beginTransaction();
    session.save(film);
    session.getTransaction().commit();
    System.out.println("film eklendi");
    session.close();

}catch (Exception ex){
    System.out.println(ex.getStackTrace());
    ex.printStackTrace();
}

    }
    public void updateFilm(Film film) {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            session.update(film);
            session.getTransaction().commit();
            System.out.println("film guncellendi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }

    }
    public void deleteFilm(Long id) {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Film film = session.get(Film.class, id);
            session.delete(film);

            session.getTransaction().commit();
            System.out.println("film silindi");
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }


    }
    public List<Film> getFilms() {
        Session session = sessionFactory.getCurrentSession();
        Query<Film> query = session.createQuery("from Film", Film.class);
        return query.getResultList();
    }
    public Film getFilm(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Film film = session.get(Film.class, id);
        return film;
    }
    public List<Actor> getActors(String filmName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Actor> query = session.createQuery("from Actor where film.name = :filmName", Actor.class);
        query.setParameter("filmName", filmName);
        return query.getResultList();
    }
    public void getAll(){
        List<Object[]> list=null;
        try{
            EntityManager entityManager=HibernateUtil.getSessionFactory().createEntityManager();
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
                    "on d.id= f.director_id";
            list=entityManager.createNativeQuery(sql).getResultList();
            for(Object[] item:list){
                System.out.println( "filmname: "+ item[0]+
                        " directors: "+ item[1]+
                        " actors: "+ item[2]+
                        " awardname: "+ item[3]+
                        " filmcatagory: "+item[4]





                );
            }

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }







    }







}
