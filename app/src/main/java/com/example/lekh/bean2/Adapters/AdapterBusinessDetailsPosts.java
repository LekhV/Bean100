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

public class AdapterBusinessDetailsPosts extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataProfilePostMe> dataSet;
    private Context mContext;
    int page = 0;

    private OnItemClickListener mItemClickListener;
    private AdapterBusinessDetailsPosts.OnUserMenuClickListener onUserMenuClickListener;

    public AdapterBusinessDetailsPosts( ArrayList<DataProfilePostMe> dataSet,Context mContext, AdapterBusinessDetailsPosts.OnUserMenuClickListener onUserMenuClickListener) {
        this.dataSet = dataSet;
        this.mContext = mContext;
        this.onUserMenuClickListener = onUserMenuClickListener;
    }

    public interface OnClickListener { }

    public interface OnUserMenuClickListener {
        void onUserMenuClick(View view, int userPosition);}

    public  class ViewPagerViewHolderPostsBusiness extends RecyclerView.ViewHolder implements View.OnClickListener {
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

        public ViewPagerViewHolderPostsBusiness(View itemView) {
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
        return new AdapterBusinessDetailsPosts.ViewPagerViewHolderPostsBusiness(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        DataProfilePostMe object = dataSet.get(position);
        if (object != null) {

            List<ModelSlider> modelSliderList = new ArrayList<>();
            modelSliderList.add(new ModelSlider(R.drawable.imageevents));
            modelSliderList.add(new ModelSlider (R.drawable.makarons));


            AdapterSliderPostBusiness sliderPagerAdapterB = new AdapterSliderPostBusiness(mContext, modelSliderList);
            ((ViewPagerViewHolderPostsBusiness) holder).mvViewPagerBDP.setAdapter(sliderPagerAdapterB);
            ((ViewPagerViewHolderPostsBusiness) holder).indicatorBDP.setupWithViewPager(((ViewPagerViewHolderPostsBusiness) holder).mvViewPagerBDP, true);
            ((ViewPagerViewHolderPostsBusiness) holder).mvViewPagerBDP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
                @Override
                public void onPageSelected(int position) { page = position; }
                @Override
                public void onPageScrollStateChanged(int state) { }
            });

            ((ViewPagerViewHolderPostsBusiness)holder).newnamePostBDP.setText(object.namePMOne);
            ((ViewPagerViewHolderPostsBusiness)holder).newdataPostBDP.setText(object.dataPM);
            ((ViewPagerViewHolderPostsBusiness)holder).newimgIconPostBDP.setImageResource(object.imgIconPM);
            ((ViewPagerViewHolderPostsBusiness)holder).newpostPostBDP.setText(object.postPM);

            ((ViewPagerViewHolderPostsBusiness)holder).newimgLikePostBDP.setImageResource(object.imgLikePM);
            ((ViewPagerViewHolderPostsBusiness)holder).newimgIconPostBDP1.setImageResource(object.imgIconPM1);
            ((ViewPagerViewHolderPostsBusiness)holder).newimgIconPostBDP2.setImageResource(object.imgIconPM2);
            ((ViewPagerViewHolderPostsBusiness)holder).newimgIconPostBDP3.setImageResource(object.imgIconPM3);
            ((ViewPagerViewHolderPostsBusiness)holder).newimgCommentPostBDP.setImageResource(object.imgCommentPM);

            ((ViewPagerViewHolderPostsBusiness)holder).newnamePostBDP2.setText(object.namePM2);
            ((ViewPagerViewHolderPostsBusiness)holder).newandPostBDP.setText(object.andPM);
            ((ViewPagerViewHolderPostsBusiness)holder).newnumberPostBDP.setText(object.numberPM);
            ((ViewPagerViewHolderPostsBusiness)holder).newothersPostBDP.setText(object.othersPM);
            ((ViewPagerViewHolderPostsBusiness)holder).newnumberTextPostBDP.setText(object.numberTextPM);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet == null? 0 : dataSet.size();
    }

}
