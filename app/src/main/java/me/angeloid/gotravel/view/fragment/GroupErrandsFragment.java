package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.GroupErrandsAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.CityExpResponse;
import me.angeloid.gotravel.bean.GroupErrandsBean;
import me.angeloid.gotravel.bean.GroupErrandsResponse;
import me.angeloid.gotravel.util.JsonParser;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class GroupErrandsFragment extends BaseFragment {
    @BindView(R.id.grouperrands_matched_rv)
    RecyclerView groupErrandsMatchedRv;
    @BindView(R.id.grouperrands_unmatched_rv)
    RecyclerView groupErrandsUnmatchedRv;

    private List<GroupErrandsBean> groupErrandsMatchedBeans;
    private List<GroupErrandsBean> groupErrandsUnmatchedBeans;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        groupErrandsMatchedBeans = gson.fromJson(JsonParser.getJson("json/groupErrands_1.json", _mActivity), GroupErrandsResponse.class).getData();
        groupErrandsUnmatchedBeans = gson.fromJson(JsonParser.getJson("json/groupErrands_2.json", _mActivity), GroupErrandsResponse.class).getData();
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
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        groupErrandsMatchedRv.setLayoutManager(manager);
        groupErrandsMatchedRv.setNestedScrollingEnabled(false);
        GroupErrandsAdapter adapter = new GroupErrandsAdapter(_mActivity, groupErrandsMatchedBeans);
        groupErrandsMatchedRv.setAdapter(adapter);

        LinearLayoutManager manager2 = new LinearLayoutManager(_mActivity);
        groupErrandsUnmatchedRv.setLayoutManager(manager2);
        groupErrandsUnmatchedRv.setNestedScrollingEnabled(false);
        GroupErrandsAdapter adapter2 = new GroupErrandsAdapter(_mActivity, groupErrandsUnmatchedBeans);
        groupErrandsUnmatchedRv.setAdapter(adapter2);

    }
}
