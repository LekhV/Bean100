package com.example.lekh.bean2.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lekh.bean2.Models.ModelActivityFeedPost;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.R;

import java.util.List;

public class SliderAdapterPostDetails extends PagerAdapter {

    private Context context;
  //  private List<Integer> color;
   // private List<String> colorName;

    private List<ModelSlider> modelSliderList;
    private LayoutInflater mInflater;
   // private ItemClickListener mClickListener;

    public SliderAdapterPostDetails(Context context, List<ModelSlider> modelSliderList) {
        this.context = context;
        this.modelSliderList = modelSliderList;
       // this.mInflater = mInflater;
    }

    /* public SliderAdapterPostDetails(Context context, List<Integer> color, List<String> colorName) {
        this.context = context;
        this.color = color;
        this.colorName = colorName;
    }*/

    @Override
    public int getCount() {
        return modelSliderList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_image_item, null);

        ModelSlider modelSlider = modelSliderList.get(position);

        ImageView  imageViewSliderItem = (ImageView) view.findViewById(R.id.imageViewSliderItem);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        imageViewSliderItem.setImageResource(modelSlider.getImgSlider());
      //  linearLayout.setBackgroundColor(color.get(position));

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
