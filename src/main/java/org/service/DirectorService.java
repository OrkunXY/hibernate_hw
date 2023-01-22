package org.service;

import org.entity.Award;
import org.entity.Director;
import org.entity.Film;
import org.repository.DirectorDao;

import java.util.Arrays;

public class DirectorService {

    static DirectorDao directorDao=new DirectorDao();
    public static void main(String[] args) {
        //saveDirector();
        //updateDirector();
        //deleteDirector();
        directorDao.getAll();
    }
    public static void saveDirector(){
        Film film=new Film("hadi film izleyelim");
        Award award=new Award("lale sapi odulu");
        Director director=new Director("osman kurru", Arrays.asList(film),award);
        directorDao.saveDirector(director);

    }
    public static void updateDirector() {
        Film film=new Film("hadi film izleyelim guncell");
        Award award=new Award("lale sapi odulu 5423");
        Director director=new Director(1l,"osman qurru", Arrays.asList(film),award);
        directorDao.updateDirector(director);
    }
    public static void deleteDirector() {
        directorDao.deleteDirector(2l);

    }


}
