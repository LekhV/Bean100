package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Models.ModelIconsActivityFeed;
import com.example.lekh.bean2.Models.ModelProfilePostsMe;
import com.example.lekh.bean2.Models.ModelRequests;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivityFeedIconSmall extends RecyclerView.Adapter<AdapterActivityFeedIconSmall.UserViewHolderIcons> {

    private LayoutInflater mInflater;
    private List<ModelIconsActivityFeed> modelIconsActivityFeeds;

    public AdapterActivityFeedIconSmall(Context context, List<ModelIconsActivityFeed> modelIconsActivityFeeds) {
        this.mInflater = LayoutInflater.from(context);
        this.modelIconsActivityFeeds = modelIconsActivityFeeds;
    }

    @Override
    public UserViewHolderIcons onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_small_fragment_activity_feed, parent, false);
        return new UserViewHolderIcons(view);
    }

    @Override
    public void onBindViewHolder(AdapterActivityFeedIconSmall.UserViewHolderIcons holder, int position) {

        ModelIconsActivityFeed user = modelIconsActivityFeeds.get(position);

        holder.newimgViewIconAFS.setImageResource(user.getImgIconsSmallAF());

    }

    @Override
    public int getItemCount() {
        return modelIconsActivityFeeds == null? 0 : modelIconsActivityFeeds.size();
    }

    public interface OnClickListener {
    }

    public class UserViewHolderIcons extends RecyclerView.ViewHolder {

        private ImageView newimgViewIconAFS;

        public UserViewHolderIcons(View itemView) {
            super(itemView);

            newimgViewIconAFS = itemView.findViewById(R.id.imageViewIconAFS);
        }
    }

}
