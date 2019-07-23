package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.Nullable;

public class ButtonItem {
    private int bimage;                                                                                    //R.@directory.@imagename
    private Intent func;
    private boolean isConnector;                                                                            //true = High Category
    private String child;                                                                            //Lower Categories

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    ButtonItem(int bimage, Intent func, boolean isConnector, @Nullable String child){
        this.bimage = bimage;
        this.func = func;
        this.isConnector = isConnector;
        this.child = child;
    }

    /*public Intent getLinkIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        return intent;
    }*/

    public int getBimage() {
        return bimage;
    }

    public void setBimage(int bimage) {
        this.bimage = bimage;
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