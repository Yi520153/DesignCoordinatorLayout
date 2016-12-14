package com.lcl.designcoordinatorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<String> list = new ArrayList<>();
        list.add("CoordinatorLayout的协调View");
        list.add("CoordinatorLayout与TitleBar");

        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(MainActivity.this, list);
        myRecyclerViewAdapter.setMyRecyclerViewItemClick(new MyRecyclerViewItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, FollowViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,TitleBarActivity.class));
                        break;
                }
            }
        });
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
    }
}
