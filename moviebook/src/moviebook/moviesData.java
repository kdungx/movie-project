
package moviebook;

import java.sql.Date;


public class moviesData {
    
    private Integer id;
    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;
    private String current;

    public moviesData(Integer id,String title, String genre, String duration, String image, Date date, String current) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.image = image;
        this.date = date;
        this.current = current;
    }

    public Integer getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getCurrent(){
        return current;
    }
}
