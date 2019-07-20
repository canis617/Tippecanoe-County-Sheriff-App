package com.example.tippecanoe_county_sheriff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnButtonClick{

    TextView logo;
    ImageView mainImage;

    MainMenuFragment fragment1;
    SubMenuFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        setContentView(R.layout.activity_main);

        logo = (TextView)findViewById(R.id.textView);
        logo.setText(R.string.Tippecanoe);

        mainImage=(ImageView)findViewById(R.id.imageView);                                          //set main image
        Drawable myDrawable = getResources().getDrawable(R.drawable.board);
        mainImage.setImageDrawable(myDrawable);

        fragment1 = new MainMenuFragment();
        fragment2 = new SubMenuFragment();

        this.onClick(0);
    }

    @Override
    public void onClick(int index){
        //for debug
        Log.d(this.getClass().getName(),"onClick실행");

        Fragment fr;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(index == -1){
            transaction.remove(fragment2);
            transaction.show(fragment1).commit();
        }
        else if(index == 0 ){
            fr = fragment1;
            transaction.replace(R.id.fragmentContainer, fr);
            transaction.commit();
        } else if(index == 1){
            fr = fragment2;
            transaction.hide(fragment1);
            transaction.add(R.id.fragmentContainer, fr);
            transaction.addToBackStack(fr.getClass().getSimpleName());
            transaction.commit();
        } else{
            fr = fragment1;
            transaction.replace(R.id.fragmentContainer, fr);
            transaction.commit();
        }

    }

    @Override
    public void onBackPressed() {
        Log.d(this.getClass().getName(),Integer.toString(getSupportFragmentManager().getBackStackEntryCount()));
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
            onClick(-1);
        }
    }
}
