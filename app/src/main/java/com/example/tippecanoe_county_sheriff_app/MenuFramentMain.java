package com.example.tippecanoe_county_sheriff_app;

/* File name : MenuFragmentMaint.java
 * Description : Menu Fragment for MainActivity's Fragment
 * */

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MenuFramentMain extends Fragment{
    private MainActivity activity;

    private ArrayList<ButtonItem> buttonData;

    public MenuFramentMain(String index){
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
        GridView gridView = rootView.findViewById(R.id.grid_view);                                             //grid view link
        gridView.setAdapter(buttonAdapter);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //now cannot access to activity
        activity = null;
    }
}
