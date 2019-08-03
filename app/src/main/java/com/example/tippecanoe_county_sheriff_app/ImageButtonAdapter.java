package com.example.tippecanoe_county_sheriff_app;

/* File name : ImageButtonAdapter.java
* Description : custom adapter for buttons to put in gridView
* */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.util.Log.d;

class ImageButtonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private  ArrayList<ButtonItem> buttonlist;
    private LayoutInflater inf;
    private PopupWindow pwindo;
    private float buttonWidth, gridHMargin;
    private int mWidthPixels;

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    ImageButtonAdapter(Context context, int layout, ArrayList<ButtonItem> list, float buttonWidth, int mWidthPixels, float gridHMargin) {
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
        //ib.setMaxHeight((int));
        //ib.setMaxWidth((int));

        //ib.setLayoutParams(new ConstraintLayout.LayoutParams((int)(mWidthPixels/3),(int)(mWidthPixels/3)));

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) ib.getLayoutParams();


        // Set the height of this ImageButton
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (buttonWidth*(1-(gridHMargin*2)))/3, ib.getResources().getDisplayMetrics());

        // Set the width of that ImageButton
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (buttonWidth*(1-(gridHMargin*2)))/3, ib.getResources().getDisplayMetrics());

        //params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, ((MainActivity)context).getResources().getDisplayMetrics());
        //params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, ((MainActivity)context).getResources().getDisplayMetrics());

        // Apply the updated layout parameters to last ImageButton
        ib.setLayoutParams(params);

        //d("jun","Button's:"+ ib.getLayoutParams().width);

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
            case SINGLEFUNC:
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
            case DOUBLEFUNC:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonlist.get(position).getFunc();
                        if(buttonlist.get(position).getButtonName().equals("Instagram")){ intent.setPackage("com.instagram.android"); }
                        else if(buttonlist.get(position).getButtonName().equals("Video Visitation")){
                            ComponentName componentName =  new ComponentName("air.com.renovo.vismobile","air.com.renovo.vismobile.AppEntry");
                            intent.addCategory(Intent.CATEGORY_LAUNCHER);
                            intent.setComponent(componentName);
                        }
                        Intent Extraintent = buttonlist.get(position).getExtraFunc();
                        try {
                            context.startActivity(intent);
                        } catch (android.content.ActivityNotFoundException anfe) {
                            context.startActivity(Extraintent);
                            //
                        }
                    }
                });
                break;
            case NEWPAGE:
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
            case POPUPCONTAINER:
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btnClosePopup;

                        /*


                        WindowManager w = ((MainActivity) context).getWindowManager();
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
                        */
                        try {
                            LayoutInflater infla = (LayoutInflater) ((MainActivity) context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                            View layout = infla.inflate(R.layout.activity_pop_up_window, (ViewGroup) ((MainActivity) context).findViewById(R.id.popup_element));


                            pwindo = new PopupWindow(layout, (int)(mWidthPixels*0.9), ViewGroup.LayoutParams.WRAP_CONTENT, true);
                            //pwindo = new PopupWindow(layout,);
                            //pwindo.setOutsideTouchable(false);
                            //View pwview = pwindo.getContentView();
                            //layout.setFocusable(true);
                            pwindo.setOutsideTouchable(true);
                            pwindo.setBackgroundDrawable(new BitmapDrawable());
                            //layout.setFocusableInTouchMode(true);
                            /*layout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                @Override
                                public void onFocusChange(View v, boolean hasFocus) {
                                    if (!hasFocus) {
                                        activity.onBackPressed();
                                    }
                                    //d("jun","nofocus");
                                }
                            });
                            layout.requestFocus();*/
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
                            //recyclerview 가져오기
                            //adapter buttonlist.get(position).getchild로 가져온 자식 버튼 넣어주기
                            //adapter 설정
                        } catch (Exception e) {
                        }
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