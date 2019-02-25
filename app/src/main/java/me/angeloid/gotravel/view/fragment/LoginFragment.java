package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.angeloid.netlibrary.callback.AbsRxCallback;
import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.presenter.LoginFragmentPresenter;
import me.angeloid.gotravel.view.method.LoginFragmentView;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * Created by sizuru on 18-3-3.
 */

public class LoginFragment extends BaseFragment<LoginFragmentPresenter> implements LoginFragmentView {
    @BindView(R.id.login_username)
    AutoCompleteTextView userNameEt;
    @BindView(R.id.login_password)
    AutoCompleteTextView passwordEt;
    @BindView(R.id.login_sign_up)
    Button btnSignUp;
    @BindView(R.id.login_sign_in)
    Button btnSignIn;

    @Override
    protected LoginFragmentPresenter initPresenter() {
        return null;
    }

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        List<String> stringList = new ArrayList<>();
//        for (int i = 1; i < 11; i++) {
//            stringList.add(Environment.getExternalStorageDirectory()+"/goTravel/tourattr_"+i+".jpg");
//        }
//        Luban.with(getContext())
//                .load(stringList)                                   // 传人要压缩的图片列表
//                .ignoreBy(100)                                  // 忽略不压缩图片的大小
//                .setTargetDir(Environment.getExternalStorageDirectory()+"/goTravel")                        // 设置压缩后文件存储位置
//                .setCompressListener(new OnCompressListener() { //设置回调
//                    @Override
//                    public void onStart() {
//                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
//                        ToastUtils.showShort("压缩开始！");
//                    }
//
//                    @Override
//                    public void onSuccess(File file) {
//                        // TODO 压缩成功后调用，返回压缩后的图片文件
//                        ToastUtils.showShort("压缩成功！");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        // TODO 当压缩过程出现问题时调用
//                        ToastUtils.showShort("压缩失败！");
//                        e.printStackTrace();
//                    }
//                }).launch();    //启动压缩
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
//        EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        /**
         * 设置密码输入完之后按回车键的监听
         */
        userNameEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_NULL) {
                    passwordEt.requestFocus();
                    return true;
                }
                return false;
            }
        });

        passwordEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort(btnSignIn.getText() + " was clicked");
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        userNameEt.setError(null);
        passwordEt.setError(null);

        final String username = userNameEt.getText().toString();
        String password = passwordEt.getText().toString();

        View focusView = null;
        boolean cancel = false;
        if (!isPasswordValid(password)) {
            passwordEt.setError(getString(R.string.login_invalid_password));
            focusView = passwordEt;
            cancel = true;
        }

        if (TextUtils.isEmpty(username)) {
            userNameEt.setError(getString(R.string.login_field_required));
            focusView = userNameEt;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showLoading("登录中...");
            AbsRxCallback<Long> callback = new AbsRxCallback<Long>() {
                @Override
                public void onSuccess(Long model) {
                    hideLoading();
                    startWithPop(MainFragment.newInstance(username));
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
    }

    private boolean isPasswordValid(String password) {
        return !TextUtils.isEmpty(password);
    }
}
