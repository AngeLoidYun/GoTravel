package me.angeloid.gotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.angeloid.gotravel.R;
import me.angeloid.gotravel.bean.GroupErrandsBean;
import me.angeloid.gotravel.util.ImageFromAssets;

public class GroupErrandsAdapter extends RecyclerView.Adapter<GroupErrandsAdapter.GroupErrandsViewHolder> {

    private Context mContext;
    private List<GroupErrandsBean> groupErrandsBeans;

    public GroupErrandsAdapter(Context mContext, List<GroupErrandsBean> groupErrandsBeans) {
        this.mContext = mContext;
        this.groupErrandsBeans = groupErrandsBeans;
    }

    @Override
    public GroupErrandsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.grouperrands_item, parent, false);
        return new GroupErrandsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GroupErrandsViewHolder holder, int position) {
        holder.profileIv.setImageBitmap(ImageFromAssets.getImageFromAssetsFile(
                groupErrandsBeans.get(position).getImgResId(), mContext));
        holder.nameTv.setText(groupErrandsBeans.get(position).getUserName());
        int sex = groupErrandsBeans.get(position).getSex();
        switch (sex) {
            case 1:
                holder.sexIv.setImageResource(R.drawable.sex_female);
                break;
            case 2:
                holder.sexIv.setVisibility(View.GONE);
                break;
            default:
                break;
        }
        holder.signatureTv.setText(groupErrandsBeans.get(position).getSignature());
        holder.distanceTv.setText(groupErrandsBeans.get(position).getDistance() + "公里");
    }

    @Override
    public int getItemCount() {
        return groupErrandsBeans.size();
    }

    class GroupErrandsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.grouperrands_item_profile_iv)
        CircleImageView profileIv;
        @BindView(R.id.grouperrands_item_name)
        TextView nameTv;
        @BindView(R.id.grouperrands_item_sex_iv)
        ImageView sexIv;
        @BindView(R.id.grouperrands_item_signature)
        TextView signatureTv;
        @BindView(R.id.grouperrands_item_distance)
        TextView distanceTv;

        public GroupErrandsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
