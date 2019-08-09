package com.example.tippecanoe_county_sheriff_app.main;

/* File name : MainActivity.java
 * Description : Main Activity for app module
 * */

import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.*;
import com.example.tippecanoe_county_sheriff_app.weather.WeatherAPI;

import java.util.ArrayList;
import java.util.Stack;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {
    private ButtonItem[] ButtonData = null;
    private Stack<ButtonItem[]> Prev_Data = new Stack<>();  //need to seperate
    private GridView gridView;
    private GridViewGuideLines gridLines;
    private ImageButtonAdapter imageButtonAdapter;
    private ScreensizeCalc screensizeCalc;
    private MarginCalc marginCalc;

    private int mWidthPixels, mHeightPixels;
    private float dpHeight, dpWidth;
    private float gHoriMargin, gVertMargin;
    private static final float MAX_GRID_PERC = 0.56f;
    private static final float MIN_MARGIN_PERC = 0.02f;
    //weather views
    //need to move: Weather...


    //
    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        getSupportActionBar().hide();

        weatherView = new WeatherAPI(this);

        gridLines = new GridViewGuideLines(findViewById(android.R.id.content));


        screensizeCalc = new ScreensizeCalc(this);
        marginCalc = new MarginCalc(screensizeCalc.getmWidthPixels(),screensizeCalc.getmHeightPixels());
        gHoriMargin = marginCalc.getgHoriMargin();
        gVertMargin = marginCalc.getgVertMargin();
        gridLines.setGuidlinesPercent(gVertMargin,gHoriMargin);

//        if(ButtonData == null){
//
//        }
        DataItem dataItem = new DataItem(this);                                                       //Data
        ButtonData = dataItem.getData();

        mWidthPixels = screensizeCalc.getmWidthPixels();
        dpWidth = screensizeCalc.getDpWidth();

        gridView=findViewById(R.id.maingridview);
        imageButtonAdapter = new ImageButtonAdapter(this,R.layout.item_imagebutton,arrayToList(ButtonData),dpWidth, mWidthPixels,gHoriMargin);
        gridView.setAdapter(imageButtonAdapter);
    }

    public void setPageAdapter(ButtonItem[] newData){
        imageButtonAdapter.setData(arrayToList(newData));
        imageButtonAdapter.notifyDataSetChanged();
    }
    public void setPrev_Data(ButtonItem[] object_items){
        Prev_Data.push(object_items);
    }


    @Override
    public void onBackPressed() {
        if(!Prev_Data.isEmpty()){
            ButtonData = Prev_Data.peek();
            setPageAdapter(ButtonData);
            Prev_Data.pop();
        }
        else{
            Toast.makeText(getApplicationContext(),"App is Closing", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }
    private ArrayList<ButtonItem> arrayToList(ButtonItem[] buttonItems){
        ArrayList<ButtonItem> arrayList = new ArrayList<>();
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){ arrayList.add(tempButton); }
        }
        return arrayList;
    }
}
