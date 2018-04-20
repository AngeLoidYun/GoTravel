package me.angeloid.gotravel.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class SearchBar extends LinearLayout {
    @BindView(R.id.searchbar_locate)
    ImageView locateIv;
    @BindView(R.id.searchbar_search)
    Button searchBtn;

    SearchBarListener mSearchBarListener;

    public SearchBar(Context context) {
        super(context);
        initView(context);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_searchbar, SearchBar.this);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        locateIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSearchBarListener != null){
                    mSearchBarListener.locate();
                }
            }
        });
        searchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSearchBarListener != null){
                    mSearchBarListener.search();
                }
            }
        });
    }

    public void setSearchBarListener(SearchBarListener searchBarListener){
        this.mSearchBarListener = searchBarListener;
    }

    public interface SearchBarListener{
        void locate();
        void search();
    }

}
