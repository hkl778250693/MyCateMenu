package com.example.administrator.catemenu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.adapter.SearchResultAdapter;
import com.example.administrator.catemenu.modle.SearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SearchResultActivity extends Activity {
    ImageView imageViewBack;
    ListView listViewSearchResult;
    ListView listViewOtherTuijian;
    List<SearchResult> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        listViewSearchResult = (ListView) findViewById(R.id.search_result);
        listViewOtherTuijian = (ListView) findViewById(R.id.other_tuijian);
        list = getData();
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(this,list);
        listViewSearchResult.setAdapter(searchResultAdapter);
        listViewOtherTuijian.setAdapter(searchResultAdapter);
        imageViewBack = (ImageView) findViewById(R.id.search_result_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchResultActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    public List<SearchResult> getData(){
        list = new ArrayList<>();
        for (int i=0;i<5;i++){
            SearchResult searchResult = new SearchResult();
            searchResult.setImage(R.mipmap.shanyu2);
            searchResult.setCaiName("蒜仔烤鳝段");
            searchResult.setPublishPerson("某某");
            searchResult.setPublishTime("2016.11.22");
            list.add(searchResult);
        }
        return list;
    }
}
