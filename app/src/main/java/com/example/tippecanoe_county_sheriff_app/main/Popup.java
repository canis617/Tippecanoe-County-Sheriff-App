package com.example.tippecanoe_county_sheriff_app.main;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.*;

public class Popup extends PopupWindow {
    private Button btnClosePopup;

    public Popup(View view, LayoutInflater inflater, ButtonItem button, float mWidthDp){
        Context context = view.getContext();
        //LayoutInflater infla = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.activity_pop_up_window, (ViewGroup) view.findViewById(R.id.popup_element));

        setContentView(layout);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth((int)(mWidthDp*0.9));
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        showAtLocation(layout, Gravity.CENTER, 0, 0);

        btnClosePopup = layout.findViewById(R.id.btn_close_popup);
        btnClosePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { dismiss(); }
        });
        TextView categorybar = layout.findViewById(R.id.categorybar);
        categorybar.setText(button.getButtonName());

        RecyclerView poprecview = layout.findViewById(R.id.popuprecyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext());
        ButtonAdapter buttonAdapter = new ButtonAdapter(button.getChild());
        poprecview.setLayoutManager(layoutManager);
        poprecview.setAdapter(buttonAdapter);
    }
//                pwindo = new PopupWindow(layout, (int)(mWidthPixels*0.9), ViewGroup.LayoutParams.WRAP_CONTENT, true);

//            pwindo.
//            pwindo.
//

}