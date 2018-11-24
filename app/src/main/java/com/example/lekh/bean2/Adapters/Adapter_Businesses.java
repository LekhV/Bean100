package com.example.lekh.bean2.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lekh.bean2.Datas.DataBusinesses;
import com.example.lekh.bean2.Fragments.BusinessesFragment;
import com.example.lekh.bean2.Models.ModelBusiness;
import com.example.lekh.bean2.Models.ModelRequests;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Businesses extends RecyclerView.Adapter<Adapter_Businesses.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ModelBusiness> modelBusinesses;

   private ItemClickListenerAB mItemClickListener;

    public Adapter_Businesses(Context context, List<ModelBusiness> modelBusinesses) {
        this.mInflater = LayoutInflater.from(context);
        this.modelBusinesses = modelBusinesses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_businesses, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(Adapter_Businesses.ViewHolder holder, int position) {

        ModelBusiness modelBusinessess = modelBusinesses.get(position);

        holder.bImage.setImageResource(modelBusinessess.getImageBusiness());
        holder.bBob.setImageResource(modelBusinessess.getBobBusiness());

        holder.bName.setText(modelBusinessess.getNameBusiness());
        holder.bLocation.setText(modelBusinessess.getLocationBusiness());
        holder.bWorkingHours.setText(modelBusinessess.getWorkingHoursBusiness());

    }

    @Override
    public int getItemCount() {
       return modelBusinesses.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView bName;
        private TextView bLocation;
        private TextView bWorkingHours;

        private ImageView bImage;
        private ImageView bBob;

        public ViewHolder(View itemView) {
            super(itemView);
            bName = (TextView) itemView.findViewById(R.id.textBusinessName);
            bLocation = (TextView) itemView.findViewById(R.id.textLocation);
            bWorkingHours = (TextView) itemView.findViewById(R.id.textWorkingHouse);

            bImage = (ImageView) itemView.findViewById(R.id.imageViewBrandSmoll);
            bBob = (ImageView) itemView.findViewById(R.id.imageViewBobs);
           // itemView.setOnClickListener(this);

            bName.setOnClickListener(this);
            bLocation.setOnClickListener(this);
            bWorkingHours.setOnClickListener(this);

            bImage.setOnClickListener(this);
            bBob.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
        // convenience method for getting data at click position
        ModelBusiness getItem(int id) {
            return modelBusinesses.get(id);
        }
    }

    public void SetClickListener(ItemClickListenerAB itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }


    public interface ItemClickListenerAB {
        void onItemClick(View view, int position);

    }
}
