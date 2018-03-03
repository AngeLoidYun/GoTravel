package me.angeloid.gotravel.bean;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpBean {
    private int imgResId;
    private String description;
    private String price;

    public CityExpBean(int imgResId, String description, String price) {
        this.imgResId = imgResId;
        this.description = description;
        this.price = price;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
