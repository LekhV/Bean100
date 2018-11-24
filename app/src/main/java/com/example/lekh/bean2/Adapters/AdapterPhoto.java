package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lekh.bean2.Models.CreateListPhoto;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

public class AdapterPhoto extends RecyclerView.Adapter<AdapterPhoto.ViewHolder> {
    private ArrayList<CreateListPhoto> galleryList;
    private Context context;

    public AdapterPhoto(Context context, ArrayList<CreateListPhoto> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public AdapterPhoto.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_comment, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (AdapterPhoto.ViewHolder viewHolder, int i) {

        viewHolder.imgPfotoFragment.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.imgPfotoFragment.setImageURI(Uri.parse((galleryList.get(i).getImageUri())));

        viewHolder.imgPfotoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Image",Toast.LENGTH_SHORT).show();
            }
        });
    }
    // метод для обновления Адаптера
    public void updateList(ArrayList<CreateListPhoto> list){
        this.galleryList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPfotoFragment;

        public ViewHolder(View view) {
            super(view);
            imgPfotoFragment = (ImageView) view.findViewById(R.id.imageViewPhotoComent);
        }
    }
}
