package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.angeloid.mvplibrary.BasePresenter;
import com.blankj.utilcode.util.ToastUtils;
import com.jaren.lib.view.LikeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.MyItemDecoration;
import me.angeloid.gotravel.adapter.PeerTourDetailAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.CityExpBean;
import me.angeloid.gotravel.presenter.CityExpDetailPresenter;
import me.angeloid.gotravel.util.ImageFromAssets;
import me.angeloid.gotravel.view.method.CityExpDetailView;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpDetailFragment extends BaseFragment<CityExpDetailPresenter> implements CityExpDetailView {
    @BindView(R.id.cityexp_detail_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.cityexp_detail_srl)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.cityexp_detail_head_bg)
    ImageView titleIv;
    @BindView(R.id.cityexp_detail_title)
    TextView titleTv;
    @BindView(R.id.cityexp_detail_price)
    TextView priceTv;
    @BindView(R.id.cityexp_detail_complete)
    Button completeBtn;
    @BindView(R.id.cityexp_detail_head_likeview)
    LikeView likeView;
    @BindView(R.id.cityexp_detail_head_shareview)
    ImageView shareIv;
    private CityExpBean cityExpBean;

    @Override
    protected CityExpDetailPresenter initPresenter() {
        return new CityExpDetailPresenter(this);
    }

    public static CityExpDetailFragment newInstance(CityExpBean cityExpBean) {
        Bundle args = new Bundle();
        args.putSerializable("bean", cityExpBean);
        CityExpDetailFragment fragment = new CityExpDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cityexp_detail, container, false);
        ButterKnife.bind(this, view);
        cityExpBean = (CityExpBean) getArguments().getSerializable("bean");
        initView(view);
        return view;
    }

    private void initView(View view) {
        titleIv.setImageBitmap(ImageFromAssets.getImageFromAssetsFile(cityExpBean.getResId(), getContext()));
        titleTv.setText(cityExpBean.getEventTitle());
        priceTv.setText(cityExpBean.getPrice());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        PeerTourDetailAdapter peerTourDetailAdapter = new PeerTourDetailAdapter(getContext());
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(peerTourDetailAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        smartRefreshLayout.setEnableLoadmore(false);
        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(PayFragment.newInstance());
            }
        });
        shareIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("分享！");
            }
        });
        likeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeView.isChecked())
                    ToastUtils.showShort("已关注！");
                else
                    ToastUtils.showShort("取消关注！");
            }
        });
    }


}
