package com.example.administrator.catemenu.activity;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.TodayRecommendAdapter;
import com.example.administrator.catemenu.modle.TodayRecommendItem;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.marshalchen.common.commonUtils.urlUtils.HttpUtilsAsync;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;


/**
 * Created by abc on 2016/11/11.
 */
public class TodayRecommendActivity extends Activity implements GestureDetector.OnGestureListener {


    @InjectView(R.id.tv_Recommendname)
    TextView tvRecommendname;
    @InjectView(R.id.back_btn)
    ImageView backBtn;
    @InjectView(R.id.head_img)
    ImageView headImg;
    @InjectView(R.id.listview)
    ListView listview;
    private View view;
    private ViewFlipper flipper;
    private List<TodayRecommendItem.ResultBean> resultBeanList = new ArrayList<TodayRecommendItem.ResultBean>();
    private Bundle bundle;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_recommend);
        bundle = getIntent().getExtras();
        ButterKnife.inject(this);
        LayoutInflater layoutInflater = getLayoutInflater().cloneInContext(this);
        view = layoutInflater.inflate(R.layout.listview_head_today_recommend, null);
        listview.addHeaderView(view);
        httpRequest();
        setFlipper();
        detector = new GestureDetector(this);
    }

    public void setFlipper() {
        final RadioButton radioButton1 = (RadioButton) view.findViewById(R.id.radio_btn1);
        final RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.radio_btn2);
        final RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.radio_btn3);
        final RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.radio_btn4);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        flipper = (ViewFlipper) view.findViewById(R.id.flipper);
        HttpUtilsAsync.get("http://10.0.2.2/index.php/home/index/banner_today", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArray = response.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        final ImageView imageView = new ImageView(TodayRecommendActivity.this);
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setId(1000 + i);
                        imageView.setTag(i);
                        flipper.addView(imageView);
                        ImageLoader imageLoader = ImageLoader.getInstance();
                        imageLoader.init(ImageLoaderConfiguration.createDefault(TodayRecommendActivity.this));
                        imageLoader.displayImage("http://10.0.2.2/Public/" + jsonObject.getString("bannerimageurl"), imageView, new ImageLoadingListener() {
                            @Override
                            public void onLoadingStarted(String s, View view) {
                            }

                            @Override
                            public void onLoadingFailed(String s, View view, FailReason failReason) {

                            }

                            @Override
                            public void onLoadingComplete(String s, View view, Bitmap bitmap) {

                            }

                            @Override
                            public void onLoadingCancelled(String s, View view) {

                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        flipper.setFlipInterval(3000);
        flipper.startFlipping();
        flipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                ImageView imageView = (ImageView) flipper.getCurrentView();
                //Log.i("onLayoutChange",""+imageView.getTag());
                switch ((int) imageView.getTag()) {
                    case 0:
                        radioButton1.setChecked(true);
                        break;
                    case 1:
                        radioButton2.setChecked(true);
                        break;
                    case 2:
                        radioButton3.setChecked(true);
                        break;
                    case 3:
                        radioButton4.setChecked(true);
                        break;
                }
            }
        });
    }

    public void httpRequest() {
        String foodname = bundle.getString("food");
        HttpUtilsAsync.get("http://10.0.2.2/index.php/home/index/" + foodname, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.i("httpRequestonSuccess", "" + response);

                try {
                    JSONArray jsonArray = response.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        TodayRecommendItem.ResultBean resultBean = new TodayRecommendItem.ResultBean();
                        resultBean.setName(jsonObject.getString("name"));
                        resultBean.setId(jsonObject.getString("id"));
                        tvRecommendname.setText(jsonObject.getString("recommendedname"));
                        resultBeanList.add(resultBean);
                        TodayRecommendAdapter adapter = new TodayRecommendAdapter(TodayRecommendActivity.this, resultBeanList);
                        listview.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @OnClick({R.id.back_btn, R.id.head_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.head_img:
                Intent intent = new Intent(this, MineActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.i("onDown", "onDown======");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.i("onShowPress", "onShowPress======");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.i("onSingleTapUp", "onSingleTapUp======");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.i("onScroll", "onScroll======");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.i("onLongPress", "onLongPress======");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
