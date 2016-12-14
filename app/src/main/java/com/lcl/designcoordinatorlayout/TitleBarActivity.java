package com.lcl.designcoordinatorlayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TitleBarActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_bar);
        myRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        //toolbar.setTitle("TitleBarActivity");

        CollapsingToolbarLayout collapsing= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing.setTitle("TitleBarActivity");

        //toolbar.setTitle("TitleBarActivity");
        setSupportActionBar(toolbar);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(TitleBarActivity.this,LinearLayoutManager.VERTICAL,false));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(TitleBarActivity.this,getData());
        myRecyclerView.setAdapter(adapter);
    }

    private List<String> getData(){
        List<String> list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("RecyclerView"+i);
        }
        return list;
    }
}
