package me.angeloid.gotravel.bean;

/**
 * Created by sizuru on 18-3-5.
 */

public class PeerTourBean {
    private String title;
    private String time;
    private String place;
    private String details;

    public PeerTourBean(String title, String time, String place, String details) {
        this.title = title;
        this.time = time;
        this.place = place;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
