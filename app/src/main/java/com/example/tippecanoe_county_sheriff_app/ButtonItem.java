package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.Nullable;

public class ButtonItem {
    private int bimage;                                                                                    //R.@directory.@imagename
    private String url;
    private boolean isConnector;                                                                            //true = High Category
    private String child;                                                                            //Lower Categories

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    ButtonItem(int bimage, @Nullable String url, boolean isConnector, @Nullable String child){
        this.bimage = bimage;
        this.url = url;
        this.isConnector = isConnector;
        this.child = child;
    }

    public Intent getLinkIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        return intent;
    }

    public int getBimage() {
        return bimage;
    }

    public void setBimage(int bimage) {
        this.bimage = bimage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getIsConnector() {
        return isConnector;
    }

    public void setIsConnector(boolean connector) {
        isConnector = connector;
    }

}