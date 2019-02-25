package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.TouristAttractionBean;
import me.angeloid.gotravel.util.ImageFromAssets;

/**
 * Created by Angeloid on 2018/4/21.
 */

public class TouristAttractionAdapter extends RecyclerView.Adapter<TouristAttractionAdapter.TouristAttractionViewHolder> {

    Context mContext;
    OnGridItemClickListener<String> onGridItemClickListener;
    List<TouristAttractionBean> touristAttractionBeans;

    public TouristAttractionAdapter(Context mContext, List<TouristAttractionBean> touristAttractionBeanList, OnGridItemClickListener<String> onGridItemClickListener) {
        this.mContext = mContext;
        this.touristAttractionBeans = touristAttractionBeanList;
        this.onGridItemClickListener = onGridItemClickListener;
    }


    @Override
    public TouristAttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.touristattraction_item, parent, false);
        return new TouristAttractionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TouristAttractionViewHolder holder, int position) {
        holder.name.setText(touristAttractionBeans.get(position).getName());
        holder.pic.setImageBitmap(ImageFromAssets.getImageFromAssetsFile(touristAttractionBeans.get(position).getImgResId(),mContext));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGridItemClickListener.onItemClick(String.valueOf(holder.name.getText()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return touristAttractionBeans.size();
    }

    class TouristAttractionViewHolder extends RecyclerView.ViewHolder {
@BindView(R.id.touristattr_item_name)
        TextView name;
@BindView(R.id.touristattr_item_pic)
        ImageView pic;
        public TouristAttractionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
