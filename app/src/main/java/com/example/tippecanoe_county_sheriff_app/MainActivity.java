package com.example.tippecanoe_county_sheriff_app;

/* File name : MainActivity.java
 * Description : Main Activity for app module
 * */

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private ButtonItem[] ButtonData;
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


        DataItem dataItem = new DataItem(this);                                                       //Data
        ButtonData = dataItem.getData();
        //Prev_Data.push(Data);
        /*if(Data==null){

        }
        if(Previ_Data.isEmpty()){
            //Pre_Data.add(Data);

        }*/
        gridView=findViewById(R.id.maingridview);
        imageButtonAdapter = new ImageButtonAdapter(this,R.layout.item_imagebutton,ArraytoList(ButtonData));
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
        else{ super.onBackPressed(); }
    }
    private ArrayList<ButtonItem> ArraytoList(ButtonItem[] buttonItems){
        ArrayList<ButtonItem> arrayList = new ArrayList<>();
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){
                arrayList.add(tempButton);
            }
        }
        return arrayList;
    }
}
