package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.CityExpResponse;
import me.angeloid.gotravel.customview.GridItemDecoration;
import me.angeloid.gotravel.util.ImageFromAssets;

/**
 * Created by sizuru on 18-3-3.
 */

public class CityExpAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private CityExpResponse cityExpResponse;
    private OnGridItemClickListener listener;


    public CityExpAdapter(Context mContext, CityExpResponse cityExpResponse, OnGridItemClickListener listener) {
        this.mContext = mContext;
        this.cityExpResponse = cityExpResponse;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cityexp_item_classify, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).titleIv.setImageBitmap(ImageFromAssets.getImageFromAssetsFile(
                cityExpResponse.getData().get(position).getTypeResId(), mContext));
        ((MyViewHolder) holder).titleTv.setText(cityExpResponse.getData().get(position).getTitle());
        ((MyViewHolder) holder).moreBtn.setText("查看更多：(" + cityExpResponse.getData().get(position).getTypeCount() + "）");
        CityExpGridListAdapter mAdapter = new CityExpGridListAdapter(mContext, cityExpResponse.getData().get(position).getEvents());
        mAdapter.setOnGridItemClickListener(listener);
        ((MyViewHolder) holder).recyclerView.setAdapter(mAdapter);
    }


    @Override
    public int getItemCount() {
        return cityExpResponse.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cityexp_item_title_iv)
        ImageView titleIv;
        @BindView(R.id.cityexp_item_title_tv)
        TextView titleTv;
        @BindView(R.id.cityexp_item_main_rv)
        RecyclerView recyclerView;
        @BindView(R.id.cityexp_item_more_btn)
        Button moreBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(),
                    CityExpGridListAdapter.SPAN_COUNT));
//            int space = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.cp_grid_item_space);
//            recyclerView.addItemDecoration(new GridItemDecoration(PickerGridListAdapter.SPAN_COUNT,
//                    space));
        }
    }

//    class TitleViewHolder extends RecyclerView.ViewHolder {
//@BindView(R.id.cityexp_item_title_iv)
//ImageView imageView;
//        public TitleViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
//
//    class MoreViewHolder extends RecyclerView.ViewHolder {
//        public MoreViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
}
