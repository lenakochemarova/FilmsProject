package project.models;

public enum Genre {
    ACTION("Боевик"),
    ADVENTURE("Приключения"),
    ANIMATION("Мультфильм"),
    COMEDY("Комедия"),
    CRIME("Криминал"),
    DOCUMENTARY("Документальный"),
    DRAMA("Драма"),
    FANTASY("Фэнтези"),
    HISTORICAL("Исторический"),
    HORROR("Ужасы"),
    MUSICAL("Мюзикл"),
    MYSTERY("Детектив"),
    ROMANCE("Мелодрама"),
    SCI_FI("Научная фантастика"),
    THRILLER("Триллер"),
    WAR("Военный"),
    WESTERN("Вестерн");

    private final String russianName;

    Genre(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
