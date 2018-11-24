package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Datas.DataBusinesses;
import com.example.lekh.bean2.Datas.DataConnectionsfollowers;
import com.example.lekh.bean2.Datas.DataConnectionsfollowing;
import com.example.lekh.bean2.R;

public class AdapterConnectionsfollowing extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_connections_following, parent,false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataConnectionsfollowing.namefollowing.length;
    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView cNameG;
        private TextView cEmailG;

        private ImageView cImageG;
        private ImageView cIconG;

        public LisViewHolder( View itemView) {
            super(itemView);
            cNameG = (TextView) itemView.findViewById(R.id.textViewIconNameRed);
            cEmailG = (TextView) itemView.findViewById(R.id.textViewIconEmailRed);

            cImageG = (ImageView) itemView.findViewById(R.id.imageViewIconG);
            cIconG = (ImageView) itemView.findViewById(R.id.imageViewIconRed);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            cNameG.setText(DataConnectionsfollowing.namefollowing[position]);
            cEmailG.setText(DataConnectionsfollowing.emailfollowing[position]);

            cImageG.setImageResource(DataConnectionsfollowing.pictureiconfollowing[position]);
            cIconG.setImageResource(DataConnectionsfollowing.pictureiconredfollowing[position]);
        }
        public  void onClick(View view){ }
    }
}
