package com.example.tippecanoe_county_sheriff_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class GridViewFrag extends Fragment {
    ArrayList<object_item> data;

    GridViewFrag(ArrayList<object_item> pagedata){
        data = pagedata;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.item_page,container,false);
        Context context = view.getContext();
        ButtonAdapter buttonAdapter = new ButtonAdapter (context, R.layout.item_button,data);
        GridView gv = view.findViewById(R.id.gridview);
        gv.setAdapter(buttonAdapter);
        return view;
    }
}