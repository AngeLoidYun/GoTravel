package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.CityExpAdapter;
import me.angeloid.gotravel.adapter.CityExpClassifyAdapter;
import me.angeloid.gotravel.adapter.MyItemDecoration;
import me.angeloid.gotravel.adapter.OnGridItemClickListener;
import me.angeloid.gotravel.adapter.OnItemClickListener;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.CityExpBean;
import me.angeloid.gotravel.bean.CityExpResponse;
import me.angeloid.gotravel.customview.SearchBar;
import me.angeloid.gotravel.util.JsonParser;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpFragment extends BaseFragment implements SearchBar.SearchBarListener {
    @BindView(R.id.cityexp_classify_rv)
    RecyclerView classifyRv;
    @BindView(R.id.cityexp_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.cityexp_searchbar)
    SearchBar searchBar;

    private CityExpResponse cityExpResponse;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        cityExpResponse = gson.fromJson(JsonParser.getJson("json/cityexp_1.json",_mActivity), CityExpResponse.class);
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
        searchBar.setSearchBarListener(this);
        CityExpClassifyAdapter cityExpClassifyAdapter = new CityExpClassifyAdapter(_mActivity, cityExpResponse, new CityExpClassifyAdapter.OnClassifyItemClickListener() {
            @Override
            public void onItemClick(String classify) {
                ToastUtils.showShort(classify);
            }
        });
        LinearLayoutManager horizontalManager = new LinearLayoutManager(_mActivity,LinearLayoutManager.HORIZONTAL,false);
        classifyRv.setLayoutManager(horizontalManager);
        classifyRv.setAdapter(cityExpClassifyAdapter);


        CityExpAdapter cityExpAdapter = new CityExpAdapter(_mActivity, cityExpResponse, new OnGridItemClickListener() {
            @Override
            public void onItemClick(CityExpBean expBean) {
                CityExpDetailFragment cityExpDetailFragment = CityExpDetailFragment.newInstance(expBean);
                ((SupportFragment) getParentFragment()).start(cityExpDetailFragment);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(cityExpAdapter);


    }

    @Override
    public void locate() {
        ((SupportFragment) getParentFragment()).start(CityPickerFragment.newInstance());
    }

    @Override
    public void search() {

    }
}
