package com.example.tippecanoe_county_sheriff_app.main;

/* File name : MainActivity.java
 * Description : Main Activity for app module
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.*;
import com.example.tippecanoe_county_sheriff_app.weather.WeatherAPI;


public class MainActivity extends AppCompatActivity {
    private static final float MAX_GRID_SIZE = 0.6f;
    private ButtonItem[] ButtonData;
    private GridView gridView;
    private ImageButtonAdapter imageButtonAdapter;
    private GridSetter gridSetter;
    private Guideline leftvertGL, rightvertGL, tophoriGL, bothoriGL;

    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        getSupportActionBar().hide();

        weatherView = new WeatherAPI(this);

        setGridViewGuideLines();
        gridSetter = new GridSetter(this);
        setGuidlinesPercent(gridSetter.getgVertMargin(),gridSetter.getgHoriMargin());

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

    private void setGridViewGuideLines() {
        leftvertGL = findViewById(R.id.ddguideline12);
        rightvertGL = findViewById(R.id.ddguideline14);
        tophoriGL = findViewById(R.id.dguideline20);
        bothoriGL = findViewById(R.id.dguideline4);
    }

    private void setGuidlinesPercent(float gridVMargin, float gridHMargin){
        tophoriGL.setGuidelinePercent((1.0f - MAX_GRID_SIZE) + gridVMargin);
        bothoriGL.setGuidelinePercent(1.0f - gridVMargin);
        leftvertGL.setGuidelinePercent(0.0f + gridHMargin);
        rightvertGL.setGuidelinePercent(1.0f - gridHMargin);
    }
}
