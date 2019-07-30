package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;

import androidx.annotation.Nullable;

public class ButtonItem {
    private String ButtonName;
    private int ButtonImage;                                                                                    //R.@directory.@imagename
    private Intent Func;
    private Intent ExtraFunc;
    //private boolean isConnector;                                                                            //true = High Category
    private String ButtonType;
    private ButtonItem[] child;                                                                            //Lower Categories

    public ButtonItem[] getChild() {
        return child;
    }

    public void setChild(ButtonItem[] child) {
        this.child = child;
    }

    ButtonItem(String ButtonName, int ButtonImage, Intent Func,Intent ExtraFunc, String ButtonType, @Nullable ButtonItem[] child){
        this.ButtonName = ButtonName;
        this.ButtonImage = ButtonImage;
        this.Func = Func;
        this.ExtraFunc = ExtraFunc;
        //this.isConnector = isConnector;
        this.ButtonType = ButtonType;
        this.child = child;
    }

    public String getButtonName() { return ButtonName; }

    public void setButtonName(String buttonName) { ButtonName = buttonName; }

    public int getButtonImage() {
        return ButtonImage;
    }

    public void setButtonImage(int buttonImage) {
        this.ButtonImage = buttonImage;
    }

    public Intent getFunc() {
        return Func;
    }

    public void setFunc(Intent func) {
        this.Func = func;
    }

    //public boolean getisConnector() {return isConnector;}

    //public void setisConnector(boolean connector) { isConnector = connector; }

    public Intent getExtraFunc() { return ExtraFunc; }

    public void setExtraFunc(Intent extraFunc) { ExtraFunc = extraFunc; }

    public String getButtonType() { return ButtonType; }

    public void setButtonType(String buttonType) {
        ButtonType = buttonType;
    }
}