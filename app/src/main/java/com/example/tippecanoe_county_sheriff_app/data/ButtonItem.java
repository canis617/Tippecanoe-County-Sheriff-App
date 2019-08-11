package com.example.tippecanoe_county_sheriff_app.data;

import android.content.Intent;

import androidx.annotation.Nullable;

public class ButtonItem {
    private String ButtonName;
    private int ButtonContent;
    private Intent Func;
    private Intent ExtraFunc;
    private ButtonType ButtonType;
    private ButtonItem[] child;

    //Constructor
    public ButtonItem(String ButtonName, int ButtonContent, Intent Func, @Nullable Intent ExtraFunc, ButtonType ButtonType, @Nullable ButtonItem[] child){
        this.ButtonName = ButtonName;
        this.ButtonContent = ButtonContent;
        this.Func = Func;
        this.ExtraFunc = ExtraFunc;
        this.ButtonType = ButtonType;
        this.child = child;
    }

    //Getter
    public String getButtonName() { return ButtonName; }

    public int getButtonContent() {
        return ButtonContent;
    }

    public Intent getFunc() {
        return Func;
    }

    public Intent getExtraFunc() { return ExtraFunc; }

    public ButtonType getButtonType() { return ButtonType; }

    public ButtonItem[] getChild() {
        return child;
    }

}