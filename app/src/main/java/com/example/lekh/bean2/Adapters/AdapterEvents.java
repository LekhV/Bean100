package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lekh.bean2.Datas.DataEvents;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

public class AdapterEvents extends RecyclerView.Adapter {


    private OnItemClickListener mItemClickListener;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_events, parent,false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return DataEvents.textNameEvent.length;



    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bNameE;
        private TextView bMapE;
        private TextView bDataE;
        private TextView bTimeE;
        private TextView bParticipantsE;

        private ImageView bImagePostE;
        private ImageView bImageMapE;



        public LisViewHolder(View itemView) {
            super(itemView);
            bNameE = (TextView) itemView.findViewById(R.id.textViewNameEvent);
            bMapE = (TextView) itemView.findViewById(R.id.textViewMap);
            bDataE = (TextView) itemView.findViewById(R.id.textViewDataEvents);
            bTimeE = (TextView) itemView.findViewById(R.id.textViewTimeEvents);
            bParticipantsE = (TextView) itemView.findViewById(R.id.textViewParticipantsEvents);

            bImagePostE = (ImageView) itemView.findViewById(R.id.imageViewPostEvent);
            bImageMapE = (ImageView) itemView.findViewById(R.id.imageViewMapGreen);

            bNameE.setOnClickListener(this);
            bImageMapE.setOnClickListener(this);
            bImagePostE.setOnClickListener(this);
        }

        public void bindView(int position) {
            bNameE.setText(DataEvents.textNameEvent[position]);
            bMapE.setText(DataEvents.textMap[position]);
            bDataE.setText(DataEvents.textDataEvents[position]);
            bTimeE.setText(DataEvents.textTimeEvents[position]);
            bParticipantsE.setText(DataEvents.textParticipantsEvents[position]);

            bImagePostE.setImageResource(DataEvents.imagePostEvent[position]);
            bImageMapE.setImageResource(DataEvents.pictureIconMapGreen[position]);


        }

        public void onClick(View view) {

            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getPosition());
            }
        }
    }
        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }

}
