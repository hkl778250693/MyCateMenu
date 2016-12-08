package com.example.administrator.catemenu.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.fragment.ClassifyFragment;
import com.example.administrator.catemenu.fragment.FeastFragment;
import com.example.administrator.catemenu.fragment.HomepageFragment;
import com.example.administrator.catemenu.fragment.ShopFragment;
import com.example.administrator.catemenu.fragment.SquareFragment;
import com.example.administrator.catemenu.modle.AccessTokenKeeper;
import com.example.administrator.catemenu.modle.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/10/20.
 */
public class HomePageActivity extends FragmentActivity {
    HomepageFragment homepageFragment;
    ClassifyFragment classifyFragment;
    ShopFragment shopFragment;
    FeastFragment feastFragment;
    SquareFragment squareFragment;
    LinearLayout linearLayout;
    ImageView headimg;
    RadioButton homepageBtn;
    RadioButton classifyBtn;
    RadioButton shopBtn;
    RadioButton feastBtn;
    RadioButton squareBtn;
    ImageView moreImgview;
    ImageView headImageview;
    ImageView searchImgs;
    LayoutInflater layoutInflater;
    PopupWindow popupWindow;
    RadioButton integralBtn;
    RadioButton myAttentionBtn;
    RadioButton myUploadBtn;
    RadioButton mySixinBtn;
    RadioButton feedBackBtn;
    Intent intent;
    RadioGroup radioGroup;
    private long exitTime;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        linearLayout = (LinearLayout) findViewById(R.id.ll);
        homepageBtn = (RadioButton) findViewById(R.id.rb_homepage);
        classifyBtn = (RadioButton) findViewById(R.id.rb_classify);
        shopBtn = (RadioButton) findViewById(R.id.rb_shop);
        feastBtn = (RadioButton) findViewById(R.id.rb_feast);
        squareBtn = (RadioButton) findViewById(R.id.rb_square);
        //headimg= (ImageView) findViewById(R.id.head_imageview);
        searchImgs = (ImageView) findViewById(R.id.search_imgs);
        moreImgview = (ImageView) findViewById(R.id.more_imgview);
        headImageview = (ImageView) findViewById(R.id.head_imageview);

        //headimg.setOnClickListener(clickListener);
        homepageBtn.setOnClickListener(clickListener);
        classifyBtn.setOnClickListener(clickListener);
        shopBtn.setOnClickListener(clickListener);
        feastBtn.setOnClickListener(clickListener);
        squareBtn.setOnClickListener(clickListener);
        searchImgs.setOnClickListener(clickListener);
        moreImgview.setOnClickListener(clickListener);
        headImageview.setOnClickListener(clickListener);

