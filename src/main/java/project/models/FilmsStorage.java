package project.models;

import java.util.ArrayList;
import java.util.List;


public class FilmsStorage {

    private static List<Film> films = new ArrayList<>();

//    static {
//        films.add(new Film("1", "Avatar", Genre.FANTASY));
//        films.add(new Film("2", "Remember", Genre.THRILLER));
//        films.add(new Film("3", "Scream", Genre.HORROR));
//    }

    public static List<Film> getFilms() {
        return films;
    }
}
