package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Datas.DataBusinesses;
import com.example.lekh.bean2.Datas.DataConnectionsfollowers;
import com.example.lekh.bean2.R;

public class AdapterConnectionsfollowers extends RecyclerView.Adapter {



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_connections_followers, parent,false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return DataConnectionsfollowers.namefollowers.length;



    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView cNameS;
        private TextView cEmail;

        private ImageView cImage;
        private ImageView cIcon;

        public LisViewHolder( View itemView) {
            super(itemView);
            cNameS = (TextView) itemView.findViewById(R.id.textViewIconNameGreen);
            cEmail = (TextView) itemView.findViewById(R.id.textViewIconEmailGreen);

            cImage = (ImageView) itemView.findViewById(R.id.imageViewIconSGreen);
            cIcon = (ImageView) itemView.findViewById(R.id.imageViewIconGreen);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            cNameS.setText(DataConnectionsfollowers.namefollowers[position]);
            cEmail.setText(DataConnectionsfollowers.emailfollowers[position]);

            cImage.setImageResource(DataConnectionsfollowers.pictureiconfollowers[position]);
            cIcon.setImageResource(DataConnectionsfollowers.pictureicongreenfollowers[position]);


        }
        public  void onClick(View view){


        }
    }
}
