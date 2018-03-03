package com.angeloid.mvplibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public abstract class MvpActivity<P extends  BasePresenter>extends SupportActivity implements BaseView{
    protected P presenter;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        if(presenter != null){
            presenter.detachView();
            presenter = null;
        }
        super.onDestroy();
    }

    protected abstract P initPresenter();

    @Override
    public abstract void showLoading(String str);

    @Override
    public abstract void hideLoading();
}
