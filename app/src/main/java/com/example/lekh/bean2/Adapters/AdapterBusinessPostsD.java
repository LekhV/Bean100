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

public class AdapterBusinessPostsD extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataProfilePostMe> dataSetBP;
    Context mContext;
    int page = 0;

    private OnItemClickListener mItemClickListener;
    private AdapterBusinessPostsD.OnUserMenuClickListener onUserMenuClickListener;

    public AdapterBusinessPostsD( ArrayList<DataProfilePostMe> dataSetBP,Context mContext, AdapterBusinessPostsD.OnUserMenuClickListener onUserMenuClickListener) {
        this.dataSetBP = dataSetBP;
        this.mContext = mContext;
        this.onUserMenuClickListener = onUserMenuClickListener;
    }

    public interface OnClickListener { }

    public interface OnUserMenuClickListener {
        void onUserMenuClick(View view, int userPosition);}

    public  class ViewPagerViewHolderBusinessP extends RecyclerView.ViewHolder implements View.OnClickListener {
        ViewPager mvViewPagerBDP;
        TabLayout indicatorBDP;;

        ImageView newimgIconPostBDP;
        TextView newnamePostBDP;
        TextView newdataPostBDP;

        ImageView userMenuBDP;

        TextView newpostPostBDP;

        private ImageView newimgLikePostBDP;
        private ImageView newimgIconPostBDP1;
        private ImageView newimgIconPostBDP2;
        private ImageView newimgIconPostBDP3;
        private ImageView newimgCommentPostBDP;

        private TextView newnamePostBDP2;
        private TextView newandPostBDP;
        private TextView newnumberPostBDP;
        private TextView newothersPostBDP;
        private TextView newnumberTextPostBDP;

        public ViewPagerViewHolderBusinessP(View itemView) {
            super(itemView);
            mvViewPagerBDP = (ViewPager) itemView.findViewById(R.id.vp_sliderDetailPostBusiness);
            indicatorBDP = (TabLayout) itemView.findViewById(R.id.indicatorPDetailPostBusiness);

            newimgIconPostBDP = itemView.findViewById(R.id.imageViewIconDetailPostBusiness);
            newnamePostBDP = itemView.findViewById(R.id.textViewNameDetailPostBusiness);
            newdataPostBDP = itemView.findViewById(R.id.textViewDataDetailPostBusiness);

            newpostPostBDP = itemView.findViewById(R.id.textViewPostDetailPostBusiness);

            newimgLikePostBDP = itemView.findViewById(R.id.imageViewLikeDPB);
            newimgIconPostBDP1 = itemView.findViewById(R.id.imageViewIconDPB1);
            newimgIconPostBDP2 = itemView.findViewById(R.id.imageViewDPB2);
            newimgIconPostBDP3 = itemView.findViewById(R.id.imageViewDPB3);
            newimgCommentPostBDP = itemView.findViewById(R.id.imageViewCommentDPB);

            newnamePostBDP2 = itemView.findViewById(R.id.textViewNameDPB2);
            newandPostBDP = itemView.findViewById(R.id.textViewAndDPB);
            newnumberPostBDP = itemView.findViewById(R.id.textViewNumberDPB);
            newothersPostBDP = itemView.findViewById(R.id.textViewOthersDPB);
            newnumberTextPostBDP = itemView.findViewById(R.id.textViewNumberTextDPB);

            userMenuBDP = itemView.findViewById(R.id.menuCircleDetailPostBusiness);
            userMenuBDP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onUserMenuClickListener != null) {
                        onUserMenuClickListener.onUserMenuClick(view, getAdapterPosition());
                    }
                }
            });

            newimgIconPostBDP.setOnClickListener(this);
            newpostPostBDP.setOnClickListener(this);
            newimgLikePostBDP.setOnClickListener(this);
            newimgCommentPostBDP.setOnClickListener(this);
            newnamePostBDP2.setOnClickListener(this);

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
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_detail_post, parent, false);
        return new AdapterBusinessPostsD.ViewPagerViewHolderBusinessP(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        DataProfilePostMe object = dataSetBP.get(position);
        if (object != null) {

            List<ModelSlider> modelSliderList = new ArrayList<>();
            modelSliderList.add(new ModelSlider(R.drawable.imageevents));
            modelSliderList.add(new ModelSlider (R.drawable.makarons));
            modelSliderList.add(new ModelSlider (R.drawable.imageevents));

            AdapterSliderPostBusiness sliderPagerAdapter = new AdapterSliderPostBusiness(mContext, modelSliderList);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP) holder).mvViewPagerBDP.setAdapter(sliderPagerAdapter);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP) holder).indicatorBDP.setupWithViewPager(((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP) holder).mvViewPagerBDP, true);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP) holder).mvViewPagerBDP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
                @Override
                public void onPageSelected(int position) { page = position; }
                @Override
                public void onPageScrollStateChanged(int state) { }
            });

            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgIconPostBDP.setImageResource(object.imgIconPM);

            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newnamePostBDP.setText(object.namePMOne);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newdataPostBDP.setText(object.dataPM);

            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newpostPostBDP.setText(object.postPM);

            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgLikePostBDP.setImageResource(object.imgLikePM);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgIconPostBDP1.setImageResource(object.imgIconPM1);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgIconPostBDP2.setImageResource(object.imgIconPM2);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgIconPostBDP3.setImageResource(object.imgIconPM3);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newimgCommentPostBDP.setImageResource(object.imgCommentPM);

            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newnamePostBDP2.setText(object.namePM2);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newandPostBDP.setText(object.andPM);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newnumberPostBDP.setText(object.numberPM);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newothersPostBDP.setText(object.othersPM);
            ((AdapterBusinessPostsD.ViewPagerViewHolderBusinessP)holder).newnumberTextPostBDP.setText(object.numberTextPM);
        }
    }
    @Override
    public int getItemCount() {
        return dataSetBP == null? 0 : dataSetBP.size();
    }

}
