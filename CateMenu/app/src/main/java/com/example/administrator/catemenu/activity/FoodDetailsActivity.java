package com.example.administrator.catemenu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.FoodDetailFragmentAdapter;
import com.example.administrator.catemenu.fragment.FoodDetailFragment;
import com.example.administrator.catemenu.fragment.FoodieDiscussFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by abc on 2016/11/11.
 */
public class FoodDetailsActivity extends FragmentActivity {
    @InjectView(R.id.back_btn)
    ImageView backBtn;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    List<Fragment> fragmentList;
    FragmentManager fragmentManager;
    @InjectView(R.id.food_detail_btn)
    RadioButton foodDetailBtn;
    @InjectView(R.id.foodie_discuss_btn)
    RadioButton foodieDiscussBtn;
    @InjectView(R.id.add_menu)
    TextView addMenu;
    @InjectView(R.id.zan_textview)
    TextView zanTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        ButterKnife.inject(this);
        initData();
    }

    public void initData() {
        foodDetailBtn.setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new FoodDetailFragment());
        fragmentList.add(new FoodieDiscussFragment());

        FoodDetailFragmentAdapter foodDetailFragmentAdapter = new FoodDetailFragmentAdapter(fragmentManager, fragmentList);
        viewpager.setAdapter(foodDetailFragmentAdapter);
        viewpager.setOffscreenPageLimit(2);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        foodDetailBtn.setChecked(true);
                        break;
                    case 1:
                        foodieDiscussBtn.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.food_detail_btn, R.id.foodie_discuss_btn, R.id.back_btn,R.id.add_menu, R.id.zan_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.food_detail_btn:
                viewpager.setCurrentItem(0);
                break;
            case R.id.foodie_discuss_btn:
                viewpager.setCurrentItem(1);
                break;
            case R.id.back_btn:
                finish();
                break;
            case R.id.add_menu:
                Intent intent = new Intent(FoodDetailsActivity.this,MyFoodMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.zan_textview:
                break;
        }
    }

}
