package me.angeloid.gotravel.adapter;

import me.angeloid.gotravel.bean.locate.City;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
