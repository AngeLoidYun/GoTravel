package me.angeloid.gotravel.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.angeloid.mvplibrary.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.MyItemDecoration;
import me.angeloid.gotravel.adapter.MyLinearLayoutManager;
import me.angeloid.gotravel.adapter.PeerTourDetailAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.presenter.PeerTourDetailPresenter;
import me.angeloid.gotravel.view.method.PeerTourDetailView;

/**
 * Created by sizuru on 18-3-5.
 */

public class PeerTourDetailFragment extends BaseFragment<PeerTourDetailPresenter> implements PeerTourDetailView {

    @BindView(R.id.peertour_detail_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.peertourdetail_srl)
    SmartRefreshLayout smartRefreshLayout;
@BindView(R.id.peertourdetail_head)
    ImageView imageView;
    @Override
    protected PeerTourDetailPresenter initPresenter() {
        return new PeerTourDetailPresenter(this);
    }

    public static PeerTourDetailFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("number",position);
        PeerTourDetailFragment fragment = new PeerTourDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            setSharedElementReturnTransition(TransitionInflater.from(getContext())
            .inflateTransition(android.R.transition.move));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peertour_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        imageView.setTransitionName(getString(R.string.transitionName1)+getArguments().getInt("number"));
        PeerTourDetailAdapter peerTourDetailAdapter = new PeerTourDetailAdapter(getContext());
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(peerTourDetailAdapter);
        smartRefreshLayout.setEnableLoadmore(false);
    }


}
