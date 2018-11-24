package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lekh.bean2.Datas.DataNotifications;
import com.example.lekh.bean2.R;

public class AdapterNotifications extends RecyclerView.Adapter {



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_notifications, parent,false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return DataNotifications.textNotifications.length;



    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bTextN;
        private TextView bDataN;

        private ImageView bIconN;

        public LisViewHolder( View itemView) {
            super(itemView);

            bTextN = (TextView) itemView.findViewById(R.id.textViewTextNotifications);
            bDataN = (TextView) itemView.findViewById(R.id.textViewtimeNotifications);

            bIconN = (ImageView) itemView.findViewById(R.id.imageViewIconNotifications);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            bTextN.setText(DataNotifications.textNotifications[position]);
            bDataN.setText(DataNotifications.dataNotifications[position]);

            bIconN.setImageResource(DataNotifications.pictureIconNotifications[position]);


        }
        public  void onClick(View view){


        }
    }
}
