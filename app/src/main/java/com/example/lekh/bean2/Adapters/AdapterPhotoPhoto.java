package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lekh.bean2.Models.CreateListPhoto;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

public class AdapterPhotoPhoto extends RecyclerView.Adapter<AdapterPhotoPhoto.ViewHolder> {
    private LayoutInflater inflater2;
    private Context context;

    private ArrayList<CreateListPhoto> createLists;

    public AdapterPhotoPhoto(Context context, ArrayList<CreateListPhoto> createLists) {
        this.createLists = createLists;
        this.context = context;
    }

    @Override
    public AdapterPhotoPhoto.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_photo, viewGroup, false);
        return new AdapterPhotoPhoto.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AdapterPhotoPhoto.ViewHolder holder, int position) {

        holder.imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView2.setImageURI(Uri.parse((createLists.get(position).getImageUri())));

    }
    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size();
    }

    public void updateList(ArrayList<CreateListPhoto> list){
        this.createLists = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView2;
        // private EditText editText;
        public ViewHolder( View view) {
            super(view);
            imageView2 = (ImageView)view.findViewById(R.id.imageViewPhotoFragment);

            // editText = (EditText) view.findViewById(R.id.editText);


        }
    }
}

