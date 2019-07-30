package com.example.tippecanoe_county_sheriff_app;

/* File name : MenuFragmentMaint.java
 * Description : Menu Fragment for MainActivity's Fragment
 * */

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
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

import java.util.ArrayList;

import static android.util.Log.d;

public class MenuFramentMain extends Fragment{
    /*
    private MainActivity activity;
    //private String FragName;
    private ArrayList<ButtonItem> buttonData;

    */
    private Button btnClosePopup;
    private PopupWindow pwindo;
    private int mWidthPixels, mHeightPixels;

    /*
    public MenuFramentMain(String index){
        //FragName = index;
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

        ButtonAdapter buttonAdapter = new ButtonAdapter (rootView.getContext(), R.layout.item_imagebutton, buttonData, activity);       //create button adapter
        //grid view link

        /*
            Exception: Social media(Popup)
         */
        /*
        if(FragName.equals("SocialMedia")){
            //popupset
            //gridviewset
            //setAdapater on gridview



            } catch (Exception e) { e.printStackTrace(); }
        }
        else{

        }

        GridView gridView = rootView.findViewById(R.id.grid_view);
        gridView.setAdapter(buttonAdapter);
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //now cannot access to activity
        activity = null;
    }*/
}
