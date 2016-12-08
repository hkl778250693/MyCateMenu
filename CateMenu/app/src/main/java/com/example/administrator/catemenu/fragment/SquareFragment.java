package com.example.administrator.catemenu.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SquarePublishActivity;
import com.example.administrator.catemenu.adapter.SquareFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */
public class SquareFragment extends Fragment {
    private RadioButton videoBtn;
    private RadioButton discussBtn;
    private RadioButton releaseBtn;
    FragmentManager fragmentManager;
    ViewPager squareViewPager;
    List<Fragment> fragmentList = new ArrayList<Fragment>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, null);

        //找到对应的控件id
        squareViewPager = (ViewPager) view.findViewById(R.id.square_viewPager);
        discussBtn = (RadioButton) view.findViewById(R.id.rb_square_discuss);
        releaseBtn = (RadioButton) view.findViewById(R.id.rb_square_release);
        videoBtn = (RadioButton) view.findViewById(R.id.rb_square_video);

        //设置点击事件
        discussBtn.setOnClickListener(onClickListener);
        releaseBtn.setOnClickListener(onClickListener);
        videoBtn.setOnClickListener(onClickListener);

        discussBtn.setChecked(true);
        fragmentList.add(new SquareDiscussFragment());
        fragmentList.add(new SquareVideoFragment());
        fragmentManager = getChildFragmentManager();
        squareViewPager.setAdapter(new SquareFragmentPagerAdapter(fragmentManager,fragmentList));
        squareViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        discussBtn.setChecked(true);
                        break;
                    case 1:
                        videoBtn.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rb_square_discuss:
                    squareViewPager.setCurrentItem(0);
                    break;
                case R.id.rb_square_video:
                    squareViewPager.setCurrentItem(1);
                    break;
                case R.id.rb_square_release:
                    Intent intent = new Intent(getActivity(), SquarePublishActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
