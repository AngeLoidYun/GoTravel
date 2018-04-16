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
import android.widget.Button;


import com.blankj.utilcode.util.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.presenter.MainFragmentPresenter;
import me.angeloid.gotravel.view.method.MainFragmentView;
import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 19:39 now.
 *         (#^.^#)
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentView {

    private SupportFragment[] mFragments = new SupportFragment[4];
    public static final int PHONE = 0;
    public static final int PAD = 1;
    public static final int ROBOT = 2;
    public static final int ALL = 3;
    /**
     * 启动fragment、activity的requestcode
     */
    private static final int ROBOT_TYPE_SELECT_CODE = 0x01;
    //******************************view开始*********************************
    /**
     *
     */
    @BindView(R.id.main_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.main_tablayout)
    TabLayout mTab;
    //******************************view结束*********************************

    @Override
    protected MainFragmentPresenter initPresenter() {
        return new MainFragmentPresenter(this);
    }

    public static MainFragment newInstance(String userName) {
        Bundle args = new Bundle();
        args.putString("userName", userName);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToastUtils.showShort("已登录：" + getArguments().getString("userName"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
//        EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(new MainFragmentPagerAdapter(getChildFragmentManager(),
                getString(R.string.main_tab_cityexp),
                getString(R.string.main_tab_grouperrands),
                getString(R.string.main_tab_peertour),
                getString(R.string.main_tab_touristattraction),
                getString(R.string.main_tab_personalcenter)));
        mTab.setupWithViewPager(mViewPager);
    }


//
//    private void initView(View rootView) {
//        mBtnMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startForResult(RobotTypeSelectFragment.newInstance(),ROBOT_TYPE_SELECT_CODE);
//            }
//        });
//
//        mSelectBar.addItem(new SelectBarTab(_mActivity,getString(R.string.pad)))
//                .addItem(new SelectBarTab(_mActivity,getString(R.string.phone)))
//                .addItem(new SelectBarTab(_mActivity,getString(R.string.robot)))
//                .addItem(new SelectBarTab(_mActivity,getString(R.string.whole)));
//
//        mSelectBar.setOnTabSelectedListener(new SelectBar.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(int position, int prePosition) {
//                showHideFragment(mFragments[position],mFragments[prePosition]);
//                EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position,false));
//            }
//
//            @Override
//            public void onTabUnselected(int position) {
//
//            }
//
//            @Override
//            public void onTabReselected(int position) {
//                EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position,true));
//            }
//        });
//        mSelectBar.setCurrentItem(PHONE);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        SupportFragment firstFragment = findChildFragment(MainPhoneFragment.class);
//        if(firstFragment == null){
//            mFragments[PHONE] = MainPhoneFragment.newInstance();
//            mFragments[PAD] = MainPadFragment.newInstance();
//            mFragments[ROBOT] = MainRobotFragment.newInstance();
//            mFragments[ALL] = MainAllFragment.newInstance();
//            loadMultipleRootFragment(R.id.fl_select_tab_container,PHONE,
//                    mFragments[PHONE],
//                    mFragments[PAD],
//                    mFragments[ROBOT],
//                    mFragments[ALL]);
//        }else{
//            mFragments[PHONE] = firstFragment;
//            mFragments[PAD] = findChildFragment(MainPadFragment.class);
//            mFragments[ROBOT] = findChildFragment(MainRobotFragment.class);
//            mFragments[ALL] = findChildFragment(MainAllFragment.class);
//        }
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onUpdateNumberEvent(UpdateNumberEvent event){
//        mSelectBar.getItem(event.getTabType().getIndex()).setUnreadCount(10);
//    }
//
//
//    @Override
//    public void onDestroyView() {
//        EventBusActivityScope.getDefault(_mActivity).register(this);
//        super.onDestroyView();
//    }
//
//    @Override
//    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
//        super.onFragmentResult(requestCode, resultCode, data);
//        if(requestCode == ROBOT_TYPE_SELECT_CODE && resultCode == RESULT_OK){
//
//        }
//    }


    class MainFragmentPagerAdapter extends FragmentPagerAdapter {
        private String[] mTitles;

        public MainFragmentPagerAdapter(FragmentManager fm, String... titles) {
            super(fm);
            mTitles = titles;

        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return CityExpFragment.newInstance();
            }
            if (position == 1) {
                return GroupErrandsFragment.newInstance();
            }
            if (position == 2) {
                return PeerTourFragment.newInstance();
            }
            if (position == 3) {
                return TouristAttractionFragment.newInstance();
            }
            if (position == 4) {
                return PersonalCenterFragment.newInstance();
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
