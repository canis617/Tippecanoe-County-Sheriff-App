package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;

import androidx.annotation.Nullable;

public class ButtonItem {
    private String ButtonName;
    private int ButtonImage;                                                                                    //R.@directory.@imagename
    private Intent func;
    private boolean isConnector;                                                                            //true = High Category
    private String child;                                                                            //Lower Categories

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    ButtonItem(String ButtonName, int ButtonImage, Intent func, boolean isConnector, @Nullable String child){
        this.ButtonName = ButtonName;
        this.ButtonImage = ButtonImage;
        this.func = func;
        this.isConnector = isConnector;
        this.child = child;
    }

    /*public Intent getLinkIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        return intent;
    }*/

    public String getButtonName() { return ButtonName; }

    public void setButtonName(String buttonName) { ButtonName = buttonName; }

    public int getButtonImage() {
        return ButtonImage;
    }

    public void setButtonImage(int buttonImage) {
        this.ButtonImage = buttonImage;
    }

    public Intent getfunc() {
        return func;
    }

    public void setFunc(Intent func) {
        this.func = func;
    }

    public boolean getIsConnector() {
        return isConnector;
    }

    public void setIsConnector(boolean connector) {
        isConnector = connector;
    }


}