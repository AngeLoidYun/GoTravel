package me.angeloid.gotravel.bean;

import java.util.List;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class ClassifyBean {
    private String title;
    private int typeCount;
    private int type;
    private String typeResId;
    private List<CityExpBean> events;

    public ClassifyBean(String title, int typeCount, int type, String typeResId, List<CityExpBean> events) {
        this.title = title;
        this.typeCount = typeCount;
        this.type = type;
        this.typeResId = typeResId;
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(int typeCount) {
        this.typeCount = typeCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeResId() {
        return typeResId;
    }

    public void setTypeResId(String typeResId) {
        this.typeResId = typeResId;
    }

    public List<CityExpBean> getEvents() {
        return events;
    }

    public void setEvents(List<CityExpBean> events) {
        this.events = events;
    }
}
