package com.example.tippecanoe_county_sheriff_app.main;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class GridSetter {
    private static final float MAX_GRID_PERC = 0.56f;
    private static final float MIN_VERTMARG_PERC = 0.02f;
    private static final float DEFAULT_HORIMARG_PERC = 0.05f;
    private float gHoriMargin, gVertMargin;
    private int mWidthPixels, mHeightPixels;
    private float dpHeight, dpWidth;

    GridSetter(Activity activity){
        ScreenSizeCalc(activity);
        GridMarginCalc();
    }

    private void ScreenSizeCalc(Activity activity){
        //get screen size
        WindowManager w = activity.getWindowManager();
        Display display = w.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // since SDK_INT = 1;
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
        dpWidth = mWidthPixels / metrics.density;
        dpHeight = mHeightPixels / metrics.density;

        // 상태바와 메뉴바의 크기를 포함해서 재계산
        if (Build.VERSION.SDK_INT >= 15 && Build.VERSION.SDK_INT < 17) {
            try {
                mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            }
            catch (Exception ignored) { }
        }
        // 상태바와 메뉴바의 크기를 포함
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                mWidthPixels = realSize.x;
                mHeightPixels = realSize.y;
            }
            catch (Exception ignored) { }
        }
    }

    private void GridMarginCalc() {
        float gridWidth = (float)mWidthPixels;
        float gridHeight = (float)mHeightPixels;
        gHoriMargin = DEFAULT_HORIMARG_PERC;

        while(true){
            gVertMargin = (gridHeight* MAX_GRID_PERC - gridWidth)/2f/gridHeight;
            if(gVertMargin < MIN_VERTMARG_PERC){ gridWidth -= gridWidth*0.01; }
            else{
                if(gridWidth != mWidthPixels){ gHoriMargin = (1 - gridWidth/mWidthPixels)/2.0f; }
                gVertMargin = (gridHeight* MAX_GRID_PERC - gridWidth)/2f/gridHeight;
                break;
            }
        }
    }

    //Getter
    public int getmWidthPixels() { return mWidthPixels; }

    public int getmHeightPixels() { return mHeightPixels; }

    public float getDpHeight() { return dpHeight; }

    public float getDpWidth() { return dpWidth; }

    public float getgHoriMargin() { return gHoriMargin; }

    public float getgVertMargin() { return gVertMargin; }
}
