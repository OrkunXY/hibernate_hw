package org.service;

import org.entity.*;
import org.repository.FilmDao;
import org.utils.HibernateUtil;

import java.util.Arrays;
import java.util.List;

public class FilmService {
    static FilmDao filmDao=new FilmDao();


    public static void main(String[] args) {
        //saveFilm();
        //updateFilm();
       // deleteFilm();
        filmDao.getAll();



    }
    public static void saveFilm(){

        Actor actor=new Actor("berat acgoz");
        Award award=new Award("bart inn");
        Director director=new Director("laglum");
        Film film=new Film("f-ck",director,Arrays.asList(actor),Arrays.asList(award),new FilmCatagory("amaaan"));
        filmDao.saveFilm(film);




    }
    public static void updateFilm(){
        Actor actor=new Actor("berat acgoz");
        Award award=new Award("bart inn");
        Director director=new Director("tuncCc");
        Film film=new Film(2l,"fu*k",director,Arrays.asList(actor),Arrays.asList(award),new FilmCatagory("amaaan"));
        filmDao.updateFilm(film);


    }
    public static void deleteFilm(){
        filmDao.deleteFilm(1l);


    }


}
