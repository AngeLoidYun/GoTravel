package me.angeloid.gotravel.view.fragment;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.CityExpAdapter;
import me.angeloid.gotravel.adapter.MyItemDecoration;
import me.angeloid.gotravel.adapter.OnItemClickListener;
import me.angeloid.gotravel.adapter.PeerTourAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.CityExpBean;
import me.angeloid.gotravel.bean.PeerTourBean;
import me.angeloid.gotravel.helper.DetailTransition;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class PeerTourFragment extends BaseFragment implements OnItemClickListener {
    @BindView(R.id.peertour_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.peertour_srl)
    SmartRefreshLayout smartRefreshLayout;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static PeerTourFragment newInstance() {

        Bundle args = new Bundle();

        PeerTourFragment fragment = new PeerTourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peertour, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableLoadmore(false);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        List<PeerTourBean> peerTourBeanList = new ArrayList<>();
        PeerTourBean peerTourBean;
        for (int i = 0; i < 55; i++) {
            peerTourBean = new PeerTourBean(R.mipmap.ic_launcher_round, "有小哥哥一起去上海迪士尼玩嘛QAQ", 21, "女");
            peerTourBeanList.add(peerTourBean);
        }
        PeerTourAdapter peerTourAdapter = new PeerTourAdapter(_mActivity, peerTourBeanList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(peerTourAdapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }

    @Override
    public void onItemClick(View v, int position, RecyclerView.ViewHolder viewHolder) {
        Logger.i(position + ":onclick");
        PeerTourDetailFragment fragment = PeerTourDetailFragment.newInstance(position);
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            fragment.setEnterTransition(new Fade());
//            fragment.setSharedElementEnterTransition(new DetailTransition());
//            fragment.setSharedElementReturnTransition(new DetailTransition());
//            ((SupportFragment) getParentFragment()).extraTransaction()
//                    .addSharedElement(
//                            ((PeerTourAdapter.PeerTourViewHolder) viewHolder).imageView,
//                            getString(R.string.transitionName1)+position
//                    )
//                    .start(fragment);
//        } else {
            ((SupportFragment) getParentFragment()).start(PeerTourDetailFragment.newInstance(position));
//        }
    }
}
