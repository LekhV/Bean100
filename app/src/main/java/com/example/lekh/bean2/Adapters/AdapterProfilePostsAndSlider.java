package com.example.lekh.bean2.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lekh.bean2.Models.Data;
import com.example.lekh.bean2.Models.DataProfilePostMe;
import com.example.lekh.bean2.Models.ModelProfilePostsMe;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterProfilePostsAndSlider extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataProfilePostMe> dataSet;
    Context mContext;
    int page = 0;

    private OnItemClickListener mItemClickListener;
    private OnUserMenuClickListener onUserMenuClickListener;

    public AdapterProfilePostsAndSlider( ArrayList<DataProfilePostMe> dataSet,Context mContext, OnUserMenuClickListener onUserMenuClickListener) {
      this.dataSet = dataSet;
      this.mContext = mContext;
       this.onUserMenuClickListener = onUserMenuClickListener;
    }

    public interface OnClickListener { }

    public interface OnUserMenuClickListener {
        void onUserMenuClick(View view, int userPosition);}

    public  class ViewPagerViewHolderPosts extends RecyclerView.ViewHolder implements View.OnClickListener {
        ViewPager mvViewPager;
        TabLayout indicator;

        ImageView newimgIconPostMe;
        TextView newnamePostMe;
        TextView newdataPostMe;

        ImageView userMenu;

        TextView newpostPostMe;

        private ImageView newimgLikePostMe;
        private ImageView newimgIconPostMe1;
        private ImageView newimgIconPostMe2;
        private ImageView newimgIconPostMe3;
        private ImageView newimgCommentPostMe;

        private TextView newnamePostMe2;
        private TextView newandPostMe;
        private TextView newnumberPostMe;
        private TextView newothersPostMe;
        private TextView newnumberTextPostMe;

        public ViewPagerViewHolderPosts(View itemView) {
            super(itemView);
            mvViewPager = (ViewPager) itemView.findViewById(R.id.vp_slider);
            indicator = (TabLayout) itemView.findViewById(R.id.indicatorP);

            newimgIconPostMe = itemView.findViewById(R.id.imageViewIconPostMe);
            newnamePostMe = itemView.findViewById(R.id.textViewNamePostMe);
            newdataPostMe = itemView.findViewById(R.id.textViewDataPostMe);

            newpostPostMe = itemView.findViewById(R.id.textViewPostPostMe);

            newimgLikePostMe = itemView.findViewById(R.id.imageViewLikePM);
            newimgIconPostMe1 = itemView.findViewById(R.id.imageViewIconPM1);
            newimgIconPostMe2 = itemView.findViewById(R.id.imageViewPM2);
            newimgIconPostMe3 = itemView.findViewById(R.id.imageViewPM3);
            newimgCommentPostMe = itemView.findViewById(R.id.imageViewCommentPM);

            newnamePostMe2 = itemView.findViewById(R.id.textViewNamePM2);
            newandPostMe = itemView.findViewById(R.id.textViewAndPM);
            newnumberPostMe = itemView.findViewById(R.id.textViewNumberPM);
            newothersPostMe = itemView.findViewById(R.id.textViewOthersPM);
            newnumberTextPostMe = itemView.findViewById(R.id.textViewNumberTextPM);

            userMenu = itemView.findViewById(R.id.menuCirclePostMe);
            userMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onUserMenuClickListener != null) {
                        onUserMenuClickListener.onUserMenuClick(view, getAdapterPosition());
                    }
                }
            });

            newimgIconPostMe.setOnClickListener(this);
            newpostPostMe.setOnClickListener(this);
            newimgLikePostMe.setOnClickListener(this);
            newimgCommentPostMe.setOnClickListener(this);
            newnamePostMe2.setOnClickListener(this);
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_posts_me, parent, false);
                return new ViewPagerViewHolderPosts(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        DataProfilePostMe object = dataSet.get(position);
        if (object != null) {

                    List<ModelSlider> modelSliderList = new ArrayList<>();
                    modelSliderList.add(new ModelSlider(R.drawable.imageevents));
                    modelSliderList.add(new ModelSlider (R.drawable.makarons));
                    modelSliderList.add(new ModelSlider (R.drawable.imageevents));

                    final AdapterSliderPosts sliderPagerAdapter = new AdapterSliderPosts(mContext, modelSliderList);
                    ((ViewPagerViewHolderPosts) holder).mvViewPager.setAdapter(sliderPagerAdapter);
                    ((ViewPagerViewHolderPosts) holder).indicator.setupWithViewPager(((ViewPagerViewHolderPosts) holder).mvViewPager, true);
                    ((ViewPagerViewHolderPosts) holder).mvViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
                        @Override
                        public void onPageSelected(int position) { page = position; }
                        @Override
                        public void onPageScrollStateChanged(int state) { }
                    });

            ((ViewPagerViewHolderPosts)holder).newnamePostMe.setText(object.namePMOne);
            ((ViewPagerViewHolderPosts)holder).newdataPostMe.setText(object.dataPM);
            ((ViewPagerViewHolderPosts)holder).newimgIconPostMe.setImageResource(object.imgIconPM);
            ((ViewPagerViewHolderPosts)holder).newpostPostMe.setText(object.postPM);

            ((ViewPagerViewHolderPosts)holder).newimgLikePostMe.setImageResource(object.imgLikePM);
            ((ViewPagerViewHolderPosts)holder).newimgIconPostMe1.setImageResource(object.imgIconPM1);
            ((ViewPagerViewHolderPosts)holder).newimgIconPostMe2.setImageResource(object.imgIconPM2);
            ((ViewPagerViewHolderPosts)holder).newimgIconPostMe3.setImageResource(object.imgIconPM3);
            ((ViewPagerViewHolderPosts)holder).newimgCommentPostMe.setImageResource(object.imgCommentPM);

            ((ViewPagerViewHolderPosts)holder).newnamePostMe2.setText(object.namePM2);
            ((ViewPagerViewHolderPosts)holder).newandPostMe.setText(object.andPM);
            ((ViewPagerViewHolderPosts)holder).newnumberPostMe.setText(object.numberPM);
            ((ViewPagerViewHolderPosts)holder).newothersPostMe.setText(object.othersPM);
            ((ViewPagerViewHolderPosts)holder).newnumberTextPostMe.setText(object.numberTextPM);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet == null? 0 : dataSet.size();
    }

}