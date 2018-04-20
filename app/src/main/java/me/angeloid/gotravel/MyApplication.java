package me.angeloid.gotravel;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.angeloid.baselibrary.BaseManager;
import com.angeloid.netlibrary.HttpManager;
import com.baidu.mapapi.SDKInitializer;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.leakcanary.LeakCanary;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * Created by sizuru on 18-3-3.
 */

public class MyApplication extends Application {
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        Fragmentation.builder()
                // show stack view. Mode: BUBBLE, SHAKE, NONE
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
             .install();
        LeakCanary.install(this);
        BaseManager.init(this,"---BraveMade---",true);
        HttpManager.init(this,GlobalConfig.BASE_URL,GlobalConfig.BASE_URL_OLD);
        SDKInitializer.initialize(getApplicationContext());
    }
}
