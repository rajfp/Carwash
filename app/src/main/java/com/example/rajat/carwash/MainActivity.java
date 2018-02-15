package com.example.rajat.carwash;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    CustomSwipeAdapter adapter;
    Button b1,b2,b3,b4;
    ImageView imageView;
    DrawerLayout drawerLayout;
Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        sliderDotspanel = (LinearLayout)findViewById(R.id.SliderDots);
        adapter=new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        drawerLayout= (DrawerLayout) findViewById(R.id.dr);
        b1= (Button) findViewById(R.id.butt1);
        b2= (Button) findViewById(R.id.butt2);
        b3= (Button) findViewById(R.id.butt3);
        b4= (Button) findViewById(R.id.butt4);
        toolbar= (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button b2=(Button)findViewById(R.id.butt2);
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                b1.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(),Work_locations.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button b2=(Button)findViewById(R.id.butt2);
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                b2.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(),view_car.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button b2=(Button)findViewById(R.id.butt2);
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                b3.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(),gifts.class);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button b2=(Button)findViewById(R.id.butt2);
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                b4.startAnimation(myAnim);
                Intent intent=new Intent(getApplicationContext(),gifts.class);
                startActivity(intent);
            }
        });
        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

}

    @Override
    protected void onPostCreate( Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


}
