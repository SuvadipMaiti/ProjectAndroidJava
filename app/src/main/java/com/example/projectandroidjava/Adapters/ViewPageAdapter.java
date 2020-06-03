package com.example.projectandroidjava.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
            "Desc 1",
            "Desc 2",
            "Desc 3",
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
        return super.instantiateItem(container, position);
    }
}
