package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.TodayRecommendAdapter;
import com.example.administrator.catemenu.modle.TodayRecommendItem;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.marshalchen.common.commonUtils.urlUtils.HttpUtilsAsync;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;


/**
 * Created by abc on 2016/11/11.
 */
public class TodayRecommendActivity extends Activity {


    private View view;
    @InjectView(R.id.back_btn)
    ImageView backBtn;
    @InjectView(R.id.head_img)
    ImageView headImg;
    @InjectView(R.id.listview)
    ListView listview;

    private ArrayList<TodayRecommendItem.ResultBean> resultBeanList = new ArrayList<TodayRecommendItem.ResultBean>();
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_recommend);
        bundle = getIntent().getExtras();
        ButterKnife.inject(this);
        LayoutInflater layoutInflater = getLayoutInflater().cloneInContext(this);
        view = layoutInflater.inflate(R.layout.listview_head_today_recommend, null);
        listview.addHeaderView(view);
        TodayRecommendAdapter adapter=new TodayRecommendAdapter(this,resultBeanList);
        listview.setAdapter(adapter);
        httpRequest();
    }

    public void setFlipper() {


    }

    public void httpRequest() {
        ArrayList<String> strings=bundle.getStringArrayList("foodid");
        RequestParams requestParams = new RequestParams();
        for (int i = 0; i < strings.size(); i++) {
            requestParams.add("foodid",""+strings.get(i));
        }
        HttpUtilsAsync.get("http://10.0.2.2/index.php/home/index/food_details",requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.i("httpRequestonSuccess", "" + response);
                try {
                    JSONArray jsonArray=response.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        TodayRecommendItem.ResultBean resultBean=new TodayRecommendItem.ResultBean();
                        resultBean.setName(jsonObject.getString("name"));
                        resultBean.setImageurl_small(jsonObject.get("Imageurl_small"));
                        resultBeanList.add(resultBean);
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


}
