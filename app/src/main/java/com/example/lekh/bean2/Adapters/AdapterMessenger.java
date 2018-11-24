package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lekh.bean2.Datas.DataMessenger;
import com.example.lekh.bean2.R;

public class AdapterMessenger extends RecyclerView.Adapter {



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_messenger, parent,false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return DataMessenger.nameMessenger.length;



    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bNameM;
        private TextView bTextM;
        private TextView bDataM;

        private ImageView bImageBeanS;
        private ImageView bIconM;

        public LisViewHolder( View itemView) {
            super(itemView);
            bNameM = (TextView) itemView.findViewById(R.id.textViewNameMessenger);
            bTextM = (TextView) itemView.findViewById(R.id.textViewtextMessenger);
            bDataM = (TextView) itemView.findViewById(R.id.textViewtimeMessenger);

            bImageBeanS = (ImageView) itemView.findViewById(R.id.imageViewSmallBean);
            bIconM = (ImageView) itemView.findViewById(R.id.imageViewIconMessenger);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            bNameM.setText(DataMessenger.nameMessenger[position]);
            bTextM.setText(DataMessenger.textMessenger[position]);
            bDataM.setText(DataMessenger.dataMessenger[position]);

            bImageBeanS.setImageResource(DataMessenger.imageSmallBeanMesesenger[position]);
            bIconM.setImageResource(DataMessenger.pictureIconMessenger[position]);


        }
        public  void onClick(View view){


        }
    }
}
