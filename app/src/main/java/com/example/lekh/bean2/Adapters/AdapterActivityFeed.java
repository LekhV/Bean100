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
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivityFeed extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataProfilePostMe> dataSetAF;
    Context mContext;
    int page = 0;

    private OnItemClickListener mItemClickListener;
    private OnUserMenuClickListener onUserMenuClickListener;

    public AdapterActivityFeed( ArrayList<DataProfilePostMe> dataSetAF,Context mContext, OnUserMenuClickListener onUserMenuClickListener) {
        this.dataSetAF = dataSetAF;
        this.mContext = mContext;
        this.onUserMenuClickListener = onUserMenuClickListener;
    }

    public interface OnClickListener { }

    public interface OnUserMenuClickListener {
        void onUserMenuClick(View view, int userPosition);}

    public  class ViewPagerViewHolderActivityFeed extends RecyclerView.ViewHolder implements View.OnClickListener {
        ViewPager afViewPager;
        TabLayout afindicator;

        ImageView newimgIconAF;
        TextView newnameAF;
        TextView newdataAF;

        ImageView userMenuAF;

        TextView newpostAF;

        private ImageView newimgLikeAF;
        private ImageView newimgIconAF1;
        private ImageView newimgIconAF2;
        private ImageView newimgIconAF3;
        private ImageView newimgCommentAF;

        private TextView newnameAF2;
        private TextView newandAF;
        private TextView newnumberAF;
        private TextView newothersAF;
        private TextView newnumberTextAF;

        public ViewPagerViewHolderActivityFeed(View itemView) {
            super(itemView);
            afViewPager = (ViewPager) itemView.findViewById(R.id.viewPagerAF);
            afindicator = (TabLayout) itemView.findViewById(R.id.indicatorAF);

            newimgIconAF = itemView.findViewById(R.id.imageViewIconAF);
            newnameAF = itemView.findViewById(R.id.textViewNameAFOne);
            newdataAF = itemView.findViewById(R.id.textViewDataAF);

            newpostAF = itemView.findViewById(R.id.textViewPostAF);

            newimgLikeAF = itemView.findViewById(R.id.imageViewLikeAF);
            newimgIconAF1 = itemView.findViewById(R.id.imageViewIconAF1);
            newimgIconAF2 = itemView.findViewById(R.id.imageViewAF2);
            newimgIconAF3 = itemView.findViewById(R.id.imageViewAF3);
            newimgCommentAF = itemView.findViewById(R.id.imageViewCommentAF);

            newnameAF2 = itemView.findViewById(R.id.textViewNameAF2);
            newandAF = itemView.findViewById(R.id.textViewAndAF);
            newnumberAF = itemView.findViewById(R.id.textViewNumberAF);
            newothersAF = itemView.findViewById(R.id.textViewOthersAF);
            newnumberTextAF = itemView.findViewById(R.id.textViewNumberTextAF);

            userMenuAF = itemView.findViewById(R.id.menuCircleActivityFeed);
            userMenuAF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onUserMenuClickListener != null) {
                        onUserMenuClickListener.onUserMenuClick(view, getAdapterPosition());
                    }
                }
            });

            newimgIconAF.setOnClickListener(this);
            newnameAF.setOnClickListener(this);
            newdataAF.setOnClickListener(this);

            newpostAF.setOnClickListener(this);
            newimgLikeAF.setOnClickListener(this);
            newimgCommentAF.setOnClickListener(this);

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
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_activity_feed, parent, false);
        return new AdapterActivityFeed.ViewPagerViewHolderActivityFeed(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        DataProfilePostMe object = dataSetAF.get(position);
        if (object != null) {

            List<ModelSlider> modelSliderList = new ArrayList<>();
            modelSliderList.add(new ModelSlider(R.drawable.imageevents));
            modelSliderList.add(new ModelSlider (R.drawable.makarons));
            modelSliderList.add(new ModelSlider (R.drawable.imageevents));

            AdapterSliderPosts sliderPagerAdapter = new AdapterSliderPosts(mContext, modelSliderList);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed) holder).afViewPager.setAdapter(sliderPagerAdapter);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed) holder).afindicator.setupWithViewPager(((AdapterActivityFeed.ViewPagerViewHolderActivityFeed) holder).afViewPager, true);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed) holder).afViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
                @Override
                public void onPageSelected(int position) { page = position; }
                @Override
                public void onPageScrollStateChanged(int state) { }
            });

            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgIconAF.setImageResource(object.imgIconPM);

            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newnameAF.setText(object.namePMOne);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newdataAF.setText(object.dataPM);

            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newpostAF.setText(object.postPM);

            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgLikeAF.setImageResource(object.imgLikePM);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgIconAF1.setImageResource(object.imgIconPM1);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgIconAF2.setImageResource(object.imgIconPM2);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgIconAF3.setImageResource(object.imgIconPM3);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newimgCommentAF.setImageResource(object.imgCommentPM);

            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newnameAF2.setText(object.namePM2);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newandAF.setText(object.andPM);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newnumberAF.setText(object.numberPM);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newothersAF.setText(object.othersPM);
            ((AdapterActivityFeed.ViewPagerViewHolderActivityFeed)holder).newnumberTextAF.setText(object.numberTextPM);
        }
    }
    @Override
    public int getItemCount() {
        return dataSetAF == null? 0 : dataSetAF.size();
    }


}
