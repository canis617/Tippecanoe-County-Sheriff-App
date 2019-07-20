package com.example.tippecanoe_county_sheriff_app;

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
    private ArrayList<object_item> buttonlist;
    private LayoutInflater inf;
    private OnButtonClick mCallBack;

    ButtonAdapter(Context context, int layout, ArrayList<object_item> list, OnButtonClick listener) {
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

        //Cause img is not added
        iButton.setImageResource(buttonlist.get(position).getBimage());

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
        else if(buttonlist.get(position).getChild() == "Jail"){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.onClick(1);
                }
            });
        }
        return convertView;
    }
}