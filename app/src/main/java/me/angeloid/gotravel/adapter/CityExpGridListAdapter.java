package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.CityExpBean;
import me.angeloid.gotravel.util.ImageFromAssets;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class CityExpGridListAdapter extends RecyclerView.Adapter<CityExpGridListAdapter.CityExpGridViewHolder>{
    public static final int SPAN_COUNT = 2;

    private Context mContext;
    private List<CityExpBean> events;
    private OnGridItemClickListener onGridItemClickListener;

    public CityExpGridListAdapter(Context context, List<CityExpBean> events) {
        this.mContext = context;
        this.events = events;
    }

    @Override
    public CityExpGridListAdapter.CityExpGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cityexp_item_main, parent, false);
        return new CityExpGridListAdapter.CityExpGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CityExpGridListAdapter.CityExpGridViewHolder holder, int position) {
        final int pos = holder.getAdapterPosition();
        final CityExpBean data = events.get(pos);
        if (data == null) return;
        //设置item宽高
//        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
//        int screenWidth = dm.widthPixels;
//        TypedValue typedValue = new TypedValue();
//        mContext.getTheme().resolveAttribute(R.attr.cpGridItemSpace, typedValue, true);
//        int space = mContext.getResources().getDimensionPixelSize(typedValue.resourceId);
//        int padding = mContext.getResources().getDimensionPixelSize(R.dimen.cp_default_padding);
//        int indexBarWidth = mContext.getResources().getDimensionPixelSize(R.dimen.cp_index_bar_width);
//        int itemWidth = (screenWidth - padding - space * (SPAN_COUNT - 1) - indexBarWidth) / SPAN_COUNT;
//        ViewGroup.LayoutParams lp = holder.container.getLayoutParams();
//        lp.width = itemWidth;
//        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        holder.container.setLayoutParams(lp);
        Bitmap bitmapLoaded = ImageFromAssets.getImageFromAssetsFile(data.getResId(),mContext);
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap bitmap = Bitmap.createBitmap(bitmapLoaded,0,0,bitmapLoaded.getWidth(),bitmapLoaded.getHeight(),matrix,true);
        bitmapLoaded.recycle();
        holder.titleIv.setImageBitmap(bitmap);
        holder.titleTv.setText(data.getEventTitle());
        holder.dateTv.setText(data.getTime());
        holder.priceTv.setText(data.getPrice());
        holder.starRb.setRating(data.getStar());
        holder.commitTv.setText(data.getCommitCount()+"评论");
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onGridItemClickListener != null){
                    onGridItemClickListener.onItemClick(data);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return events == null ? 0 : events.size();
    }

    public static class CityExpGridViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cityexp_item_main_container)
        LinearLayout container;
        @BindView(R.id.cityexp_item_main_iv)
        ImageView titleIv;
        @BindView(R.id.cityexp_item_main_title)
        TextView titleTv;
        @BindView(R.id.cityexp_item_main_date)
        TextView dateTv;
        @BindView(R.id.cityexp_item_main_price)
        TextView priceTv;
        @BindView(R.id.cityexp_item_main_star)
        RatingBar starRb;
        @BindView(R.id.cityexp_item_main_commitcount)
        TextView commitTv;
        public CityExpGridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setOnGridItemClickListener(OnGridItemClickListener listener){
        this.onGridItemClickListener = listener;
    }
}
