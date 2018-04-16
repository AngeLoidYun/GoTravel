package me.angeloid.gotravel.bean;

import java.util.List;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class CityExpResponse {
    private int page;
    private List<ClassifyBean> data;

    public CityExpResponse(int page, List<ClassifyBean> data) {
        this.page = page;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ClassifyBean> getData() {
        return data;
    }

    public void setData(List<ClassifyBean> data) {
        this.data = data;
    }
}
