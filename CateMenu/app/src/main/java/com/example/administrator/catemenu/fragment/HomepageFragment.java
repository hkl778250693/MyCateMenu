package com.example.administrator.catemenu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SeasonRecommendActivity;
import com.example.administrator.catemenu.activity.TodayRecommendActivity;
import com.example.administrator.catemenu.activity.WeekOrderActivity;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/11.
 */
public class HomepageFragment extends Fragment implements View.OnClickListener {
    private RadioButton breakfast;
    private RadioButton desssert;
    private RadioButton dinner;
    private RadioButton lunch;
    ViewPager viewPager;
    RelativeLayout todayRecommend;
    RelativeLayout weekOrder;
    RelativeLayout season;
    Intent intent;
    Activity activity;

    private ArrayList<ImageView> imgBanner;
    private Handler handler;

    @Nullable
    @Override//加载页面
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        breakfast = (RadioButton) view.findViewById(R.id.btn_breakfast);
        desssert = (RadioButton) view.findViewById(R.id.btn_dessert);
        dinner = (RadioButton) view.findViewById(R.id.btn_dinner);
        lunch = (RadioButton) view.findViewById(R.id.btn_lunch);
        viewPager = (ViewPager) view.findViewById(R.id.homepage_viewpager);

        intopager();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        todayRecommend = (RelativeLayout) view.findViewById(R.id.today_recommend);
        weekOrder = (RelativeLayout) view.findViewById(R.id.week_order);
        season = (RelativeLayout) view.findViewById(R.id.season);
        activity = getActivity();

        breakfast.setChecked(true);
        breakfast.setOnClickListener(this);
        desssert.setOnClickListener(this);
        dinner.setOnClickListener(this);
        lunch.setOnClickListener(this);
        todayRecommend.setOnClickListener(this);
        weekOrder.setOnClickListener(this);
        season.setOnClickListener(this);
        return view;
    }
    //加载banner的数据
    public void intopager() {
        imgBanner = new ArrayList<ImageView>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(R.mipmap.banner);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setId(1000 + i);
            imgBanner.add(imageView);
        }
        ImageAdapter imageAdapter = new ImageAdapter(imgBanner);
        viewPager.setAdapter(imageAdapter);
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                switch (state) {
//                    case ViewPager.SCROLL_STATE_DRAGGING:
//                        handler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
//                        break;
//                    case ViewPager.SCROLL_STATE_IDLE:
//                        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//        viewPager.setCurrentItem(imgBanner.size() / 2);//默认在中间，使用户看不到边界
//        //开始轮播效果
//        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
    }

    //banner的适配器重写
    //viewpage的pagerAdapter
    private class ImageAdapter extends PagerAdapter {
        private ArrayList<ImageView> imgBanner;

        public ImageAdapter(ArrayList<ImageView> imgBanner) {
            this.imgBanner = imgBanner;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {//设置图片的的返回条数
            return imgBanner.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//找到对应的下标图片并显示出来
            position %= imgBanner.size();
            if (position < 0) {
                position = imgBanner.size() + position;
            }
            ImageView iv = imgBanner.get(position);
            ViewParent vp = iv.getParent();
            if (vp != null) {
                ViewGroup parent = (ViewGroup) vp;
                parent.removeView(iv);
            }
            container.addView(iv);

            return iv;
        }
    }

    private static class ImageHandler extends Handler {

        /**
         * 请求更新显示的View。
         */
        protected static final int MSG_UPDATE_IMAGE = 1;
        /**
         * 请求暂停轮播。
         */
        protected static final int MSG_KEEP_SILENT = 2;
        /**
         * 请求恢复轮播。
         */
        protected static final int MSG_BREAK_SILENT = 3;
        /**
         * 记录最新的页号，当用户手动滑动时需要记录新页号，否则会使轮播的页面出错。
         * 例如当前如果在第一页，本来准备播放的是第二页，而这时候用户滑动到了末页，
         * 则应该播放的是第一页，如果继续按照原来的第二页播放，则逻辑上有问题。
         */
        protected static final int MSG_PAGE_CHANGED = 4;

        //轮播间隔时间  
        protected static final long MSG_DELAY = 3000;

        //使用弱引用避免Handler泄露.这里的泛型参数可以不是Activity，也可以是Fragment等  
        private WeakReference<HomepageFragment> weakReference;
        private int currentItem = 0;

        protected ImageHandler(WeakReference<HomepageFragment> wk) {
            weakReference = wk;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("handleMessage", "receive message " + msg.what);
            HomepageFragment fragment = weakReference.get();
            if (fragment == null) {
                //Activity已经回收，无需再处理UI了  
                return;
            }
            //检查消息队列并移除未发送的消息，这主要是避免在复杂环境下消息出现重复等问题。  
            if (fragment.handler.hasMessages(MSG_UPDATE_IMAGE)) {
                fragment.handler.removeMessages(MSG_UPDATE_IMAGE);
            }
            switch (msg.what) {
                case MSG_UPDATE_IMAGE:
                    currentItem++;
                    fragment.viewPager.setCurrentItem(currentItem);
                    //准备下次播放  
                    fragment.handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                    break;
                case MSG_KEEP_SILENT:
                    //只要不发送消息就暂停了  
                    break;
                case MSG_BREAK_SILENT:
                    fragment.handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                    break;
                case MSG_PAGE_CHANGED:
                    //记录当前的页号，避免播放的时候页面显示不正确。  
                    currentItem = msg.arg1;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_breakfast:
                if (breakfast.isChecked() == true) {
                    desssert.setChecked(false);
                    dinner.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_dessert:
                if (desssert.isChecked() == true) {
                    breakfast.setChecked(false);
                    dinner.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_dinner:
                if (dinner.isChecked() == true) {
                    breakfast.setChecked(false);
                    desssert.setChecked(false);
                    lunch.setChecked(false);
                }
                break;
            case R.id.btn_lunch:
                if (lunch.isChecked() == true) {
                    breakfast.setChecked(false);
                    desssert.setChecked(false);
                    dinner.setChecked(false);
                }
                break;
            case R.id.today_recommend:
                intent = new Intent(activity, TodayRecommendActivity.class);
                startActivity(intent);
                break;
            case R.id.week_order:
                intent = new Intent(activity, WeekOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.season:
                intent = new Intent(activity, SeasonRecommendActivity.class);
                startActivity(intent);
                break;
        }
    }
}
