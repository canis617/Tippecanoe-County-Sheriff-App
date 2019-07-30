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

import static android.util.Log.d;

class ButtonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private  ArrayList<ButtonItem> buttonlist;
    private LayoutInflater inf;

    ButtonAdapter(Context context, int layout, ArrayList<ButtonItem> list) {
        this.context = context;
        this.layout = layout;
        setData(list);
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        ImageButton ib = convertView.findViewById(R.id.imagebutton);                                //item_button.xml
        if(position%2==0){ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor1)); }
        else{ ib.setBackgroundColor(context.getResources().getColor(R.color.ButtonColor2)); }
        //ib.setImageResource(buttonlist.get(position).getButtonImage());

        switch (buttonlist.get(position).getButtonType()){
            case "container":
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)context).setPrev_Data(buttonlist.toArray(new ButtonItem[0]));
                        ((MainActivity)context).setPageAdapter(buttonlist.get(position).getChild());
                    /*Context context = v.getContext();
                    Intent intent = buttonlist.get(position).getFunc();
                    intent.putExtra("ChildData",buttonlist.get(position).getChild());
                    intent.putExtra("UpperCategory","UpperCategory!");
                    try { context.startActivity(intent); }
                    catch (Exception e) { e.printStackTrace(); }
                */
                    }
                });
                break;
            case "single-func":
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
            case "double-func":
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        //intent.setPackage()
                        Intent Extraintent = buttonlist.get(position).getExtraFunc();
                        try {
                            context.startActivity(intent);
                        } catch (android.content.ActivityNotFoundException anfe) {
                            context.startActivity(Extraintent);
                            //new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName))
                        }
                    }
                });
                break;
            case"popup_container":
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //popup창 객체생성
                        //recyclerview 가져오기
                        //adapter buttonlist.get(position).getchild로 가져온 자식 버튼 넣어주기
                        //adapter 설정
                    }
                });
                break;
            default:
                d("jun","default");
                break;

        }
        /*if(buttonlist.get(position).getButtonType().equals("link")){                                     //link buttons

        }
        else if(buttonlist.get(position).getButtonType().equals("container")){

        }*/
        return convertView;
    }
}