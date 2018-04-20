package me.angeloid.gotravel.bean;

import java.util.List;

public class GroupErrandsResponse {
    private int page;
    private List<GroupErrandsBean> data;

    public GroupErrandsResponse(int page, List<GroupErrandsBean> data) {
        this.page = page;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<GroupErrandsBean> getData() {
        return data;
    }

    public void setData(List<GroupErrandsBean> data) {
        this.data = data;
    }
}
