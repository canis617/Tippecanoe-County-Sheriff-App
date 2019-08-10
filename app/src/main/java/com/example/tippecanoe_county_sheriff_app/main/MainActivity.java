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


public class MainActivity extends AppCompatActivity {
    private ButtonItem[] ButtonData;
    private GridView gridView;
    private GridViewGuideLines gridLines;
    private ImageButtonAdapter imageButtonAdapter;
    private GridSetter gridSetter;

    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        getSupportActionBar().hide();

        weatherView = new WeatherAPI(this);

        gridLines = new GridViewGuideLines(findViewById(android.R.id.content));
        gridSetter = new GridSetter(this);
        gridLines.setGuidlinesPercent(gridSetter.getgVertMargin(),gridSetter.getgHoriMargin());

        DataItem dataItem = new DataItem(this);                                                       //Data
        ButtonData = dataItem.getData();

        gridView=findViewById(R.id.maingridview);
        imageButtonAdapter = new ImageButtonAdapter(this,R.layout.item_imagebutton,ButtonData,gridSetter);
        gridView.setAdapter(imageButtonAdapter);
    }

    @Override
    public void onBackPressed() {
        if(!imageButtonAdapter.prevIsEmpty()){
            ButtonItem[] tempItem = imageButtonAdapter.prevPop();
            imageButtonAdapter.setData(tempItem);
        }
        else{
            Toast.makeText(getApplicationContext(),"App is Closing", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }
}
