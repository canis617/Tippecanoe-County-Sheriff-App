package com.example.tippecanoe_county_sheriff_app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import static android.util.Log.d;

public class PageAdapter extends FragmentPagerAdapter {
    private int MAX_PAGE;
    private int MAX_BUTTONS;
    private object_item[] itemData;
    private ArrayList<object_item> pageData1 = new ArrayList<>();
    private ArrayList<object_item> pageData2 = new ArrayList<>();
    private ArrayList<object_item> pageData3 = new ArrayList<>();
    private Fragment cur_fragment;
    private OnActivityAction listener;

    public PageAdapter(FragmentManager fm, object_item[] itemData, OnActivityAction listener) {
        super(fm);
        this.itemData = itemData;
        setPageData(itemData);
        this.listener = listener;
    }
    //need 2 fix
    //maybe won't use
    public void setPageData(object_item[] itemData){
        pageData1.clear();
        pageData2.clear();
        pageData3.clear();
        MAX_BUTTONS = 6;
        MAX_PAGE = (itemData.length-1)/MAX_BUTTONS + 1;
        for(int j=0; j< itemData.length  ; j++){
            if(j/MAX_BUTTONS == 0){ pageData1.add(itemData[j]); }
            else if(j/MAX_BUTTONS == 1){ pageData2.add(itemData[j]); }
            else if(j/MAX_BUTTONS == 2){ pageData3.add(itemData[j]); }
            else { d("tipps","too many data"); }
        }
    }

    //Set Each Page's Data At Here
    @Override
    public Fragment getItem(int position) {
        if(position<0 || MAX_PAGE<=position)
            return null;
        switch (position){
            case 0:
                cur_fragment = new GridViewFrag(pageData1,listener);
                break;
            case 1:
                cur_fragment = new GridViewFrag(pageData2,listener);
                break;
            case 2:
                cur_fragment = new GridViewFrag(pageData3,listener);
                break;
        }
        return cur_fragment;
    }
    @Override
    public int getCount() { return MAX_PAGE; }
    //Called when notifyDataSetChanged() activated
    @Override
    public int getItemPosition(Object obj){
        return POSITION_NONE;
    }
}