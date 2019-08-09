package com.example.tippecanoe_county_sheriff_app.main;

public class MarginCalc {
    private static final float MAX_GRID_PERC = 0.56f;
    private static final float MIN_MARGIN_PERC = 0.02f;
    private float gHoriMargin, gVertMargin;


    public MarginCalc(int mWidthPixels, int mHeightPixels){
        float gridWidth = (float)mWidthPixels;
        float gridHeight = (float)mHeightPixels;

        while(true){
            gVertMargin = (gridHeight* MAX_GRID_PERC - gridWidth)/2f/gridHeight;
            if(gVertMargin< MIN_MARGIN_PERC){ gridWidth -= gridWidth*0.01; }
            else{
                if(gridWidth != mWidthPixels){ gHoriMargin = (1 - gridWidth/mWidthPixels)/2.0f; }
                gVertMargin = (gridHeight* MAX_GRID_PERC - gridWidth)/2f/gridHeight;
                break;
            }
        }
    }

    public float getgHoriMargin() { return gHoriMargin; }

    public float getgVertMargin() { return gVertMargin; }
}
