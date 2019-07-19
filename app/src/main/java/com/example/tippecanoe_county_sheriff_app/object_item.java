package com.example.tippecanoe_county_sheriff_app;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.Nullable;

public class object_item {
    int bimgage;                                                                                    //R.@directory.@imagename
    String url;
    boolean isConnector;                                                                            //true = High Category
    object_item[] child;                                                                            //Lower Categories

    object_item(int bimage, @Nullable String url, boolean isConnector, @Nullable object_item[] child){
        this.bimgage = bimage;
        this.url = url;
        this.isConnector = isConnector;
        this.child = child;
    }

    public int getBimgage(){return bimgage;}
    public String getUrl(){return url;}
    public boolean getisConnector(){return isConnector;}
    public object_item[] getChild(){return child;}
    public Intent getLinkIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        return intent;
    }

}