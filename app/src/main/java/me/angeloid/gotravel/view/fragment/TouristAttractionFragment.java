package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class TouristAttractionFragment extends BaseFragment {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public static TouristAttractionFragment newInstance() {

        Bundle args = new Bundle();

        TouristAttractionFragment fragment = new TouristAttractionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cityexp, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
