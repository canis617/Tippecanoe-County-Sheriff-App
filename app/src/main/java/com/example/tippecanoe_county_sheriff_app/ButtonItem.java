package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;

import androidx.annotation.Nullable;


enum ButtonType{
    CONTAINER,SINGLEFUNC,DOUBLEFUNC,POPUPCONTAINER,NEWPAGE
}
public class ButtonItem {
    private String ButtonName;
    private int ButtonContent;                                                                                    //R.@directory.@imagename
    private Intent Func;
    private Intent ExtraFunc;
    //private boolean isConnector;                                                                            //true = High Category
    private ButtonType ButtonType;
    private ButtonItem[] child;                                                                            //Lower Categories

    public ButtonItem[] getChild() {
        return child;
    }

    public void setChild(ButtonItem[] child) {
        this.child = child;
    }

    ButtonItem(String ButtonName, int ButtonContent, Intent Func, Intent ExtraFunc, ButtonType ButtonType, @Nullable ButtonItem[] child){
        this.ButtonName = ButtonName;
        this.ButtonContent = ButtonContent;
        this.Func = Func;
        this.ExtraFunc = ExtraFunc;
        //this.isConnector = isConnector;
        this.ButtonType = ButtonType;
        this.child = child;
    }

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

    //public boolean getisConnector() {return isConnector;}

    //public void setisConnector(boolean connector) { isConnector = connector; }

    public Intent getExtraFunc() { return ExtraFunc; }

    public void setExtraFunc(Intent extraFunc) { ExtraFunc = extraFunc; }

    public ButtonType getButtonType() { return ButtonType; }

    //public void setButtonType(String buttonType) {
        //ButtonType = buttonType;
    //}
}