        homepageBtn.setChecked(true);
        if (homepageBtn.isChecked()) {
            addHomepageFragment();
        }

    }

    String headImageUrl;
    public void intoweibo(){
        if(AccessTokenKeeper.readAccessToken(this)!=null){
           Oauth2AccessToken accessToken=AccessTokenKeeper.readAccessToken(this);
            WeiboParameters parameters=new WeiboParameters(Constants.APP_KEY);
            parameters.put("access_token",accessToken.getToken());
            parameters.put("uid",accessToken.getUid());
            AsyncWeiboRunner asyncWeiboRunner=new AsyncWeiboRunner(this);
            asyncWeiboRunner.requestAsync("https://api.weibo.com/2/users/show.json", parameters, "GET", new RequestListener() {
                @Override
                public void onComplete(String s) {
                    Log.i("onComplete=====",""+s);

                    try {
                        JSONObject jsonObject= null;
                        jsonObject = new JSONObject(s);

                        String jObj=jsonObject.getString("profile_image_url");
                        Log.i("JSONObject=====",""+jObj);
                        headImageUrl=jObj;
                        handler.sendEmptyMessage(0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onWeiboException(WeiboException e) {

                }
            });
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (v.getId()) {
                case R.id.rb_homepage:
                    if (homepageFragment == null) {
                        homepageFragment = new HomepageFragment();
                    }
                    transaction.replace(R.id.ll, homepageFragment);
                    break;
                case R.id.rb_classify:
                    if (classifyFragment == null) {
                        classifyFragment = new ClassifyFragment();
                    }
                    transaction.replace(R.id.ll, classifyFragment);
                    break;
                case R.id.rb_shop:  //餐具控件
                    if (shopFragment==null){
                        shopFragment=new ShopFragment();
                    }
                    transaction.replace(R.id.ll,shopFragment);
                    break;
                case R.id.rb_feast:
                    if (feastFragment==null){
                        feastFragment=new FeastFragment();
                    }
                    transaction.replace(R.id.ll,feastFragment);
                    break;
                case R.id.rb_square:
                    if(squareFragment==null){
                        squareFragment=new SquareFragment();
                    }
                    transaction.replace(R.id.ll,squareFragment);
                    break;
                case R.id.more_imgview:
                    startHomeMoreAnimation();
                    morePopupWindow();
                    break;
                case R.id.head_imageview:
                    intent = new Intent(HomePageActivity.this,GuidepageLoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.search_imgs:
                    intent = new Intent(HomePageActivity.this,SearchActivity.class);
                    startActivity(intent);
                    break;
            }
            transaction.commit();
        }
    };


    public void addHomepageFragment() {
        homepageFragment = new HomepageFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll, homepageFragment);
        fragmentTransaction.commit();
    }

    //首页more选项弹出框popupWindow
    public void morePopupWindow(){
        layoutInflater = LayoutInflater.from(this);
        View contentView = layoutInflater.inflate(R.layout.activity_popup_more,null);

        //找到对应控件id
        integralBtn = (RadioButton) contentView.findViewById(R.id.integral_btn);
        myAttentionBtn = (RadioButton) contentView.findViewById(R.id.my_attention_btn);
        myUploadBtn = (RadioButton) contentView.findViewById(R.id.my_upload_btn);
        mySixinBtn = (RadioButton) contentView.findViewById(R.id.my_sixin_btn);
        feedBackBtn = (RadioButton) contentView.findViewById(R.id.feed_back_btn);
        radioGroup = (RadioGroup) contentView.findViewById(R.id.radio_group);

        //设置点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.integral_btn:
                        intent = new Intent(HomePageActivity.this,FeedBackActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_attention_btn:
                        intent = new Intent(HomePageActivity.this,AttentionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_upload_btn:
                        intent = new Intent(HomePageActivity.this,UploadActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_sixin_btn:
                        intent = new Intent(HomePageActivity.this,SixinActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.feed_back_btn:
                        intent = new Intent(HomePageActivity.this,FeedBackActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        popupWindow = new PopupWindow(contentView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.homepage_edittext_serch_shape));
        popupWindow.showAsDropDown(moreImgview,-180,10);
    }

    public void startHomeMoreAnimation(){
        ObjectAnimator alphaAnimator =ObjectAnimator.ofFloat(moreImgview,"alpha",1.0F,0F,1.0F);
        alphaAnimator.setDuration(4000);
        alphaAnimator.setRepeatMode(alphaAnimator.REVERSE);
        ObjectAnimator rotateAnimator =ObjectAnimator.ofFloat(moreImgview,"RotationY",0F,180F,0F);
        rotateAnimator.setDuration(3000);
        rotateAnimator.setRepeatMode(rotateAnimator.REVERSE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).with(rotateAnimator);
        animatorSet.start();
    }

    public interface MyTouchListener {
        public boolean onTouchEvent(MotionEvent event);
    }

    // 保存MyTouchListener接口的列表
    private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<MyTouchListener>();

    /**
     * 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
     * @param listener
     */
    public void registerMyTouchListener(MyTouchListener listener) {
        myTouchListeners.add(listener);
    }

    /**
     * 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
     * @param listener
     */
    public void unRegisterMyTouchListener(MyTouchListener listener) {
        myTouchListeners.remove( listener );
    }

    /**
     * 分发触摸事件给所有注册了MyTouchListener的接口
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for (MyTouchListener listener : myTouchListeners) {
            listener.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序！", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
