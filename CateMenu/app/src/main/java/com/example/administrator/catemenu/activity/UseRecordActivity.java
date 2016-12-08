package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.UseRecordAdapter;
import com.example.administrator.catemenu.modle.UseRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by abc on 2016/12/8.
 */
public class UseRecordActivity extends Activity {
    @InjectView(R.id.mine_back_btn)
    ImageView mineBackBtn;
    @InjectView(R.id.listview)
    ListView listview;
    List<UseRecord> useRecordList = new ArrayList<UseRecord>();
    UseRecordAdapter useRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_record);
        ButterKnife.inject(this);
        getData();
        setListview();
    }

    @OnClick({R.id.mine_back_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_back_btn:
                finish();
                break;
        }
    }

    public void getData(){
        for(int i=0;i<10;i++){
            UseRecord useRecord = new UseRecord();
            useRecordList.add(useRecord);
        }
    }

    public void setListview(){
        useRecordAdapter = new UseRecordAdapter(UseRecordActivity.this,useRecordList);
        listview.setAdapter(useRecordAdapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UseRecordActivity.this);
                builder.setTitle("温馨提示：");
                builder.setMessage("确定要删除此项订单吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        useRecordList.remove(which);
                        Toast.makeText(UseRecordActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        useRecordAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UseRecordActivity.this,"取消删除",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog  alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }
}
