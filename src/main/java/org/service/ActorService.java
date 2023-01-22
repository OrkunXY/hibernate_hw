package org.service;


import org.entity.Actor;
import org.entity.Award;
import org.entity.Director;
import org.entity.Film;
import org.repository.ActorDao;

import java.util.Arrays;

public class ActorService {
    static ActorDao actorDao=new ActorDao();

    public static void main(String[] args) {
        //saveActor();
        //updateActor();
        //actorDao.getAll();
        Film film=new Film("EFES");
        actorDao.ozelSorqu(film);
    }

    public static void saveActor(){
        Award award=new Award("Actorun odulu!!!");
        Director director=new Director("Actorun direktoruu");
        Film film=new Film("Actorun filmi");
        Actor actor=new Actor("actorun name",Arrays.asList(film),award);
        actorDao.saveActor(actor);

    }
    public static void updateActor(){
        Award award=new Award("Actorun odulu_gunceeel!!!");
        Director director=new Director("Actorun direktoruu_guncelll");
        Film film=new Film("Actorun filmi_gunceklkk");
        Actor actor=new Actor(3l,"actorun name-guncelll",Arrays.asList(film),award);
        actorDao.updateActor(actor);

    }
    public static void deleteActor(){
        actorDao.deleteActor(3l);
    }




}
