package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.angeloid.mvplibrary.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by Angeloid on 2018/4/21.
 */

public class AttractionIntroductionFragment extends BaseFragment {
    @BindView(R.id.touristattr_intro_title)
    TextView titleTv;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static AttractionIntroductionFragment newInstance(String title) {

        Bundle args = new Bundle();

        AttractionIntroductionFragment fragment = new AttractionIntroductionFragment();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touristattr_intro, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        titleTv.setText(getArguments().getString("title"));
    }
}
