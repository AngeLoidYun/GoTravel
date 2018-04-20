package me.angeloid.gotravel.bean;

public class GroupErrandsBean {
    /**
     * 图片地址
     */
    private String imgResId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 性别0男1女2保密
     */
    private int sex;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 距离
     */
    private float distance;

    public String getImgResId() {
        return imgResId;
    }

    public void setImgResId(String imgResId) {
        this.imgResId = imgResId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
