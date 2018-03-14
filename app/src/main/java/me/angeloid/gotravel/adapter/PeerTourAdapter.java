package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.PeerTourBean;

/**
 * Created by sizuru on 18-3-5.
 */

public class PeerTourAdapter extends RecyclerView.Adapter<PeerTourAdapter.PeerTourViewHolder> {
    private Context context;
    private List<PeerTourBean> peerTourBeans;
    private OnItemClickListener onItemClickListener;

    public PeerTourAdapter(Context context, List<PeerTourBean> peerTourBeans, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.peerTourBeans = peerTourBeans;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public PeerTourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.peertour_item, parent, false);
        return new PeerTourViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PeerTourViewHolder holder, int position) {
        holder.title.setText(peerTourBeans.get(position).getTitle());
        holder.sex.setText(peerTourBeans.get(position).getSex());
        holder.age.setText(String.valueOf(peerTourBeans.get(position).getAge()));
        // 把每个图片视图设置不同的Transition名称, 防止在一个视图内有多个相同的名称, 在变换的时候造成混乱
        // Fragment支持多个View进行变换, 使用适配器时, 需要加以区分
        ViewCompat.setTransitionName(holder.imageView, context.getResources().getString(R.string.transitionName1) + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view, holder.getAdapterPosition(), holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peerTourBeans.size();
    }

    public class PeerTourViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.peertour_item_main_iv)
        public ImageView imageView;
        @BindView(R.id.peertour_item_title)
        TextView title;
        @BindView(R.id.peertour_item_sex)
        TextView sex;
        @BindView(R.id.peertour_item_age)
        TextView age;

        public PeerTourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
