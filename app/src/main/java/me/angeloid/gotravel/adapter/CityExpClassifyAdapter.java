package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.CityExpResponse;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class CityExpClassifyAdapter extends RecyclerView.Adapter<CityExpClassifyAdapter.CityExpClassifyViewHolder> {
    Context mContext;
    CityExpResponse cityExpResponse;
    OnClassifyItemClickListener onClassifyItemClickListener;

    public CityExpClassifyAdapter(Context mContext, CityExpResponse cityExpResponse, OnClassifyItemClickListener onClassifyItemClickListener) {
        this.mContext = mContext;
        this.cityExpResponse = cityExpResponse;
        this.onClassifyItemClickListener = onClassifyItemClickListener;
    }

    @Override
    public CityExpClassifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cityexp_top_classify_item,parent,false);
        return new CityExpClassifyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityExpClassifyViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClassifyItemClickListener != null){
                    onClassifyItemClickListener.onItemClick(cityExpResponse.getData().get(position).getTitle());
                }
            }
        });
        holder.classifyTv.setText(cityExpResponse.getData().get(position).getTitle());
//        holder.classifyIv.setImageResource();
    }

    @Override
    public int getItemCount() {
        return cityExpResponse.getData().size();
    }

    class CityExpClassifyViewHolder extends RecyclerView.ViewHolder {
@BindView(R.id.cityexp_item_classify_name)
        TextView classifyTv;
@BindView(R.id.cityexp_item_classify_iv)
        ImageView classifyIv;
        public CityExpClassifyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public interface OnClassifyItemClickListener {
        void onItemClick(String classify);
    }
}
