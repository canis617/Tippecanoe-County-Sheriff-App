package com.example.tippecanoe_county_sheriff_app.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tippecanoe_county_sheriff_app.R;
import com.example.tippecanoe_county_sheriff_app.data.*;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {

    //Data
    ArrayList<ButtonItem> buttonItems = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button textbutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textbutton = itemView.findViewById(R.id.textbutton);
        }
    }

    //Constructor
    public ButtonAdapter(ButtonItem[] buttonItems){
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){
                this.buttonItems.add(tempButton);
            }
        }
    }

    @NonNull
    @Override
    public ButtonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent,false);
        ButtonAdapter.ViewHolder vh = new ButtonAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonAdapter.ViewHolder holder, final int position) {
        holder.textbutton.setText(String.valueOf(buttonItems.get(position).getButtonName()));
        holder.textbutton.setPaintFlags(holder.textbutton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        switch (buttonItems.get(position).getButtonType()){
            case AUTODIAL:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonItems.get(position).getFunc();
                        try { context.startActivity(intent); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                });
                break;
            case LINKTOAPP:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonItems.get(position).getFunc();
                        if(buttonItems.get(position).getButtonName().equals("Instagram")){ intent.setPackage("com.instagram.android"); }
                        //desc

                        Intent Extraintent = buttonItems.get(position).getExtraFunc();
                        try { context.startActivity(intent); }
                        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
                    }
                });
                break;
            case LINKTOSNS:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonItems.get(position).getFunc();
                        if(buttonItems.get(position).getButtonName().equals("Video Visitation")){
                            ComponentName componentName =  new ComponentName("air.com.renovo.vismobile","air.com.renovo.vismobile.AppEntry");
                            intent.addCategory(Intent.CATEGORY_LAUNCHER);
                            intent.setComponent(componentName);
                        }
                        //desc

                        Intent Extraintent = buttonItems.get(position).getExtraFunc();
                        try { context.startActivity(intent); }
                        catch (android.content.ActivityNotFoundException anfe) { context.startActivity(Extraintent); }
                    }
                });
                break;
            case LINKTOWEB:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonItems.get(position).getFunc();
                        try { context.startActivity(intent); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                });
                break;
            case LINKTONEWPAGE:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = buttonItems.get(position).getFunc();
                        intent.putExtra("ButtonName",buttonItems.get(position).getButtonName());
                        context.startActivity(intent);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() { return buttonItems.size(); }
}
