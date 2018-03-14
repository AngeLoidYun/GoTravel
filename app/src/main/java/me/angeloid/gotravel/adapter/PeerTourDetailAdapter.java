package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.angeloid.gotravel.R;

/**
 * Created by sizuru on 18-3-10.
 */

public class PeerTourDetailAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public PeerTourDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.peertour_detail_item,parent,false);
        return new PeerTourDetailDynamicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class PeerTourDetailDynamicViewHolder extends RecyclerView.ViewHolder{

        public PeerTourDetailDynamicViewHolder(View itemView) {
            super(itemView);
        }
    }
}
