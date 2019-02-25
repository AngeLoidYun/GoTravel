package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.PeerTourDetailAdapter;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by Angeloid on 2018/4/21.
 */

public class AttractionMessageFragment extends BaseFragment {
    @BindView(R.id.touristattr_msg_traveller)
    RecyclerView travellerRv;
    @BindView(R.id.touristattr_msg_voice)
    RecyclerView voiceRv;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static AttractionMessageFragment newInstance() {

        Bundle args = new Bundle();

        AttractionMessageFragment fragment = new AttractionMessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touristattr_msg, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        travellerRv.setLayoutManager(manager);
        travellerRv.setNestedScrollingEnabled(false);
        travellerRv.setAdapter(new PeerTourDetailAdapter(_mActivity));
        LinearLayoutManager manager1 = new LinearLayoutManager(_mActivity);
        voiceRv.setLayoutManager(manager1);
        voiceRv.setNestedScrollingEnabled(false);
        voiceRv.setAdapter(new PeerTourDetailAdapter(_mActivity));

    }
}
