package com.example.administrator.catemenu.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by abc on 2016/12/2.
 */
public class ImageViewPagerAdapter extends ViewPagerAdapter {
    List<View> imgs;
    public ImageViewPagerAdapter(List<View> imgs) {
        super(imgs);
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imgs.get(position));
        return imgs.get(position % imgs.size());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
