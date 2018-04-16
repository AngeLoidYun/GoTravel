package com.angeloid.mvplibrary;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public interface BaseView {
    /**
     * 显示加载框
     */
    void showLoading(String str);

    void showLoading(String str,String suc);
    /**
     * 隐藏加载框
     */
    void hideLoading();

    void hideLoadingWithSuccess();
}
