package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.CityExpBean;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpAdapter extends RecyclerView.Adapter<CityExpAdapter.MyViewHolder> {
    private Context mContext;
    private List<CityExpBean> cityExpBeans;

    public CityExpAdapter(Context mContext, List<CityExpBean> cityExpBeans) {
        this.mContext = mContext;
        this.cityExpBeans = cityExpBeans;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cityexp_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(cityExpBeans.get(position).getImgResId());
        holder.description.setText(cityExpBeans.get(position).getDescription());
        holder.price.setText(cityExpBeans.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort("ssss");
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityExpBeans.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cityexp_item_main_iv)
        ImageView imageView;
        @BindView(R.id.cityexp_item_main_description)
        TextView description;
        @BindView(R.id.cityexp_item_main_price)
        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
