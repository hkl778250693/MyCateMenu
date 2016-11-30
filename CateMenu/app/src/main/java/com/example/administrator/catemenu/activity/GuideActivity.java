package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public class GuideActivity extends Activity {
    ViewPager viewPager;
    List<View> arraylist;
    TextView tvgetlogin;
    View view;
    View view1;
    View view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        view = layoutInflater.inflate(R.layout.viewpager_guidepage_one, null);
        view1 = layoutInflater.inflate(R.layout.viewpager_guidepage_two, null);
        view2 = layoutInflater.inflate(R.layout.viewpager_guidepage_three, null);
        arraylist = new ArrayList<View>();
        arraylist.add(view);
        arraylist.add(view1);
        arraylist.add(view2);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(arraylist);
        viewPager.setAdapter(viewPagerAdapter);
        into();
        tvgetlogin = (TextView) view2.findViewById(R.id.tv_getlogin);
        tvgetlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void into() {
        TextView text = (TextView) view.findViewById(R.id.tv_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text.setTypeface(typeface);
        TextView text1 = (TextView) view1.findViewById(R.id.tv_text1);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text1.setTypeface(typeface1);
        TextView text2 = (TextView) view2.findViewById(R.id.tv_text2);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text2.setTypeface(typeface2);
        TextView text3= (TextView) view2.findViewById(R.id.tv_getlogin);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/zitiguanjiafangmeng.ttf");
        text3.setTypeface(typeface3);

    }
}
