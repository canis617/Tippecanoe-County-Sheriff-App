package com.example.tippecanoe_county_sheriff_app.data;

import android.content.Intent;

import androidx.annotation.Nullable;

public class ButtonItem {
    private String ButtonName;
    private int ButtonContent;                                                                      //usually button's image
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

    //Getter and Setter
    //-----------------------------------------------------------------------//
    public String getButtonName() { return ButtonName; }

    public void setButtonName(String buttonName) { ButtonName = buttonName; }

    public int getButtonContent() {
        return ButtonContent;
    }

    public void setButtonContent(int buttonContent) {
        this.ButtonContent = buttonContent;
    }

    public Intent getFunc() {
        return Func;
    }

    public void setFunc(Intent func) {
        this.Func = func;
    }

    public Intent getExtraFunc() { return ExtraFunc; }

    public void setExtraFunc(Intent extraFunc) { ExtraFunc = extraFunc; }

    public ButtonType getButtonType() { return ButtonType; }

    public ButtonItem[] getChild() {
        return child;
    }

    public void setChild(ButtonItem[] child) {
        this.child = child;
    }

}