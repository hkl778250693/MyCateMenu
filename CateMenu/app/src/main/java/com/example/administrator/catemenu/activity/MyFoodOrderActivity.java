package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.OrderAdapter;
import com.example.administrator.catemenu.modle.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 2016/11/11.
 */
public class MyFoodOrderActivity extends Activity {
    ListView listView;
    List<Order> list;
    ImageView imageView;
    OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_my_order);
        listView = (ListView) findViewById(R.id.my_order_listview);
        list = getData();
        orderAdapter = new OrderAdapter(this,list);
        listView.setAdapter(orderAdapter);
        imageView = (ImageView) findViewById(R.id.my_order_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFoodOrderActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyFoodOrderActivity.this);
                builder.setTitle("温馨提示：");
                builder.setMessage("确定要删除此项订单吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        Toast.makeText(MyFoodOrderActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        orderAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyFoodOrderActivity.this,"放弃删除",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog  alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }
    public List<Order> getData(){
       list = new ArrayList<Order>();
        for (int i=0;i<10;i++){
            Order order = new Order();
            order.setImage(R.mipmap.hongtanmu);
            order.setName("鸿拓天然红木筷子");
            order.setCaiZi("天然木材");
            order.setPrice(25.0);
            order.setNumber(1);
            order.setState("已支付");
            list.add(order);
        }
        return list;
    }
}
