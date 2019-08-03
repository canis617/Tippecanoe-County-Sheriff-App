package com.example.tippecanoe_county_sheriff_app;

/* File name : MainActivity.java
 * Description : Main Activity for app module
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {
    private ButtonItem[] ButtonData = null;
    private Stack<ButtonItem[]> Prev_Data = new Stack<>();
    private GridView gridView;
    ImageButtonAdapter imageButtonAdapter;


    //weather views
    public TextView cityField, currentTemperatureField, weatherIcon;


    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        getSupportActionBar().hide();
        weatherView = new WeatherAPI(this);

        Guideline vguideline = findViewById(R.id.dguideline20);
        Guideline vguideline2 = findViewById(R.id.dguideline4);
        Guideline hguideline = findViewById(R.id.ddguideline12);
        Guideline hguideline2 = findViewById(R.id.ddguideline14);

        //get screen size

        int mWidthPixels, mHeightPixels;


        WindowManager w = getWindowManager();
        Display display = w.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // since SDK_INT = 1;
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;

        // 상태바와 메뉴바의 크기를 포함해서 재계산
        if (Build.VERSION.SDK_INT >= 15 && Build.VERSION.SDK_INT < 17) {
            try {
                mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (Exception ignored) {
            }
        }
        // 상태바와 메뉴바의 크기를 포함
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                mWidthPixels = realSize.x;
                mHeightPixels = realSize.y;
            } catch (Exception ignored) {
            }
        }

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        //((height * 0.6 - length * 0.9)/2)/height
        float gridWidth = (float)mWidthPixels;
        float gridHeight = (float)mHeightPixels;

        float gridHMargin = 0.05f, gridVMargin;
        float count = 1;

        while(true){
            gridVMargin = (gridHeight* 0.56f - gridWidth)/2f/gridHeight;
            if(gridVMargin<0.02){
                gridWidth -= gridWidth*0.01;
            }
            else{
                if(gridWidth != mWidthPixels){
                    gridHMargin = (1 - gridWidth/mWidthPixels)/2.0f;
                }
                //gridVMargin = (gridHeight* 0.56f - gridWidth)/2f/gridHeight;
                gridVMargin = (float)Math.floor((gridHeight* 0.56f - gridWidth)/2f/gridHeight*100f)/100f;
                break;
            }
        }



        //gridMargin = (float)String.format("%.2f", ;
        //gridMargin = (dpHeight * 0.65f - dpWidth * 0.9f)/2/dpHeight;
        //d("jun","gmargin:"+gridMargin);

        vguideline.setGuidelinePercent(0.4f + gridVMargin);
        vguideline2.setGuidelinePercent(1.0f - gridVMargin);
        hguideline.setGuidelinePercent(0.0f + gridHMargin);
        hguideline2.setGuidelinePercent(1.0f - gridHMargin);

        d("alz","horimargin:"+gridHMargin);
        d("alz","vertmargin"+gridVMargin);
        d("jun","Height:"+ (mHeightPixels *0.6 * (1- (gridVMargin*2))));
        d("jun","Width:"+ mWidthPixels *(1-(gridHMargin*2)));

        if(ButtonData == null){
            //d("jun","null!");
            DataItem dataItem = new DataItem(this);                                                       //Data
            ButtonData = dataItem.getData();
        }


        gridView=findViewById(R.id.maingridview);
        //imageButtonAdapter = new ImageButtonAdapter(this,R.layout.item_imagebutton,ArraytoList(ButtonData),mWidthPixels*(1-(gridHMargin*2)), mWidthPixels);
        imageButtonAdapter = new ImageButtonAdapter(this,R.layout.item_imagebutton,ArraytoList(ButtonData),dpWidth, mWidthPixels,gridHMargin);
        gridView.setAdapter(imageButtonAdapter);
    }

    public void setPageAdapter(ButtonItem[] newData){
        imageButtonAdapter.setData(ArraytoList(newData));
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
    private ArrayList<ButtonItem> ArraytoList(ButtonItem[] buttonItems){
        ArrayList<ButtonItem> arrayList = new ArrayList<>();
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){ arrayList.add(tempButton); }
        }
        return arrayList;
    }
}
