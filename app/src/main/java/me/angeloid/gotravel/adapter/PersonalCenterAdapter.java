package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.angeloid.gotravel.R;

/**
 * Created by sizuru on 18-3-10.
 */

public class PersonalCenterAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public PersonalCenterAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemViewTypeEnum.FIRST) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.personal_top_item, parent, false);
            return new PersonalTopViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.personal_normal_item, parent, false);
            return new PersonalNormalViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PersonalNormalViewHolder) {
            PersonalNormalViewHolder viewHolder = (PersonalNormalViewHolder) holder;
            if (position == 1) {
                viewHolder.textView.setText("通知");
            } else if (position == 2) {
                viewHolder.textView.setText("邀请好友");
            } else if (position == 3) {
                viewHolder.textView.setText("发起约游");
            } else if (position == 4) {
                viewHolder.textView.setText("设置");
            } else if (position == 5) {
                viewHolder.textView.setText("获取帮助");
            } else if (position == 6) {
                viewHolder.textView.setText("向我们反馈");
            }
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ItemViewTypeEnum.FIRST;
        } else {
            return ItemViewTypeEnum.NORMAL;
        }
    }

    class PersonalTopViewHolder extends RecyclerView.ViewHolder {

        public PersonalTopViewHolder(View itemView) {
            super(itemView);
        }
    }

    class PersonalNormalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.personal_normal_item_tv)
        TextView textView;

        public PersonalNormalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class ItemViewTypeEnum {
        static int FIRST = 1;
        static int NORMAL = 0;
    }
}
