package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class GroupErrandsFragment extends BaseFragment {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static GroupErrandsFragment newInstance() {

        Bundle args = new Bundle();

        GroupErrandsFragment fragment = new GroupErrandsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grouperrands, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }
}
