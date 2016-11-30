package com.example.administrator.catemenu.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.catemenu.R;

/**
 * Created by Administrator on 2016/11/30.
 */
public class BuySuccessActivity extends Activity {
    LayoutInflater layoutInflater;
    LinearLayout linearLayout;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_success);
        //找到相应控件
        textView = (TextView) findViewById(R.id.buy_success_queding);
        imageView = (ImageView) findViewById(R.id.back_buy_success);
        //设置点击事件
        textView.setOnClickListener(onClickListener);
        imageView.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_buy_success:
                    finish();
                    break;
                case R.id.buy_success_queding:
                    createPopupwindow();
                    break;
            }
        }
    };

    public void createPopupwindow(){
        layoutInflater = LayoutInflater.from(this);
        final View view = layoutInflater.inflate(R.layout.popupwindow_buy_success,null);
        PopupWindow popupWindow = new PopupWindow(view,500,500);
        linearLayout = (LinearLayout) findViewById(R.id.buy_success_linearlayout);
        ImageView imageViewBitmap = (ImageView) view.findViewById(R.id.buy_success_bitmap);
        popupWindow.showAtLocation(linearLayout,Gravity.CENTER,0,100);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageViewBitmap,"rotation",0F,360F);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        AnimatorSet animatorSet = new AnimatorSet();
        //objectAnimator.start();
        animatorSet.play(objectAnimator);
        animatorSet.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                TextView textViewBuySuccess = (TextView) view.findViewById(R.id.buy_success_textview);
                textViewBuySuccess.setText("购买成功");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
