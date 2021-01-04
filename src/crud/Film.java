package crud;

public class Film {
    private int film_id;
    private String title;
    private int release_year;
    private String rating;
    private String description;
    private int language_id;

    public Film(int film_id, String title, int release_year, String rating, String description, int language_id) {
        this.film_id = film_id;
        this.title = title;
        this.release_year = release_year;
        this.rating = rating;
        this.description = description;
        this.language_id = language_id;
    }

    
    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }


}
