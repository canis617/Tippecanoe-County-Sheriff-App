package com.example.tippecanoe_county_sheriff_app.main;

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

    OnClickEvents onClickEvents;
    //Data
    ArrayList<ButtonItem> buttonItems = new ArrayList<>();

    //ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        Button textbutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textbutton = itemView.findViewById(R.id.textbutton);
        }
    }

    //Constructor
    public ButtonAdapter(ButtonItem[] buttonItems){
        this.buttonItems = arrayToList(buttonItems);
        onClickEvents = new OnClickEvents();
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
                    public void onClick(View v) { onClickEvents.dialOnClick(v,buttonItems.get(position)); }
                });
                break;
            case LINKTOAPP:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.appOnClick(v,buttonItems.get(position)); }
                });
                break;
            case LINKTOSNS:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.snsOnClick(v,buttonItems.get(position)); }
                });
                break;
            case LINKTOWEB:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.webOnClick(v,buttonItems.get(position)); }
                });
                break;
            case LINKTONEWPAGE:
                holder.textbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { onClickEvents.newPageOnClick(v,buttonItems.get(position)); }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() { return buttonItems.size(); }

    private ArrayList<ButtonItem> arrayToList(ButtonItem[] buttonItems){
        ArrayList<ButtonItem> arrayList = new ArrayList<>();
        for(ButtonItem tempButton : buttonItems){
            if(tempButton != null){ arrayList.add(tempButton); }
        }
        return arrayList;
    }
}
