package com.example.tippecanoe_county_sheriff_app;

/* File name : MenuFragmentAdmin.java
 * Description : Menu Fragment for MainActivity's Fragment
 * */

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MenuFragmentAdmin extends Fragment {

    private MainActivity activity;
    private PageAdapter pageAdapter;

    private ButtonItem[] Data;

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //data initializing when Fragment is created
        DataItem itemData = new DataItem();
        Data = itemData.getSubMenu_Admin();
        pageAdapter = new PageAdapter(activity.getSupportFragmentManager(),Data, activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.menu_pager_admin,container,false);
        ViewPager viewPager = rootView.findViewById(R.id.sub_view_pager_admin);
        viewPager.setAdapter(pageAdapter);
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}
