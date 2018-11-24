package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Models.ModelRequests;
import com.example.lekh.bean2.R;

import java.util.List;

public class AdapterRequests extends RecyclerView.Adapter<AdapterRequests.ViewHolder> {

    private ItemClickListener mItemClickListenerFR;
    private LayoutInflater mInflater;
    private List<ModelRequests> modelRequestsList;

    public AdapterRequests(Context context, List<ModelRequests> modelRequestsList) {
        this.mInflater = LayoutInflater.from(context);
        this.modelRequestsList = modelRequestsList;
    }
    //private List<ModelRequests> selectedUsers = new ArrayList<>();
    //private AdapterProfilePostsMe.OnUserMenuClickListener onUserMenuClickListenerFR;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_follow_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelRequests modelRequests = modelRequestsList.get(position);

        holder.newimgIconFR.setImageResource(modelRequests.getImgIconFR());

        holder.newnameFR.setText(modelRequests.getNameFR());
        holder.newemailFR.setText(modelRequests.getEmailFR());
    }

    //public List<ModelRequests> getSelectedUsers() {
  //      return selectedUsers;
    //}

    @Override
    public int getItemCount() {
        return modelRequestsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView newimgIconFR;

        private TextView newnameFR;
        private TextView newemailFR;


        private Button buttonConfirmFR;
        private Button buttonDeleteFR;
      //  private ImageView userMenu;


        public ViewHolder(View itemView) {
            super(itemView);

            newimgIconFR = itemView.findViewById(R.id.imageViewIconFR);

            newnameFR = itemView.findViewById(R.id.textViewIconNameFR);
            newemailFR = itemView.findViewById(R.id.textViewIconEmailFR);

            buttonConfirmFR = itemView.findViewById(R.id.buttonConfirmFR);
            buttonDeleteFR = itemView.findViewById(R.id.buttonDeleteFR);

            newimgIconFR.setOnClickListener(this);
            newnameFR.setOnClickListener(this);

            buttonConfirmFR.setOnClickListener(this);
            buttonDeleteFR.setOnClickListener(this);


           //userMenu = itemView.findViewById(R.id.menuCirclePostMe);
          // userMenu.setOnClickListener(new View.OnClickListener() {
              //  @Override
            //    public void onClick(View view) {
            //        onUserMenuClickListenerFR.onUserMenuClick(view, getAdapterPosition());
            //    }
            //});
            }

        @Override
        public void onClick(View v) {
            if (mItemClickListenerFR != null) {
                mItemClickListenerFR.onItemClick(v, getAdapterPosition());
            }
        }
        // convenience method for getting data at click position
        ModelRequests getItem(int id) {
            return modelRequestsList.get(id);
        }

    }
    public void SetClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListenerFR = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }
}
