package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.angeloid.gotravel.R;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class CityExpClassifyAdapter extends RecyclerView.Adapter<CityExpClassifyAdapter.CityExpClassifyViewHolder> {
    Context mContext;

    @Override
    public CityExpClassifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cityexp_top_classify_item,parent,false);
        return new CityExpClassifyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityExpClassifyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CityExpClassifyViewHolder extends RecyclerView.ViewHolder {

        public CityExpClassifyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
