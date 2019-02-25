package me.angeloid.gotravel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.angeloid.gotravel.bean.CityExpBean;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public interface OnGridItemClickListener<T> {
    void onItemClick(T bean);
}
