package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sizuru on 18-3-10.
 */

public class ItemClickListener implements RecyclerView.OnItemTouchListener{

    private OnItemClickListener itemClickListener;
    private GestureDetector gestureDetector;

    public ItemClickListener(Context context, OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());
        int itemPosition = rv.getChildPosition(v);
        if(gestureDetector.onTouchEvent(e) && itemPosition >= 1){
            itemClickListener.onItemClick(v, itemPosition,null);
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
