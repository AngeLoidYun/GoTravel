package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.netlibrary.callback.AbsRxCallback;
import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class PayFragment extends BaseFragment {
    @BindView(R.id.pay_srl)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.pay_back)
    TextView backTv;
    @BindView(R.id.pay_confirm)
    Button confirmBtn;
    @BindView(R.id.pay_zfb_rb)
    RadioButton zfbRb;
    @BindView(R.id.pay_wx_rb)
    RadioButton wxRb;
    @BindView(R.id.pay_zfb_rl)
    RelativeLayout zfbRl;
    @BindView(R.id.pay_wx_rl)
    RelativeLayout wxRl;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static PayFragment newInstance() {

        Bundle args = new Bundle();

        PayFragment fragment = new PayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        smartRefreshLayout.setEnableLoadmore(false);
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        wxRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wxRb.setChecked(true);
                zfbRb.setChecked(false);
            }
        });
        zfbRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wxRb.setChecked(false);
                zfbRb.setChecked(true);
            }
        });
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading("支付中...", "支付成功！");
                AbsRxCallback<Long> callback = new AbsRxCallback<Long>() {
                    @Override
                    public void onSuccess(Long model) {
                        hideLoadingWithSuccess();
                        pop();
                    }

                    @Override
                    public void onFailure(String errorCode, String errorMsg) {

                    }

                    @Override
                    public void onFinish() {

                    }
                };
                Observable<Long> observable = Observable.timer(2, TimeUnit.SECONDS);
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(callback);
            }
        });
    }


    ;
}
