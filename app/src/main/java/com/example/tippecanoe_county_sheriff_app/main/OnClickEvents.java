package com.example.tippecanoe_county_sheriff_app.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.tippecanoe_county_sheriff_app.data.*;


public class OnClickEvents {

    public void dialOnClick(View view, ButtonItem button){
        Context context = view.getContext();
        Intent intent = button.getFunc();
        try { context.startActivity(intent); }
        catch (Exception e) { e.printStackTrace(); }
    }
    public void newPageOnClick(View view, ButtonItem button){
        Context context = view.getContext();
        Intent intent = button.getFunc();
        intent.putExtra("ButtonName",button.getButtonName());
        switch(button.getButtonName()){
            case "Traffic Complaints":
                break;
            case "Security Request":
                break;
            case "Extra Patrol Request":
                break;
        }

        context.startActivity(intent);
    }
    public void webOnClick(View view, ButtonItem button){
        Context context = view.getContext();
        Intent intent = button.getFunc();
        try { context.startActivity(intent); }
        catch (Exception e) { e.printStackTrace(); }
    }
    public void appOnClick(View view, ButtonItem button){
        Context context = view.getContext();
        Intent intent = button.getFunc();
        if(button.getButtonName().equals("Video Visitation")){
            ComponentName componentName =  new ComponentName("air.com.renovo.vismobile","air.com.renovo.vismobile.AppEntry");
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(componentName);
        }
        //desc

        Intent Extraintent = button.getExtraFunc();
        try { context.startActivity(intent); }
        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
    }
    public void snsOnClick(View view, ButtonItem button){
        Context context = view.getContext();
        Intent intent = button.getFunc();
        if(button.getButtonName().equals("Instagram")){ intent.setPackage("com.instagram.android"); }
        //desc

        Intent Extraintent = button.getExtraFunc();
        try { context.startActivity(intent); }
        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }

    }

}
