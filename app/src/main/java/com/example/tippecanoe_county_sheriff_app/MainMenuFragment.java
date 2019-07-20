package com.example.tippecanoe_county_sheriff_app;

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

public class MainMenuFragment extends Fragment{
    private PageAdapter pageAdapter;
    private MainActivity activity;

    object_item[] Data;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //get layout activity
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.main_view_pager, container, false);

        //view pager allocation
        DataItem itemData = new DataItem();
        Data = itemData.getMainData();
        pageAdapter = new PageAdapter(activity.getSupportFragmentManager(),Data, activity);

        ViewPager viewPager = rootView.findViewById(R.id.main_view_pager);
        viewPager.setAdapter(pageAdapter);

        Log.d(this.getClass().getName(),"frag oncreateview 실행");

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //now cannot access to activity
        activity = null;
    }
}
