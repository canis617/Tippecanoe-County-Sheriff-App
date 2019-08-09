package com.example.tippecanoe_county_sheriff_app.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.ButtonItem;

import java.util.ArrayList;

public class OnClickEvents {
    public void containerOnClick(Context context, ArrayList<ButtonItem> buttonItems , ButtonItem button){
        ((MainActivity)context).setPrev_Data(buttonItems.toArray(new ButtonItem[0]));
        ((MainActivity)context).setPageAdapter(button.getChild());
    }
    public void popupOnClick(Context context, ButtonItem button ){
        Button btnClosePopup;

        try {
            LayoutInflater infla = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = infla.inflate(R.layout.activity_pop_up_window, (ViewGroup) ((MainActivity) context).findViewById(R.id.popup_element));

            //new popup object
//            pwindo = new PopupWindow(layout, (int)(mWidthPixels*0.9), ViewGroup.LayoutParams.WRAP_CONTENT, true);
//            pwindo.setOutsideTouchable(true);
//            pwindo.setBackgroundDrawable(new BitmapDrawable());
//            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
//
//            btnClosePopup = layout.findViewById(R.id.btn_close_popup);
//            btnClosePopup.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) { pwindo.dismiss(); }
//            });
//            TextView categorybar = layout.findViewById(R.id.categorybar);
//            categorybar.setText(button.getButtonName());
//
//            RecyclerView poprecview = layout.findViewById(R.id.popuprecyclerview);
//            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext());
//            ButtonAdapter buttonAdapter = new ButtonAdapter(button.getChild());
//            poprecview.setLayoutManager(layoutManager);
//            poprecview.setAdapter(buttonAdapter);

        } catch (Exception e) { }
    }
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
        if(button.getButtonName().equals("Instagram")){ intent.setPackage("com.instagram.android"); }
        //desc

        Intent Extraintent = button.getExtraFunc();
        try { context.startActivity(intent); }
        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
    }
    public void snsOnClick(View view, ButtonItem button){
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

}
