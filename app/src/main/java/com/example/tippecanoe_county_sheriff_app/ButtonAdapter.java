package com.example.tippecanoe_county_sheriff_app;

/* File name : ButtonAdapter.java
* Description : custom adapter for buttons to put in gridView
* */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import java.util.ArrayList;

class ButtonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<ButtonItem> buttonlist;
    private LayoutInflater inf;
    private OnActivityAction mCallBack;

    ButtonAdapter(Context context, int layout, ArrayList<ButtonItem> list, OnActivityAction listener) {
        this.context = context;
        this.layout = layout;
        buttonlist = list;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCallBack = listener;
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
        ImageButton iButton = convertView.findViewById(R.id.imagebutton);                           //item_button.xml

        iButton.setImageResource(buttonlist.get(position).getBimage());                             //button image

        if(!buttonlist.get(position).getIsConnector()){                                             //link buttons
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = buttonlist.get(position).getLinkIntent();
                    try { context.startActivity(intent); }
                    catch (Exception e) { e.printStackTrace(); }
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Admin"){                                    //send method to MainActivity to open submenu
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Admin");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Corrections"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Corrections");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Enforcement"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Enforcement");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Services"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Services");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "SocialMedia"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("SocialMedia");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Others"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Others");
                }
            });
        }
        else if(buttonlist.get(position).getChild() == "Sample"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.getSubMenu("Sample");
                }
            });
        }
        return convertView;
    }
}