package com.example.tippecanoe_county_sheriff_app;

/* File name : MenuFragmentMaint.java
 * Description : Menu Fragment for MainActivity's Fragment
 * */

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MenuFramentMain extends Fragment{
    private MainActivity activity;
    private String FragName;
    private ArrayList<ButtonItem> buttonData;

    ///
    private Button btnClosePopup;
    private Button btnCreatePopup;
    private PopupWindow pwindo;
    private int mWidthPixels, mHeightPixels;


    public MenuFramentMain(String index){
        FragName = index;
        DataItem item = new DataItem();
        buttonData = item.getData(index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //get layout activity
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.menu_pager_main, container, false);

        ButtonAdapter buttonAdapter = new ButtonAdapter (rootView.getContext(), R.layout.item_button, buttonData, activity);       //create button adapter
                                                     //grid view link

        /*
            Exception: Social media(Popup)
         */
        if(FragName.equals("SocialMedia")){
            //popupset
            //gridviewset
            //setAdapater on gridview

            WindowManager w = activity.getWindowManager();
            Display d = w.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            d.getMetrics(metrics);
            // since SDK_INT = 1;
            mWidthPixels = metrics.widthPixels;
            mHeightPixels = metrics.heightPixels;

            // 상태바와 메뉴바의 크기를 포함해서 재계산
            if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
                try {
                    mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(d);
                    mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(d);
                } catch (Exception ignored) {
                }
            }
            // 상태바와 메뉴바의 크기를 포함
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point realSize = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(d, realSize);
                    mWidthPixels = realSize.x;
                    mHeightPixels = realSize.y;
                } catch (Exception ignored) {
                }
            }
            try {
                LayoutInflater infla = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View layout = infla.inflate(R.layout.activity_pop_up_window, (ViewGroup) activity.findViewById(R.id.popup_element));

                pwindo = new PopupWindow(layout, mWidthPixels - 100, mHeightPixels - 300, true);
                pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
                btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
                btnClosePopup.setOnClickListener(cancel_button_click_listener);

                GridView popgridview = layout.findViewById(R.id.popupgridview);
                popgridview.setAdapter(buttonAdapter);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else{
            GridView gridView = rootView.findViewById(R.id.grid_view);
            gridView.setAdapter(buttonAdapter);
        }
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //now cannot access to activity
        activity = null;
    }


    //extra
    private void initiatePopupWindow() {

    }

    private View.OnClickListener cancel_button_click_listener =
            new View.OnClickListener() {
                public void onClick(View v) {
                    pwindo.dismiss();
                    activity.getSubMenu("Main");
                }
            };

}
