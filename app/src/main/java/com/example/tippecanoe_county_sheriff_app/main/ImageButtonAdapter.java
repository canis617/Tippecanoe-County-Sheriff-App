package com.example.tippecanoe_county_sheriff_app.main;

/* File name : ImageButtonAdapter.java
* Description : custom adapter for buttons to put in gridView
* */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.ButtonItem;

import java.util.ArrayList;

//should we divide a calc-screen size
class ImageButtonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private  ArrayList<ButtonItem> buttonlist;
    private PopupWindow pwindo;
    private LayoutInflater inf;
    private float buttonWidth, gridHMargin;
    private int mWidthPixels;

    //Constructor
    public ImageButtonAdapter(Context context, int layout, ArrayList<ButtonItem> list, float buttonWidth, int mWidthPixels, float gridHMargin) {
        this.context = context;
        this.layout = layout;
        setData(list);
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.buttonWidth = buttonWidth;
        this.mWidthPixels = mWidthPixels;
        this.gridHMargin = gridHMargin;
    }
    public void setData(ArrayList<ButtonItem> list){
        buttonlist = list;
    }
    @Override
    public int getCount() {
        return buttonlist.size();
    }
    @Override
    public Object getItem(int position) {
        return buttonlist.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = inf.inflate(layout, null);

        ImageButton ib = convertView.findViewById(R.id.imagebutton);                                //item_imagebutton.xmln.xml

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) ib.getLayoutParams();
        // Set the height of this ImageButton
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (buttonWidth*(1-(gridHMargin*2)))/3, ib.getResources().getDisplayMetrics());
        // Set the width of that ImageButton
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (buttonWidth*(1-(gridHMargin*2)))/3, ib.getResources().getDisplayMetrics());
        // Apply the updated layout parameters to last ImageButton
        ib.setLayoutParams(params);

        if(position%2==0){ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor1)); }
        else{ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor2)); }
        ib.setImageResource(buttonlist.get(position).getButtonContent());

        switch (buttonlist.get(position).getButtonType()){
            case CONTAINER:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)context).setPrev_Data(buttonlist.toArray(new ButtonItem[0]));
                        ((MainActivity)context).setPageAdapter(buttonlist.get(position).getChild());
                    }
                });
                break;
            case LINKTONEWPAGE:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        intent.putExtra("ButtonName",buttonlist.get(position).getButtonName());
                        context.startActivity(intent);
                    }
                });
                break;
            case AUTODIAL:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        try { context.startActivity(intent); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                });
                break;
            case LINKTOAPP:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        if(buttonlist.get(position).getButtonName().equals("Instagram")){ intent.setPackage("com.instagram.android"); }
                        //desc

                        Intent Extraintent = buttonlist.get(position).getExtraFunc();
                        try { context.startActivity(intent); }
                        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
                    }
                });
                break;
            case LINKTOSNS:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        if(buttonlist.get(position).getButtonName().equals("Video Visitation")){
                            ComponentName componentName =  new ComponentName("air.com.renovo.vismobile","air.com.renovo.vismobile.AppEntry");
                            intent.addCategory(Intent.CATEGORY_LAUNCHER);
                            intent.setComponent(componentName);
                        }
                        //desc

                        Intent Extraintent = buttonlist.get(position).getExtraFunc();
                        try { context.startActivity(intent); }
                        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
                    }
                });
                break;
            case LINKTOWEB:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        try { context.startActivity(intent); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                });
                break;
            case POPUPCONTAINER:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btnClosePopup;
                        try {
                            LayoutInflater infla = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View layout = infla.inflate(R.layout.activity_pop_up_window, (ViewGroup) ((MainActivity) context).findViewById(R.id.popup_element));

                            pwindo = new PopupWindow(layout, (int)(mWidthPixels*0.9), ViewGroup.LayoutParams.WRAP_CONTENT, true);
                            pwindo.setOutsideTouchable(true);
                            pwindo.setBackgroundDrawable(new BitmapDrawable());
                            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

                            btnClosePopup = layout.findViewById(R.id.btn_close_popup);
                            btnClosePopup.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) { pwindo.dismiss();
                                }
                                //activity.getSubMenu("Main");
                                //activity.onBackPressed();

                            });
                            TextView categorybar = layout.findViewById(R.id.categorybar);
                            categorybar.setText(buttonlist.get(position).getButtonName());

                            RecyclerView poprecview = layout.findViewById(R.id.popuprecyclerview);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext());
                            ButtonAdapter buttonAdapter = new ButtonAdapter(buttonlist.get(position).getChild());
                            poprecview.setLayoutManager(layoutManager);
                            poprecview.setAdapter(buttonAdapter);
                        } catch (Exception e) { }
                    }
                    });
                break;
            default:
                break;

        }
        return convertView;
    }
}