package me.angeloid.gotravel.bean;

/**
 * Created by Angeloid on 2018/4/22.
 */

public class TouristAttractionBean {
    String name;
    String imgResId;

    public TouristAttractionBean(String name, String imgResId) {
        this.name = name;
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgResId() {
        return imgResId;
    }

    public void setImgResId(String imgResId) {
        this.imgResId = imgResId;
    }
}
