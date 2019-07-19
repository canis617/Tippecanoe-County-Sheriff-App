package com.example.tippecanoe_county_sheriff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        setContentView(R.layout.activity_main);

        data_item itemData = new data_item();                                                       //Data
        object_item[] Data = itemData.getAllData();                                                 //need 2 fix

        ViewPager viewPager = findViewById(R.id.viewpager);                                         //viewPager

        pageAdapter = new PageAdapter(getSupportFragmentManager(),Data);
        viewPager.setAdapter(pageAdapter);
    }

    //2 set a new data to pageAdapter
    //not good
    //mayb we won't use
    /*
    public void setPageAdapter(object_item[] newData){
        pageAdapter.setPageData(newData);
        pageAdapter.notifyDataSetChanged();
    }
    */
}
