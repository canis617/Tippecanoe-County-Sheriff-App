package com.example.tippecanoe_county_sheriff_app.main;

/* File name : ImageButtonAdapter.java
* Description : custom adapter for buttons to put in gridView
* */
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.ButtonItem;

import java.util.ArrayList;
import java.util.Stack;

//should we divide a calc-screen size
class ImageButtonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private Stack<ButtonItem[]> prev_Buttons;
    private ArrayList<ButtonItem> buttonItems;
    private LayoutInflater inf;
    private GridSetter gridSetter;
    private OnClickEvents onClickEvents;

    //Constructor
    public ImageButtonAdapter(Context context, int layout, ButtonItem[] list, GridSetter gridSetter) {
        this.context = context;
        this.layout = layout;
        setData(list);
        prev_Buttons = new Stack<>();
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.gridSetter = gridSetter;
        onClickEvents = new OnClickEvents();
    }
    public void setData(ButtonItem[] list){
        buttonItems = arrayToList(list);
        notifyDataSetChanged();
    }
    public boolean prevIsEmpty(){
        if (prev_Buttons.isEmpty()){return true;}
        else {return false;}
    }
    public ButtonItem[] prevPop(){
        ButtonItem[] tempitems = prev_Buttons.peek();
        prev_Buttons.pop();
        return tempitems;
    }
    @Override
    public int getCount() {
        return buttonItems.size();
    }
    @Override
    public Object getItem(int position) {
        return buttonItems.get(position);
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
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (gridSetter.getDpWidth()*(1-(gridSetter.getgHoriMargin()*2)))/3, ib.getResources().getDisplayMetrics());
        // Set the width of that ImageButton
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (gridSetter.getDpWidth()*(1-(gridSetter.getgHoriMargin()*2)))/3, ib.getResources().getDisplayMetrics());
        // Apply the updated layout parameters to last ImageButton
        ib.setLayoutParams(params);

        if(position%2==0){ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor1)); }
        else{ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor2)); }

        ib.setImageResource(buttonItems.get(position).getButtonContent());

        switch (buttonItems.get(position).getButtonType()){
            case CONTAINER:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        prev_Buttons.push(buttonItems.toArray(new ButtonItem[0]));
                        setData(buttonItems.get(position).getChild());
                    }
                });
                break;
            case POPUPCONTAINER:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{ Popup popup = new Popup(v,inf, buttonItems.get(position),gridSetter.getmWidthPixels()); }
                        catch (Exception e){ }
                    }
                });
                break;
            case AUTODIAL:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.dialOnClick(v, buttonItems.get(position)); }
                });
                break;
            case LINKTONEWPAGE:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.newPageOnClick(v, buttonItems.get(position)); }
                });
                break;
            case LINKTOWEB:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.webOnClick(v, buttonItems.get(position)); }
                });
                break;
            case LINKTOAPP:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.appOnClick(v, buttonItems.get(position)); }
                });
                break;
            case LINKTOSNS:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.snsOnClick(v, buttonItems.get(position)); }
                });
                break;
            default:
                break;

        }
        return convertView;
    }

    private ArrayList<ButtonItem> arrayToList(ButtonItem[] buttonItems){
        ArrayList<ButtonItem> arrayList = new ArrayList<>();
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){ arrayList.add(tempButton); }
        }
        return arrayList;
    }
}