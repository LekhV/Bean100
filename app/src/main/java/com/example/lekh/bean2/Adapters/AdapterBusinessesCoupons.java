package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Datas.DataBusinesses;
import com.example.lekh.bean2.Datas.DataBusinessesCoupons;
import com.example.lekh.bean2.R;

public class AdapterBusinessesCoupons extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_businesses_details_coupons, parent,false);
        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((LisViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return DataBusinessesCoupons.namebusinessesCoupons.length;
       // return createLists == null? 0 : createLists.size();
    }

    private class LisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView bNameC;
        private TextView bfrom;
        private TextView bOneC;
        private TextView bto;
        private TextView bTwoC;

        private ImageView bImage;

        public LisViewHolder( View itemView) {
            super(itemView);
            bNameC = (TextView) itemView.findViewById(R.id.textViewMacaroons);
            bfrom = (TextView) itemView.findViewById(R.id.textViewfrom);
            bOneC = (TextView) itemView.findViewById(R.id.textViewTimeOne);
            bto = (TextView) itemView.findViewById(R.id.textViewto);
            bTwoC = (TextView) itemView.findViewById(R.id.textViewTwo);

            bImage = (ImageView) itemView.findViewById(R.id.imageViewMacaroons);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            bNameC.setText(DataBusinessesCoupons.namebusinessesCoupons[position]);
            bfrom.setText(DataBusinessesCoupons.businessesfrom[position]);
            bOneC.setText(DataBusinessesCoupons.onedatabusinessesCoupons[position]);
            bto.setText(DataBusinessesCoupons.businessesto[position]);
            bTwoC.setText(DataBusinessesCoupons.twodatabusinessesCoupons[position]);

            bImage.setImageResource(DataBusinessesCoupons.picturebusinessesCoupons[position]);
        }
        public  void onClick(View view){  }
    }

}
