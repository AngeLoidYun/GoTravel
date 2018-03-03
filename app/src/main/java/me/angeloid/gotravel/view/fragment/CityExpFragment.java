package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.CityExpAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.CityExpBean;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpFragment extends BaseFragment {
    @BindView(R.id.cityexp_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static CityExpFragment newInstance() {

        Bundle args = new Bundle();

        CityExpFragment fragment = new CityExpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cityexp, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        List<CityExpBean> cityExpBeanList = new ArrayList<>();
        CityExpBean cityExpBean;
        for (int i = 0; i < 3; i++) {
            cityExpBean = new CityExpBean(R.mipmap.ic_launcher_round, "与摄影师去中山陵约片", "￥399");
            cityExpBeanList.add(cityExpBean);
            cityExpBean = new CityExpBean(R.mipmap.ic_launcher_round, "和南京小杆子喝正宗 家馄饨", "￥168");
            cityExpBeanList.add(cityExpBean);
            cityExpBean = new CityExpBean(R.mipmap.ic_launcher_round, "农家乐体验采摘草莓", "￥288");
            cityExpBeanList.add(cityExpBean);
        }

        CityExpAdapter cityExpAdapter = new CityExpAdapter(_mActivity, cityExpBeanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        recyclerView.setAdapter(cityExpAdapter);
    }
}
