package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.catemenu.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/7.
 */
public class PersonalSettingsActivity extends Activity {
    private ImageView settingBackBtn;
    private Intent intent;
    private ImageView headImg;
    private LayoutInflater layoutInflater;
    private LinearLayout personSettingRootLl;
    private RadioButton photoBtn;
    private RadioButton cancleBtn;
    private RadioButton selectBtn;
    private PopupWindow popupWindow;
    private static final int SELECT_PHOTO = 0;
    private static final int TAKE_PHOTO = 1;
    private File tempFile;
    private String imageFileName = null;
    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_settings);

        //找到相应控件id
        settingBackBtn = (ImageView) findViewById(R.id.setting_back_btn);
        headImg = (ImageView) findViewById(R.id.head_img);
        personSettingRootLl = (LinearLayout) findViewById(R.id.person_setting_root_ll);

        //设置点击事件
        settingBackBtn.setOnClickListener(clickListener);
        headImg.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setting_back_btn:
                    intent = new Intent(PersonalSettingsActivity.this,MineActivity.class);
                    startActivity(intent);
                    break;
                case R.id.head_img:
                    photoPopupWindow();
                    break;
                case R.id.photo_btn:
                    takePhoto();
                    break;
                case R.id.select_btn:
                    selectPhoto();
                    break;
                case R.id.cancle_btn:
                    popupWindow.dismiss();
                    break;
            }
        }
    };

    //弹出一个popupwindow
    public void photoPopupWindow(){
        layoutInflater = LayoutInflater.from(this);
        View contentView = layoutInflater.inflate(R.layout.popupwindow_photo,null);
        //找到对应控件id
        photoBtn = (RadioButton) contentView.findViewById(R.id.photo_btn);
        cancleBtn = (RadioButton) contentView.findViewById(R.id.cancle_btn);
        selectBtn = (RadioButton) contentView.findViewById(R.id.select_btn);

        //设置点击事件
        photoBtn.setOnClickListener(clickListener);
        cancleBtn.setOnClickListener(clickListener);
        selectBtn.setOnClickListener(clickListener);
        cancleBtn.setChecked(true);


        popupWindow = new PopupWindow(contentView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.white));
        popupWindow.setAnimationStyle(R.style.Animation);
        popupWindow.showAtLocation(personSettingRootLl, Gravity.BOTTOM,0,0);
    }

    //选择本地照片
    private void selectPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
    //取回照片后返回本界面
        startActivityForResult(intent, SELECT_PHOTO);
    }

    //拍照
    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用系统照相机
        imageFileName = getFileName();
        tempFile = new File(Environment.getExternalStorageDirectory(),imageFileName);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));//存储到SD卡
        this.startActivityForResult(intent, TAKE_PHOTO);
    }

    //定义一个方法返回照片名称
    private String getFileName() {
        return "a.jpg";
    }

    //返回这个activity的回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {        //此处的RESULT_OK, 是系统自定义得一个常量
            Log.e("PersonalActivity", "ActivityResult resultCode error");
            return;
        }

        //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
        ContentResolver resolver = getContentResolver();
        //此处的用于判断接收的Activity是不是你想要的那个
        switch (requestCode) {
            case TAKE_PHOTO:
                doTakePhoto();
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                break;
            case SELECT_PHOTO:
                doSelectPhoto(data, resolver);
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                break;
        }
    }

    private void doSelectPhoto(Intent data, ContentResolver resolver) {
        try {
            Uri originalUri = data.getData();//获得图片的uri
            bitmap = MediaStore.Images.Media.getBitmap(resolver, originalUri);//显示得到bitmap图片
            //这里开始的第二部分，获取图片的路径：
            String[] proj = {MediaStore.Images.Media.DATA};
            //好像是android多媒体数据库的封装接口，具体的看Android文档
            Cursor cursor = managedQuery(originalUri, proj, null, null, null);
            //按我个人理解 这个是获得用户选择的图片的索引值
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            //将光标移至开头 ，这个很重要，不小心很容易引起越界
            cursor.moveToFirst();
            //最后根据索引值获取图片路径
            String path = cursor.getString(column_index);
            setImage(originalUri);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void doTakePhoto() {
        /*File tempFile = new File(Environment.getExternalStorageDirectory()+"Photo/images/", imageFileName);*/
        setImage(Uri.fromFile(tempFile));
    }

    private void setImage(Uri uri) {
        ContentResolver cr = this.getContentResolver();
        try{
//将取得的图片转换成Bitmap格式
            bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//设置到ImageView上
            headImg.setImageBitmap(bitmap);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
