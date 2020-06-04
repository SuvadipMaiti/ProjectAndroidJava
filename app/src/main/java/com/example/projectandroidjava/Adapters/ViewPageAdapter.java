package com.example.projectandroidjava.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.projectandroidjava.R;

public class ViewPageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;



    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    private int images[] ={
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
    };

    private String titles[] = {
            "Title 1",
            "Title 2",
            "Title 3",
    };
    private String descs[] = {
            "Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1 Desc 1",
            "Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2 Desc 2",
            "Desc 3 Desc 3 Desc 3 Desc 3 Desc 3 Desc 3 Desc 3",
    };

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view = inflater.inflate(R.layout.view_pager,container,false);

       //init view
        ImageView imageView = view.findViewById(R.id.imageViewPager);
        TextView textTitle = view.findViewById(R.id.txtTitleViewPaper);
        TextView textDesc = view.findViewById(R.id.txtDescViewPaper);


        imageView.setImageResource(images[position]);
        textTitle.setText(titles[position]);
        textDesc.setText(descs[position]);

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
