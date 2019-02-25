package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;

/**
 * Created by Angeloid on 2018/4/21.
 */

public class TouristAttractionDetailFragment extends BaseFragment {
    @BindView(R.id.touristattr_detail_vp)
    ViewPager mViewPager;
    @BindView(R.id.touristattr_detail_tablayout)
    TabLayout mTab;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    private String name;

    public static TouristAttractionDetailFragment newInstance(String name) {

        Bundle args = new Bundle();

        TouristAttractionDetailFragment fragment = new TouristAttractionDetailFragment();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touristattr_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(new TouristAttractionDetailPagerAdapter(getChildFragmentManager(),
                getArguments().getString("name"),
                "官方景点介绍",
                "留言墙"));

        mTab.setupWithViewPager(mViewPager);
    }

    class TouristAttractionDetailPagerAdapter extends FragmentPagerAdapter {
        private String[] mTitles;
        private String name;

        public TouristAttractionDetailPagerAdapter(FragmentManager fm, String name, String... titles) {
            super(fm);
            mTitles = titles;
            this.name = name;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return AttractionIntroductionFragment.newInstance(name);
            }
            if (position == 1) {
                return AttractionMessageFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }


}
