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
import com.google.gson.Gson;
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
import me.angeloid.gotravel.bean.CityExpResponse;
import me.angeloid.gotravel.bean.PeerTourBean;
import me.angeloid.gotravel.bean.PeerTourResponse;
import me.angeloid.gotravel.customview.SearchBar;
import me.angeloid.gotravel.helper.DetailTransition;
import me.angeloid.gotravel.util.JsonParser;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class PeerTourFragment extends BaseFragment implements OnItemClickListener {
    /**
     * 活动号召界面
     */
    @BindView(R.id.peertour_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.peertour_srl)
    SmartRefreshLayout smartRefreshLayout;
@BindView(R.id.peertour_searchbar)
    SearchBar searchBar;
    private PeerTourResponse peerTourResponse;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Gson gson = new Gson();
        peerTourResponse = gson.fromJson(JsonParser.getJson("json/peertour_1.json",_mActivity), PeerTourResponse.class);
        View view = inflater.inflate(R.layout.fragment_peertour, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        searchBar.setSearchBarListener(new SearchBar.SearchBarListener() {
            @Override
            public void locate() {
                PeerTourMapFragment peerTourMapFragment = PeerTourMapFragment.newInstance();
                ((SupportFragment) getParentFragment()).start(peerTourMapFragment,SINGLETOP);
            }

            @Override
            public void search() {

            }
        });
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableLoadmore(false);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        PeerTourAdapter peerTourAdapter = new PeerTourAdapter(_mActivity, peerTourResponse.getData(), this);
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
