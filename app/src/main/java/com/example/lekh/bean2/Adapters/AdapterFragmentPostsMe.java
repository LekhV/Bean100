package com.example.lekh.bean2.Adapters;

public class AdapterFragmentPostsMe {/*extends RecyclerView.Adapter<AdapterFragmentPostsMe.ViewHolder> {

    private List<DataFragmentPostsMe> listItems;
   // private Context mContext;

    public AdapterFragmentPostsMe(List<DataFragmentPostsMe> listItems, Context mContext) {
        this.listItems = listItems;
       // this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        DataFragmentPostsMe itemList = listItems.get(position);
       // holder.textViewNamePFP.setText(DataFragmentPostsMe.namePostsMe[position]);
        holder.textViewNamePFP.setText(DataFragmentPostsMe.dataPostsMe[position]);

        DataFragmentPostsMe myList = listItems.get(position);
        holder.textViewNamePFP.setText(myList.getTextViewNamePFP());
        holder.textViewDataPFP.setText(myList.getTextViewDataPFP());

     //   holder.imageViewIconPFP.setImageResource(DataFragmentPostsMe.pictureiconPostsMe[position]);
     //   holder.imageViewPostPFP.setImageResource(DataFragmentPostsMe.picturepostPostsMe[position]);

       holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display option menu
/*
                PopupMenu popupMenu = new PopupMenu(mContext, holder.txtOptionDigit);
                popupMenu.inflate(R.menu.menu_circle);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.circleEdit:
                                Toast.makeText(mContext, "Saved", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.circleDelete:
                                //Delete item
                                listItems.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(mContext, "Deleted", Toast.LENGTH_LONG).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            *//*
            }
        });
    }
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNamePFP;
        public TextView textViewDataPFP;
      //  public ImageView imageViewIconPFP;
      //  public ImageView imageViewPostPFP;

        public TextView txtOptionDigit;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewNamePFP = (TextView) itemView.findViewById(R.id.textViewNamePFP);
            textViewDataPFP = (TextView) itemView.findViewById(R.id.textViewDataPFP);
           // imageViewIconPFP = (ImageView) itemView.findViewById(R.id.imageViewIconPFP);
          //  imageViewPostPFP = (ImageView) itemView.findViewById(R.id.imageViewPostPFP);

            txtOptionDigit = (TextView) itemView.findViewById(R.id.txtOptionDigit);
        }
    }*/
}
