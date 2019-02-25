package me.angeloid.gotravel.bean;

import java.util.List;

/**
 * Created by Angeloid on 2018/4/21.
 */

public class PeerTourResponse {
    private int page;
    private List<PeerTourBean> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<PeerTourBean> getData() {
        return data;
    }

    public void setData(List<PeerTourBean> data) {
        this.data = data;
    }
}
