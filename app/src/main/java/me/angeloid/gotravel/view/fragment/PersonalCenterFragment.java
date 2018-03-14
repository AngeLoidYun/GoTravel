package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.MyItemDecoration;
import me.angeloid.gotravel.adapter.PersonalCenterAdapter;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class PersonalCenterFragment extends BaseFragment {
    @BindView(R.id.personal_srl)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.personal_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static PersonalCenterFragment newInstance() {

        Bundle args = new Bundle();

        PersonalCenterFragment fragment = new PersonalCenterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableLoadmore(false);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(new PersonalCenterAdapter(getContext()));
    }
}
