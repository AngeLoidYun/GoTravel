package me.angeloid.gotravel.bean;

import java.io.Serializable;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpBean implements Serializable {

    private static final long serialVersionUID = -6919461967497580385L;

    /**
     * 活动的唯一标识
     */
    private int uid;
    /**
     * 活动所属的分类编号
     * 0:超人气体验
     * 1:新体验！实习期优惠
     * 2:亲近大自然的绿色体验
     * 3:生命在于运动
     * 4:行万里路，读万卷书
     * 5:家庭的欢乐时光
     */
    private int type;
    /**
     * 图片的resourceId，将来换成String形式的URL即可
     */
    private String resId;
    /**
     * 活动的标题
     */
    private String eventTitle;
    /**
     * 活动的时间
     */
    private String time;
    /**
     * 活动的费用
     */
    private String price;
    /**
     * 活动的星级
     */
    private int star;
    /**
     * 活动评论人的数量
     */
    private int commitCount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }
}
