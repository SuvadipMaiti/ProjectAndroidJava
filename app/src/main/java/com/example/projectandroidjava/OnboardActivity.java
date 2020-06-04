package com.example.projectandroidjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectandroidjava.Adapters.ViewPageAdapter;

public class OnboardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btnLeft,btnRight;
    private ViewPageAdapter adapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.view_pager);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        dotsLayout = findViewById(R.id.dotsLayout);

        adapter = new ViewPageAdapter(this);
        addDots(0);
        viewPager.addOnPageChangeListener(listener); //create this listener
        viewPager.setAdapter(adapter);

        btnRight.setOnClickListener(v->{
            //if button text is next we will go next page of viewPager
            if(btnRight.getText().toString().equals("Next")){
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }else{
                //else its finish , we will start Auth activity
                startActivity(new Intent(OnboardActivity.this,AuthActivity.class));
                finish();
            }
        });

        btnLeft.setOnClickListener(v->{
            //if button skip clicked then we go to page 3
                viewPager.setCurrentItem(viewPager.getCurrentItem()+2);
        });
    }

    //method to cat  dots from html code
    private void addDots(int position){
        dotsLayout.removeAllViews();
        dots = new TextView[3];
        for (int i =0; i < dots.length; i++){
            dots[i] = new TextView(this);
            //this html code cree dot
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(ContextCompat.getColor(this,R.color.colorLightGrey));

            dotsLayout.addView(dots[i]);

        }

        //let change the select dot color
        if(dots.length > 0){
            dots[position].setTextColor(ContextCompat.getColor(this,R.color.colorGrey));
        }
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            //change text of the Next button to Finish if page reach last position
            //and hide the skip button if we not in page 1
            if(position == 0){
                btnLeft.setVisibility(ViewPager.VISIBLE);
                btnLeft.setEnabled(true);
                btnRight.setText("Next");
            }else if(position == 1){
                btnLeft.setVisibility(ViewPager.GONE);
                btnLeft.setEnabled(false);
                btnRight.setText("Next");

            }else{
                btnLeft.setVisibility(ViewPager.GONE);
                btnLeft.setEnabled(false);
                btnRight.setText("Finish");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}