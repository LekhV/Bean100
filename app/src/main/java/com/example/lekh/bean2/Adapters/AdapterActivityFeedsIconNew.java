package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lekh.bean2.Models.DataIcons;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

public class AdapterActivityFeedsIconNew extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private ArrayList<DataIcons> dataSet;
        Context mContext;
        int total_types;
        ArrayList<String> slider_image_list;
        int page = 0;

    private OnItemClickListener mItemClickListener;

        public  class MyImageTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView newimgiconsAF0;
            private ImageButton imageButtonAF;

            public MyImageTypeViewHolder(View itemView) {
                super(itemView);
                newimgiconsAF0 = itemView.findViewById(R.id.imageiconsAF0);
                imageButtonAF = itemView.findViewById(R.id.imageButtonAF);

            imageButtonAF.setOnClickListener(this);
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

        public static class NotMyImageTypeViewHolder extends RecyclerView.ViewHolder {

            private ImageView newimgimageViewIconAFS;

            public NotMyImageTypeViewHolder(View itemView) {
                super(itemView);
                newimgimageViewIconAFS = itemView.findViewById(R.id.imageViewIconAFS);
            }
        }

    public AdapterActivityFeedsIconNew(ArrayList<DataIcons> data, Context context) {
            this.dataSet = data;
            this.mContext = context;
            total_types = dataSet.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view;
            switch (viewType) {
                case DataIcons.IMAGEMY_TYPE:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_activity_feed_icons, parent, false);
                    return new MyImageTypeViewHolder(view);
                case DataIcons.IMAGENOT_TYPE:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small_fragment_activity_feed, parent, false);
                    return new NotMyImageTypeViewHolder(view);
            }
            return null;
        }

        @Override
        public int getItemViewType(int position) {

            switch (dataSet.get(position).type) {
                case 0:
                    return DataIcons.IMAGEMY_TYPE;
                case 1:
                    return DataIcons.IMAGENOT_TYPE;
                default:
                    return -1;
            }
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

            DataIcons object = dataSet.get(listPosition);
            if (object != null) {
                switch (object.type) {
                    case DataIcons.IMAGEMY_TYPE:
                        ((MyImageTypeViewHolder) holder).newimgiconsAF0.setImageResource(object.data);
                      /*  ((MyImageTypeViewHolder) holder).imageButtonAF.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Toast.makeText(mContext, "You clicked!!!", Toast.LENGTH_SHORT).show();
                            }
                        });*/

                        break;
                    case DataIcons.IMAGENOT_TYPE:
                        ((NotMyImageTypeViewHolder) holder).newimgimageViewIconAFS.setImageResource(object.data);
                        break;
                }
            }
        }
        @Override
        public int getItemCount() {
            return dataSet.size();
        }

}
