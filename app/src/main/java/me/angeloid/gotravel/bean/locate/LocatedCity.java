package me.angeloid.gotravel.bean.locate;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class LocatedCity extends City {

    public LocatedCity(String name, String province, String code) {
        super(name, province, "定位城市", code);
    }
}
