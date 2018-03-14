package me.angeloid.gotravel.bean;

/**
 * Created by sizuru on 18-3-5.
 */

public class PeerTourBean {
    private int imgResId;
    private String title;
    private int age;
    private String sex;

    public PeerTourBean(int imgResId, String title, int age, String sex) {
        this.imgResId = imgResId;
        this.title = title;
        this.age = age;
        this.sex = sex;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
