package me.angeloid.gotravel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.mvplibrary.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.adapter.OnGridItemClickListener;
import me.angeloid.gotravel.adapter.TouristAttractionAdapter;
import me.angeloid.gotravel.base.BaseFragment;
import me.angeloid.gotravel.bean.TouristAttractionBean;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by sizuru on 18-3-3.
 */

public class TouristAttractionFragment extends BaseFragment {
    @BindView(R.id.touristattr_rv)
    RecyclerView touristAttractionRv;

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
        View view = inflater.inflate(R.layout.fragment_touristattr, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        GridLayoutManager manager = new GridLayoutManager(_mActivity, 2);
        touristAttractionRv.setLayoutManager(manager);
        touristAttractionRv.setNestedScrollingEnabled(false);
        List<TouristAttractionBean> list = new ArrayList<>();
        TouristAttractionBean touristAttractionBean = new TouristAttractionBean("中山陵","img/tourattr_1.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("总统府","img/tourattr_2.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("夫子庙","img/tourattr_3.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("玄武湖","img/tourattr_4.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("明孝陵","img/tourattr_5.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("南京大屠杀纪念馆","img/tourattr_6.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("雨花台","img/tourattr_7.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("鸡鸣寺","img/tourattr_8.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("夫子庙秦淮河风光带","img/tourattr_9.jpg");
        list.add(touristAttractionBean);
        touristAttractionBean = new TouristAttractionBean("南京博物院","img/tourattr_10.jpg");
        list.add(touristAttractionBean);
        TouristAttractionAdapter adapter = new TouristAttractionAdapter(_mActivity,list,new OnGridItemClickListener<String>() {
            @Override
            public void onItemClick(String bean) {
                TouristAttractionDetailFragment touristAttractionDetailFragment = TouristAttractionDetailFragment.newInstance(bean);
                ((SupportFragment) getParentFragment()).start(touristAttractionDetailFragment);
            }
        });
        touristAttractionRv.setAdapter(adapter);
    }
}
