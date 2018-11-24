package com.example.lekh.bean2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.bean2.Models.ModelProfilePostsMe;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterProfilePostsMe extends RecyclerView.Adapter<AdapterProfilePostsMe.UserViewHolder> {
    private OnItemClickListener mItemClickListener;

    public AdapterProfilePostsMe(List<ModelProfilePostsMe> userList, OnUserMenuClickListener onUserMenuClickListener) {
        this.userList = userList;
        this.onUserMenuClickListener = onUserMenuClickListener;
    }



    public interface OnUserMenuClickListener {
        void onUserMenuClick(View v, int userPosition);
    }
    private List<ModelProfilePostsMe> userList;

    private List<ModelProfilePostsMe> selectedUsers = new ArrayList<>();

    private OnUserMenuClickListener onUserMenuClickListener;
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()) // статический метод фром и он парсит иксемель из них создает фойлы в  памяти
                .inflate(R.layout.item_fragment_posts_me, parent, false); // можно без parent,false

        // найти все внутренние вьюхи во вью храниться обьект леяута, но все они сосредоточны в одном обьекте вью (вьюхолдер разбирает леяут)
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {  // помещает во View

        ModelProfilePostsMe user = userList.get(position);

        holder.newimgIconPostMe.setImageResource(user.getImgIconPostMe());
        //holder.newimgPostPostMe.setImageResource(user.getImgPostPostMe());

        holder.newnamePostMe.setText(user.getNamePostMe());
        holder.newdataPostMe.setText(user.getDataPostMe());
      //  holder.newpostPostMe.setText(user.getPostPostMe());

    }

    public List<ModelProfilePostsMe> getSelectedUsers() {
        return selectedUsers;
    }

    @Override
    public int getItemCount() {   // ужное число айтемов
        return userList.size();
    }

    public interface OnClickListener {
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView newimgIconPostMe;
        private ImageView newimgPostPostMe;
        private TextView newnamePostMe;
        private TextView newdataPostMe;
        private TextView newpostPostMe;

        private ImageView userMenu;


        public UserViewHolder(View itemView) {
            super(itemView);

            newimgIconPostMe = itemView.findViewById(R.id.imageViewIconPostMe);
            //newimgPostPostMe = itemView.findViewById(R.id.imageViewPostPostMe);

            newnamePostMe = itemView.findViewById(R.id.textViewNamePostMe);
            newdataPostMe = itemView.findViewById(R.id.textViewDataPostMe);
         //   newpostPostMe = itemView.findViewById(R.id.textViewPostPostMe);

            newpostPostMe.setOnClickListener(this);
            newdataPostMe.setOnClickListener(this);


            userMenu = itemView.findViewById(R.id.menuCirclePostMe);
            userMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onUserMenuClickListener.onUserMenuClick(view, getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
    public void SetOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}

