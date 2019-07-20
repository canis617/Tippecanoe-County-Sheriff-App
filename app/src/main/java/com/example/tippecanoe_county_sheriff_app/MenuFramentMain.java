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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MenuFramentMain extends Fragment{
    private PageAdapter pageAdapter;
    private MainActivity activity;

    private ButtonItem[] Data;

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

        //view pager allocation
        DataItem itemData = new DataItem();
        Data = itemData.getMainData();
        pageAdapter = new PageAdapter(activity.getSupportFragmentManager(),Data, activity);

        ViewPager viewPager = rootView.findViewById(R.id.main_view_pager);
        viewPager.setAdapter(pageAdapter);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //now cannot access to activity
        activity = null;
    }
}
