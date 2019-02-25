package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angeloid.mvplibrary.BasePresenter;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.PeerTourBean;
import me.angeloid.gotravel.bean.PeerTourResponse;
import me.angeloid.gotravel.util.JsonParser;

/**
 * Created by Angeloid on 2018/4/23.
 */

public class PeerTourMapFragment extends BaseFragment {
    @BindView(R.id.peertour_map_back)
    ImageView backIv;
    @BindView(R.id.peertour_map_iv1)
    ImageView iv1;
    @BindView(R.id.peertour_map_iv2)
    ImageView iv2;
    @BindView(R.id.peertour_map_iv3)
    ImageView iv3;
    @BindView(R.id.peertour_map_iv4)
    ImageView iv4;
    @BindView(R.id.peertour_map_title)
    TextView mapTitle;
    @BindView(R.id.peertour_map_time)
    TextView mapTime;
    @BindView(R.id.peertour_map_place)
    TextView mapPlace;
    @BindView(R.id.peertour_map_details)
    TextView mapDetails;
@BindView(R.id.peertour_map_info)
    LinearLayout linearLayout;

    private PeerTourResponse peerTourResponse;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static PeerTourMapFragment newInstance() {

        Bundle args = new Bundle();

        PeerTourMapFragment fragment = new PeerTourMapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Gson gson = new Gson();
        peerTourResponse = gson.fromJson(JsonParser.getJson("json/peertour_1.json", _mActivity), PeerTourResponse.class);
        View view = inflater.inflate(R.layout.fragment_peertour_map, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop();
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(peerTourResponse.getData().get(0));
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(peerTourResponse.getData().get(1));
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(peerTourResponse.getData().get(2));
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(peerTourResponse.getData().get(3));
            }
        });

    }

    private void setData(PeerTourBean bean) {
        if(linearLayout.getVisibility() == View.GONE){
            linearLayout.setVisibility(View.VISIBLE);
        }
        mapTitle.setText(bean.getTitle());
        mapTime.setText(bean.getTime());
        mapPlace.setText(bean.getPlace());
        mapDetails.setText(bean.getDetails());
    }

}
