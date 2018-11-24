package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Models.DataProfilePostMe;
import com.example.lekh.bean2.Models.ModelActivityFeedIcons;
import com.example.lekh.bean2.Models.ModelIconsActivityFeed;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivityFeedIconsPlus extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ModelActivityFeedIcons> dataSet;

    Context mContext;
    int page = 0;

    private OnItemClickListener mItemClickListener;

    public interface OnClickListener { }

    public interface OnUserMenuClickListener {
        void onUserMenuClick(View view, int userPosition);}

    public AdapterActivityFeedIconsPlus(ArrayList<ModelActivityFeedIcons> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    public  class ViewPagerActivityFeedIcons extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView newimgiconsAF0;
       // private RecyclerView rvActivityFeed2;

        public ViewPagerActivityFeedIcons(View itemView) {
            super(itemView);

            newimgiconsAF0 = itemView.findViewById(R.id.imageiconsAF0);
          //  rvActivityFeed2 = itemView.findViewById(R.id.rvActivityFeed2);

            newimgiconsAF0.setOnClickListener(this);
            }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }

    public void SetOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_activity_feed_icons, parent, false);
        return new AdapterActivityFeedIconsPlus.ViewPagerActivityFeedIcons(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ModelActivityFeedIcons object = dataSet.get(position);
        if (object != null) {

            ArrayList<ModelIconsActivityFeed> modelIconsActivityFeedList = new ArrayList<>();
            modelIconsActivityFeedList.add(new ModelIconsActivityFeed(R.drawable.one));
            modelIconsActivityFeedList.add(new ModelIconsActivityFeed (R.drawable.two));
            modelIconsActivityFeedList.add(new ModelIconsActivityFeed(R.drawable.free));

            final AdapterActivityFeedIconSmall adapterActivityFeedIconSmall = new AdapterActivityFeedIconSmall(mContext, modelIconsActivityFeedList);
           // ((AdapterActivityFeedIconsPlus.ViewPagerActivityFeedIcons) holder).rvActivityFeed2.setAdapter(adapterActivityFeedIconSmall);


            ((AdapterActivityFeedIconsPlus.ViewPagerActivityFeedIcons)holder).newimgiconsAF0.setImageResource(object.imgIconAFMy);

            //((AdapterActivityFeedIconsPlus.ViewPagerActivityFeedIcons)holder).newimgiconsAF1.setImageResource(object.imageIconAFFriends);

        }
    }
    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }
}
