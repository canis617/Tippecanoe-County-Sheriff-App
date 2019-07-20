package com.example.tippecanoe_county_sheriff_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MenuFragmentSocialMedia extends Fragment {
    private MainActivity activity;
    private PageAdapter pageAdapter;

    object_item[] Data;

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

        //view pager allocation
        DataItem itemData = new DataItem();
        Data = itemData.getSubMenu_SocialMedia();
        pageAdapter = new PageAdapter(activity.getSupportFragmentManager(),Data, activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.menu_pager_social_media,container,false);

        ViewPager viewPager = rootView.findViewById(R.id.sub_view_pager_social_media);
        viewPager.setAdapter(pageAdapter);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

}
