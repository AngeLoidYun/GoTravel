package me.angeloid.gotravel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sizuru on 18-3-10.
 */

public interface OnItemClickListener {
    void onItemClick(View v, int position, RecyclerView.ViewHolder viewHolder);
}
