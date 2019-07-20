package com.example.tippecanoe_county_sheriff_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class GridViewFrag extends Fragment {
    ArrayList<object_item> data;
    OnActivityAction listener;

    GridViewFrag(ArrayList<object_item> pagedata, OnActivityAction listener){
        data = pagedata;
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.item_page,container,false);

        ButtonAdapter buttonAdapter = new ButtonAdapter (view.getContext(), R.layout.item_button, data,listener);       //create button adapter
        GridView gv = view.findViewById(R.id.gridview);                                             //grid view link
        gv.setAdapter(buttonAdapter);
        return view;
    }
}