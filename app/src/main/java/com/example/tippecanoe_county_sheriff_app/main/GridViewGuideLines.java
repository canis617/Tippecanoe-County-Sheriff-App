package com.example.tippecanoe_county_sheriff_app.main;

import android.view.View;

import androidx.constraintlayout.widget.Guideline;

import com.example.tippecanoe_county_sheriff_app.R;

public class GridViewGuideLines {
    private static final float MAX_GRID_SIZE = 0.6f;
    private Guideline leftvertGL, rightvertGL, tophoriGL, bothoriGL;

    public GridViewGuideLines(View view) {
        leftvertGL = view.findViewById(R.id.ddguideline12);
        rightvertGL = view.findViewById(R.id.ddguideline14);
        tophoriGL = view.findViewById(R.id.dguideline20);
        bothoriGL = view.findViewById(R.id.dguideline4);
    }

    public void setGuidlinesPercent(float gridVMargin, float gridHMargin){
        tophoriGL.setGuidelinePercent((1.0f - MAX_GRID_SIZE) + gridVMargin);
        bothoriGL.setGuidelinePercent(1.0f - gridVMargin);
        leftvertGL.setGuidelinePercent(0.0f + gridHMargin);
        rightvertGL.setGuidelinePercent(1.0f - gridHMargin);
    }
}
